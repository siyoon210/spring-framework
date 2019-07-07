package me.siyoon.jpaownertest.repository;

import me.siyoon.jpaownertest.entity.EntityA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntityARepository extends JpaRepository<EntityA, Long> {
    EntityA findByName(String name);
}
