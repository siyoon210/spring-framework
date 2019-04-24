package com.tacademy.jpaprogramming;

import com.tacademy.jpaprogramming.entity.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        //이름이 hello 라고 되어있는 설정을 가져와서, 그 설정으로 엔티티 매니저 팩토리 만들기

        EntityManager entityManager = emf.createEntityManager();
        //엔티티 매니저 만들기 (실제로는 요청이 들어 올때 마다 엔티티매니저를 만들어서 사용한다.)

        EntityTransaction transaction = entityManager.getTransaction();
        //엔티티 매니저는 트랜잭션 내에서 사용되어야 하기 때문에, 트랜잭션을 만든다.

        transaction.begin();
        //트랜잭션 시작

        try {
            Member member = new Member();
            member.setId(100L);
            member.setName("홍길동");
            //저장할 member 객체

            entityManager.persist(member);
            //엔티티 매니저를 이용해서 member 객체 저장하기 (영속화 시키기)

            transaction.commit();
            //트랜잭션 커밋으로 끝내기
        } catch (Exception e) {
            transaction.rollback();
            //예외 발생시 롤백시키기
        } finally {
            entityManager.close();
            //엔티티 매니저 닫기
        }

        emf.close();
        //엔티티 매니저 팩토리 닫기
        //emf 는 애플리케이션이 끝날때 닫는다.
    }
}
