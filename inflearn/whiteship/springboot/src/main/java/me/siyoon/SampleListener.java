package me.siyoon;

import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;

public class SampleListener implements ApplicationListener<ApplicationStartingEvent> {
    @Override
    public void onApplicationEvent(final ApplicationStartingEvent applicationStartingEvent) {
        System.out.println("이벤트 리스너가 실행되었다~!");
    }
}
