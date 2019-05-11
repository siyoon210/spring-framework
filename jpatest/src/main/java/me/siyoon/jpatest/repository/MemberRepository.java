package me.siyoon.jpatest.repository;

import me.siyoon.jpatest.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
