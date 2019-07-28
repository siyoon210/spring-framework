package me.siyoon.livebeansettertest;

import lombok.RequiredArgsConstructor;
import me.siyoon.livebeansettertest.Music.Music;
import org.springframework.stereotype.Controller;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class MusicPlayer {
    private final Map<String, Music> music;

    public void playingAllMusic() {
        music.forEach((key, value) -> {
            System.out.println("key = " + key);
            value.playing();
        });
    }
}
