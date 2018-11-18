package examples.boot.springboard.service;

import examples.boot.springboard.dao.MemberDao;
import examples.boot.springboard.dto.Member;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberServiceImpl implements MemberService {
    private MemberDao memberDao;

    public MemberServiceImpl(MemberDao memberDao){
        this.memberDao = memberDao;
    }

    @Override
    @Transactional
    public Member addMember(Member member) {
        Long id = memberDao.addMember(member);
        member.setId(id);
        return member;
    }

    @Override
    @Transactional
    public Member getMember(String email) {
        Member member = memberDao.getMember(email);
        return member;
    }


}
