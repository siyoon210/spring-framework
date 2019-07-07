package me.siyoon.jpaownertest.service;

import me.siyoon.jpaownertest.entity.EntityA;
import me.siyoon.jpaownertest.entity.EntityB;
import me.siyoon.jpaownertest.repository.EntityARepository;
import me.siyoon.jpaownertest.repository.EntityBRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EntityServiceTest {
    @Autowired
    private EntityService entityService;
    @Autowired
    private EntityARepository entityARepository;
    @Autowired
    private EntityBRepository entityBRepository;

    @Test
    public void createEntityTest() {
        String entityAName = "김주인";
        String entityBName = "이종속";

        final EntityA entityA = entityService.createEntityA(entityAName);
        assertThat(entityA.getName()).isEqualTo(entityAName);

        final EntityB entityB = entityService.createEntityB(entityBName);
        assertThat(entityB.getName()).isEqualTo(entityBName);
    }
}