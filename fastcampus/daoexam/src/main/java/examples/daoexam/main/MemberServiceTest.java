package examples.daoexam.main;

import examples.daoexam.config.ApplicationConfig;
import examples.daoexam.dto.Board;
import examples.daoexam.dto.Member;
import examples.daoexam.service.BoardService;
import examples.daoexam.service.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;

public class MemberServiceTest {
    public static void main(String[] args) {
        ApplicationContext ac =
                new AnnotationConfigApplicationContext(ApplicationConfig.class);

        MemberService memberService = ac.getBean(MemberService.class);

//        Member member = new Member();
//        member.setEmail("siyoon210@naver.com");
//        member.setName("siyoon");
//        member.setPassword("1234");
//        member.setRegdate(new Date()); // java.util.Date
//
//        Member result = memberService.addMember(member);
//        System.out.println(result);

//        Member member = memberService.getMember("siyoon210@naver.com");
//        System.out.println(member.toString());
    }
}
