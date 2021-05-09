package me.siyoon.springbootlambdatest.component;

import org.springframework.stereotype.Component;

@Component
public class LowerCaseHelper {
    public String toLowerCase(String string) {
        return string.toLowerCase();
    }
}
