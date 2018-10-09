package chap02;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        //GenericXmlApplicationContext 객체를 이용하여서 파라미터에 있는 경로에 xml을 읽어서 정의되어 있는 객체를 '생성'한다. -> 이걸 '빈bean'객체라고한다.
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");

        //ctx가 만들어준 빈객체를 달라고한다.
        Greeter g = ctx.getBean("greeter", Greeter.class);

        //그 객체를 사용한다.
        String msg = g.greet("스프링");
        System.out.println(msg);
        ctx.close();
    }
}
