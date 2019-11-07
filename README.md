# Spring-Framework (Spring Boot)

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

**비동기적으로 호출한다는 것은 결국 다른 쓰레드에게 작업을 일임한다는 뜻이다.**
