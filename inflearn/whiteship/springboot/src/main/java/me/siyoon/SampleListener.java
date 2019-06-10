package me.siyoon;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class SampleListener implements ApplicationListener<ApplicationStartedEvent> {

    @Override
    public void onApplicationEvent(final ApplicationStartedEvent applicationStartedEvent) {
        System.out.println("ApplicationStartedEvent가 감지되었다!");
    }
}
