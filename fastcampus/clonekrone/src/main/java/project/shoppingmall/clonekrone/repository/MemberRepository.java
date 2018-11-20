package project.shoppingmall.clonekrone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import project.shoppingmall.clonekrone.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
    @Query(value = "SELECT m FROM Member m WHERE m.loginId = :loginId")
    Member getMember(@Param("loginId")String email);
}

