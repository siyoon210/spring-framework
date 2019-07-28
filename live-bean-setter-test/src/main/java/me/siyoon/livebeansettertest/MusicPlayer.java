package me.siyoon.livebeansettertest;

import lombok.RequiredArgsConstructor;
import me.siyoon.livebeansettertest.Music.Music;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
@RequiredArgsConstructor
public class MusicPlayer {
//    private final Set<Music> music;
    private final List<Music> music;
//    private final Map<String, Music> music;

    public void playingAllMusic() {
//        music.forEach((key, value) -> {
//            System.out.println("key = " + key);
//            value.playing();
//        });

        music.forEach(Music::playing);
    }
}
