package me.siyoon.livebeansettertest.Music;

import org.springframework.stereotype.Component;

@Component(value = "muzic1")
public class Music1 implements Music{
    @Override
    public void playing() {
        System.out.println("뮤직1의 흥겨운 노래");
    }
}
