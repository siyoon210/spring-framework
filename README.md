﻿# Spring-Framework (Spring Boot)
 
## (21.11.04) Bean Factory로 bean 만들때
- 만약 해당 인스턴스가 InitializingBean 인터페이스를 구현했다면, BeanFactory로 직접 빈을 생성할떄 (beanFactory.initializeBean() 메서드를 호출하여서 생성(init)시에 필요한 설정을 진행한다.
- 직접 생성하지 않는다면 컨테이너가 알아서 관리해준다.
- 비슷한 인터페이스로 빈 객체가 없어질때 DisposableBean가 있다.
- 

```java
public void init(GenericApplicationContext applicationContext) {
    ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();
    beanFactory.registerSingleton(beanName, beanObject);
    beanFactory.initializeBean(beanObject, beanName);
}
```

- 만약 빈에 primary속성을 부여해주고 싶다면 아래와 같이 beanDefinition을 정의한다. (주의사항은 registerSingleton보다 먼저 선언해줘야했다.)
```java 
((DefaultListableBeanFactory) beanFactory).registerBeanDefinition(beanName, BeanDefinitionBuilder.genericBeanDefinition().setPrimary(true).getBeanDefinition());
```

## (20.10.08) Filter vs Interceptor
![SPRING MVC request lifecycle](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=http%3A%2F%2Fcfile24.uf.tistory.com%2Fimage%2F2564124C588F496C01B966)
- 필터는 디스패처 서블릿 이전에 수행된다.
- Filter는 스프링 컨텍스트 이전에 실행되어 스프링과 무관하다.
- 인터셉터는 정확히 핸들러 인터셉터라고 하던데, 말그대로 핸들러(컨트롤러) 전후에 시행된다.
- 하지만 인터셉터의 경우에는 스프링의 DispatcherServlet이 Controller를 호출하기 전,후에 끼어들기 때문에 스프링 컨텍스트(Context,영역) 내부에서 Controller에 관한 요청과 응답에 관여한다. (그리고 스프링의 모든 @Bean에 접근이 가능하다.)

- https://velog.io/@sa833591/Spring-Filter-Interceptor-AOP-%EC%B0%A8%EC%9D%B4-yvmv4k96

## (20.07.19) Node vs Spring MVC
- 노드는 기본적으로 싱글쓰레드 기반이다.
- 스프링 MVC는 멀티쓰레드 기반이다.
- 대신 노드는 비동기-논블러킹 I/O를 이용하기 때문에 다중처리가 가능하다.

- 싱글쓰레드 기반의 장점
    1. 적은 리소스로도 다중 작업을 처리할 수 있다.
    
- 멀티쓰레드 기반의 장점
    1. cpu intensive한 작업들이 있을 경우 별도의 쓰레드가 존재하기 때문에 유리하다.

## (20.03.14) HTTP API 설계하기
1. Best practice for RESTful API design is that path params are used to identify a specific resource or resources, while query parameters are used to sort/filter those resources.
	- path param은 리소스를 identify 할 수 있는 값을 넣어야 한다. 
	- query param은 정렬이나 필터링을 하기 위해서 사용한다.
2. Therefore, the URI should only consist of parts that will never change and will continue to uniquely identify that resource throughout its lifetime.
	- 좀 더 직관적인 관점, URI는 절대로 변하지 않아야 한다. 
	- 즉 언제든지 변경 가능한 값은 path param으로 사용하기 적절하지 않다. 예를들어 순서(seqeunce)라든지, 변경가능한 attribute들

### API응답시에 어떤 값까지 다 줘야할까?
- 모든 세부적인 상황을 대비하여 모든 URL을 대비하는 것은 너무 많은 작업량으로 이어진다.
- 결국 API를 한번 요청하고 응답하는 순간에 **'적절한'양의 데이터**를 한번에 내려줘야한다. 
너무 데이터가 많아서 불필요한 정보를 다 내려준다던가, 너무 적은 데이터만을 내려주어서 사용자의 매 이벤트마다 API를 다시 호출해야하는 일은 없어야 한다. 이는 도메인지식을 기반으로 설계될 것이다.
그 외에도 변동성이 민감한 정보들은 사용자가 이벤트를 진행 할때마다 업데이트 해줘야 할 것이고, 그렇지 않다면 한번에 응답으로 모두 대체해야 할 것이다. 


## (20.03.01) webjars
- /webjars/** 로 매핑되어있는 웹 자르 파일들 (예를 들어 제이쿼리나 부트스트랩)의 의존성을 넣고 /webjars/** 경로로 찾아 들어가면 쉽게 사용 할 수 있다.
    - 경로상의 버전을 생략하고 싶다면 webjars-locator-core 의존성을 추가한다.
    
### 설정예제    
```
implementation 'org.webjars:webjars-locator-core'
implementation 'org.webjars:sockjs-client:1.0.2'
implementation 'org.webjars:stomp-websocket:2.3.3'
implementation 'org.webjars:bootstrap:3.3.7'
implementation 'org.webjars:jquery:3.1.1-1'
```

### 사용예제
```
<link href="/webjars/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="/main.css" rel="stylesheet">
<script src="/webjars/jquery/jquery.min.js"></script> 
<script src="/webjars/sockjs-client/sockjs.min.js"></script>
```

## (20.02.28) Websocket (웹소켓)
- Websocket은 HTTP와 같은 **통신 프로토콜**이다.

### HTTP와 유사점
1. OSI 모델 7계층에 위치하며 4계층 TCP에 의존한다.
2. 대부분의 브라우저가 지원한다.

### HTTP와 다른점
1. 전이중 통신을 한다. (HTTP는 반이중 방식)

HTTP는 클라이언트가 서버에게 요청하고 이에 응답하는 방식이지만, 웹소켓은 서버가 클라이언트에게 메시지를 보낼 수 있다.

### STOMP?
웹소켓의 메시지를 어떤식으로 다룰지에 대핸 서브 프로토콜이다. 클라이언트와 서버가 어떤식으로 메시지를 해석해야 할지에 대한 약속이 필요하기 떄문이다.

#### STOMP 메시지 예제
```
    SEND
    destination:/queue/trade
    content-type:application/json
    content-length:44
     
    {"action":"BUY","ticker":"MMM","shares",44}^@
```
```
    SUBSCRIBE
    id:sub-1
    destination:/topic/price.stock.*
     
    ^@
```
```
    MESSAGE
    message-id:nxahklf6-1
    subscription:sub-1
    destination:/topic/price.stock.MMM
     
    {"ticker":"MMM","price":129.45}^@
```
    
## (20.02.24) Websocket 프로토콜 다루기
0. 스프링 의존 설정
```
dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-websocket'
    implementation 'org.webjars:webjars-locator-core' //webjar로 다루기 위한 의존 설정
    implementation 'org.webjars:sockjs-client:1.0.2'
    implementation 'org.webjars:stomp-websocket:2.3.3'
    ...
```

1. Websocket 관련 설정(config)하기
```
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/websocket").withSockJS(); //최초 소켓 연결시에 사용하는 엔드포인트 (SockJS를 사용하겠다는 뜻)
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.setApplicationDestinationPrefixes("/app"); //클라이언트가 서버로 메시지를 보낼때 사용하는 주소 prefix
        registry.enableSimpleBroker("/topic"); //서버가 클라이언트로 메시지를 보낼때 사용하는 주소 prefix
    }
}
```

2. 핸들링할 컨트롤러 선언하기
```
@Controller
public class GreetingController {
    @MessageMapping("/hello") //위에 설정한 prefix를 포함해서 /app/hello라고 요청해줘야 한다.
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) {
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()));
    }
}
```

3. JS로 요청보내기
```
var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect() {
    var socket = new SockJS('/websocket');
    stompClient = Stomp.over(socket);
    // SockJS와 stomp client를 통해 연결을 시도.
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/greetings', function (greeting) {
            showGreeting(JSON.parse(greeting.body).content);
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendName() {
    // /app/hello로 JSON 파라미터를 메세지 body로 전송.
    stompClient.send("/app/hello", {}, JSON.stringify({'name': $("#name").val()}));
}

function showGreeting(message) {
    $("#greetings").append("<tr><td>" + message + "</td></tr>");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendName(); });
});
```


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
