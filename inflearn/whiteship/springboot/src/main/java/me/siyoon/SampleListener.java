package me.siyoon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class SampleListener implements ApplicationListener<ApplicationStartedEvent> {
    @Autowired
    private MyProperties properties;

    @Override
    public void onApplicationEvent(final ApplicationStartedEvent applicationStartedEvent) {
        System.out.println("ApplicationStartedEvent가 감지되었다!");

        System.out.println("properties.getJob() = " + properties.getJob());
        System.out.println("properties.getName() = " + properties.getName());
        System.out.println("properties.getLevel() = " + properties.getLevel());
    }
}
