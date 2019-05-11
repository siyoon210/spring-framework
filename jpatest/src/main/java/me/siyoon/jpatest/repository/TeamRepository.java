package me.siyoon.jpatest.repository;

import me.siyoon.jpatest.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
