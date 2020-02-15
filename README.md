# Spring-Framework (Spring Boot)

## (20.02.15) @Transactional(readOnly = true)
- 트랜잭션을 읽기 전용으로 설정할 수 있다.
- 성능을 최적화하기 위해 사용할 수도 있고 특정 트랜잭션 작업 안에서 쓰기 작업이 일어나는 것을 의도적으로 방지하기 위해 사용할 수도 있다. 
- JPA의 더티체킹이 진행되지 않는다.


## (19.12.22) @Transactional이 롤백시키는 익셉션
- Spring에서 선언적 트랜잭션은 기본적으로 Unchecked Exception에서만 발생한다.
- @Transactional(rollbackFor = Exception.class) rollbackFor 옵션을 사용하면 모든 Exception에 대해서 롤백처리 하게 할 수 있다.

## (19.12.21) @Transactional 전파 레벨 옵션
### @Transactional(propagation = Propagation.REQUIRED)
- 기본 디펄트 값으로 설정되어 있다.
- 호출한곳에서 트랜잭션이 없는 경우
    - 새로운 트랜잭션을 시작한다.
- 호출한곳에서 트랜잭션이 존재한 경우
    - 새로운 트랜잭션을 시작하지 않는다.
    
### @Transactional(propagation = Propagation.REQUIRES_NEW)
- 매번 새로운 트랜잭션을 시작한다.

### @Transactional(propagation = Propagation.NESTED)
- REQUIRED와 비슷하지만 SAVEPOINT를 지정한 시점까지 부분 롤백이 가능하다.

## (19.11.07) 스프링부트에서 비동기메소드 만들기
1. 설정 컴포넌트에 @EnableAsync 애노테이션을 달아준다.
```
@Configuration
@EnableAsync
public class AsyncConfig {
    ...
}
```
- @EnableAsync 애노테이션이 달린 설정 컴포넌트가 없다면 @Async 애노테이션 달려 있어도 동기적으로 작동한다.

2. 비동기적 호출을 원하는 메소드에 @Async 애노테이션을 달아준다.
```
@Async
public void myAsyncMethod() {
	...
}
```

3. 만약 리턴값이 존재한다면 Future<> 타입의 감싸서 반환하다.
```
@Async
public Future<String> myAsyncMethod() {
    return AsyncResult.forValue(...);
}
```

**비동기적으로 호출한다는 것은 결국 다른 쓰레드에게 작업을 일임한다는 뜻이다.**
