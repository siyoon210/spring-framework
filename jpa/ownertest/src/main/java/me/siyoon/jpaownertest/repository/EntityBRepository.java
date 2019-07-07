package me.siyoon.jpaownertest.repository;

import me.siyoon.jpaownertest.entity.EntityB;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntityBRepository extends JpaRepository<EntityB, Long> {
    EntityB findByName(String name);
}
