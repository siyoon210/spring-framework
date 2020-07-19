# Spring-Framework (Spring Boot)

## (20.07.19) Node vs Spring MVC
- 노드는 기본적으로 싱글쓰레드 기반이다.
- 스프링 MVC는 멀티쓰레드 기반이다.
- 대신 노드는 비동기-논블러킹 I/O를 이용하기 때문에 다중처리가 가능하다.

- 싱글쓰레드 기반의 장점
    1. 적은 리소스로도 다중 작업을 처리할 수 있다.
    
- 멀티쓰레드 기반의 장점
    1. cpu intensive한 작업들이 있을 경우 별도의 쓰레드가 존재하기 때문에 유리하다.

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
