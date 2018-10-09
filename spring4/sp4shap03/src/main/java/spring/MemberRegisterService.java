package spring;

import java.util.Date;

public class MemberRegisterService {
    private MemberDao memberDao;

    public MemberRegisterService(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public void regist(RegisterRequest request) {
        Member member = memberDao.selectByEmail(request.getEmail());
        if (member != null) {
            throw new AlreadyExistingMemberException("dup email" + request.getEmail());
        }

        Member newMember = new Member(request.getEmail(), request.getPassword(), request.getName(), new Date());
        memberDao.insert(newMember);
    }
}
