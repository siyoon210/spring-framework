package me.siyoon.jpatest;

import me.siyoon.jpatest.domain.Member;
import me.siyoon.jpatest.domain.Team;
import me.siyoon.jpatest.repository.MemberRepository;
import me.siyoon.jpatest.repository.TeamRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyTest {
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    TeamRepository teamRepository;

    @Before
    public void initData() {
        Team team = Team.builder().id(1L).name("활빈당").build();
        teamRepository.save(team);
        Member member = Member.builder().id(1L).name("홍길동").team(team).build();
        memberRepository.save(member);
    }

    @Test
    @Transactional
    public void tryToSetFromOwner() {
        Member member = memberRepository.findById(1L).get();
        System.out.println("member.getName() = " + member.getName());

        member.setName("임꺽정");
        member.getTeam().setName("우산국");
        memberRepository.flush();
    }

    @Test
    @Transactional
    public void tryToSetFromInverseSideOfOwner() {
//        Team team = Team.builder().id(1L).name("활빈당").build();
//        teamRepository.save(team);
//        Member member = Member.builder().id(1L).name("홍길동").team(team).build();
//        memberRepository.save(member);


        Member member = memberRepository.findById(1L).get();

        Team team = teamRepository.findById(1L).get();
        System.out.println("team.getName() = " + team.getName());
        team.setName("우산국");

        System.out.println("member.getName() = " + member.getName());
        for (Member teamMember : team.getMembers()) {
            System.out.println(teamMember);
        }

        memberRepository.flush();
    }
}
