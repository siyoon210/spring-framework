package me.siyoon.livebeansettertest.Music;

import org.springframework.stereotype.Component;

@Component
public class Music3 implements Music{
    @Override
    public void playing() {
        System.out.println("뮤직3의 신나는 노래");
    }
}
