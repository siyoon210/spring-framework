package project.shoppingmall.clonekrone.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import project.shoppingmall.clonekrone.domain.Member;
import project.shoppingmall.clonekrone.service.MemberService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@Component
public class ClonekroneUserDetailsService implements UserDetailsService {
    private MemberService memberService;

    public ClonekroneUserDetailsService(MemberService memberService) {
        this.memberService = memberService;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
        Member member = memberService.getMember(loginId);
        if (member == null) {
            throw new UsernameNotFoundException(loginId + " is not found");
        }
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        //아직 권한과 관련한 사항 없음

        UserDetails userDetails = new User(loginId, member.getPassword(),authorities);

        return userDetails;
    }

}
