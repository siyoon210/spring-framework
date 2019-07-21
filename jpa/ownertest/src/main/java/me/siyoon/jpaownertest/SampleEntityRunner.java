package me.siyoon.jpaownertest;

import lombok.RequiredArgsConstructor;
import me.siyoon.jpaownertest.entity.EntityA;
import me.siyoon.jpaownertest.entity.EntityB;
import me.siyoon.jpaownertest.repository.EntityARepository;
import me.siyoon.jpaownertest.repository.EntityBRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SampleEntityRunner implements ApplicationRunner {
    private final EntityARepository entityARepository;
    private final EntityBRepository entityBRepository;

    @Override
    public void run(final ApplicationArguments args) throws Exception {
        EntityA entityA = new EntityA();
        entityA.setName("김주인");

        EntityB entityB = new EntityB();
        entityB.setName("이종속");

        entityARepository.save(entityA);
        entityBRepository.save(entityB);

        entityA.setEntityB(entityB);
        entityB.setEntityA(entityA);

        entityARepository.flush();
        entityBRepository.flush();
    }
}
