package examples.boot.sunnyboard.repository;

import examples.boot.sunnyboard.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository
        extends JpaRepository<Member, Long> {
}
