package me.siyoon.livebeansettertest;

import lombok.RequiredArgsConstructor;
import me.siyoon.livebeansettertest.Music.Music;
import org.springframework.stereotype.Controller;

import java.util.Set;

@Controller
@RequiredArgsConstructor
public class MusicPlayer {
    private final Set<Music> music;

    public void playingAllMusic() {
        music.forEach(Music::playing);
    }
}
