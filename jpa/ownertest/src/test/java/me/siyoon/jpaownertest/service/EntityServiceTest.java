package me.siyoon.jpaownertest.service;

import me.siyoon.jpaownertest.entity.EntityA;
import me.siyoon.jpaownertest.entity.EntityB;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EntityServiceTest {
    @Autowired
    private EntityService entityService;

    private String entityAName = "김주인";
    private String entityBName = "이종속";

    @Test
    public void createEntityTest() {
        final EntityA entityA = entityService.createEntityA(entityAName);
        assertThat(entityA.getName()).isEqualTo(entityAName);

        final EntityB entityB = entityService.createEntityB(entityBName);
        assertThat(entityB.getName()).isEqualTo(entityBName);
    }

    @Test
    public void setOwnerTest() {
        final EntityA entityA = entityService.setOwner(entityAName, entityBName);

        assertThat(entityA.getEntityB().getName()).isEqualTo(entityBName);
    }
}