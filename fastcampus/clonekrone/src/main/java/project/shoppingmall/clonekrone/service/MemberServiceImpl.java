package project.shoppingmall.clonekrone.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.shoppingmall.clonekrone.domain.Member;
import project.shoppingmall.clonekrone.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {
    private MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Member getMember(String loginId) {
        return memberRepository.getMember(loginId);
    }
}
