package me.siyoon.asynctest;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableAsync //설정에 이 애노테이션이 없으면 @Async 애노테이션이 붙어 있어도 동기적으로 작동하는구나!
public class AsyncConfig {
}
