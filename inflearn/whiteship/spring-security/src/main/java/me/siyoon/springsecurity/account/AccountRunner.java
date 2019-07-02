package me.siyoon.springsecurity.account;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * 임의의 유저정보를 넣기 위한 러너
 */
@Component
@RequiredArgsConstructor
public class AccountRunner implements ApplicationRunner {
    private final AccountService accountService;

    @Override
    public void run(final ApplicationArguments args) throws Exception {
        final Account siyoon = accountService.createAccount("siyoon", "1234");
        System.out.println(siyoon.toString());
    }
}
