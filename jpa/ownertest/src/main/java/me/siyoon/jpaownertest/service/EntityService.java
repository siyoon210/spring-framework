package me.siyoon.jpaownertest.service;

import lombok.RequiredArgsConstructor;
import me.siyoon.jpaownertest.entity.EntityA;
import me.siyoon.jpaownertest.entity.EntityB;
import me.siyoon.jpaownertest.repository.EntityARepository;
import me.siyoon.jpaownertest.repository.EntityBRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EntityService {
    private final EntityARepository entityARepository;
    private final EntityBRepository entityBRepository;

    void createEntityA(String name) {
        EntityA entityA = new EntityA();
        entityA.setName(name);

        entityARepository.save(entityA);
    }

    void createEntityB(String name) {
        EntityB entityB = new EntityB();
        entityB.setName(name);

        entityBRepository.save(entityB);
    }
}
