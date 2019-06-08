package me.siyoon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SingleManRunner implements ApplicationRunner {
    @Autowired
    private SingleMan singleMan;
    //지금 이프로젝트에는 싱글맨이 없는대도 불구하고 주입이 된다.
    //자동 설정이 되어 있기 때문이다.

    @Override
    public void run(final ApplicationArguments args) throws Exception {
        System.out.println("singleMan = " + singleMan);
    }
}
