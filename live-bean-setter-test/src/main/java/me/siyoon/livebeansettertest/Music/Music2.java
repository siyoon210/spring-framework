package me.siyoon.livebeansettertest.Music;

import org.springframework.stereotype.Component;

@Component
public class Music2 implements Music{
    @Override
    public void playing() {
        System.out.println("뮤직2의 즐거운 노래");
    }
}
