package me.siyoon.livebeansettertest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MusicPlayerTest {
    @Autowired
    private MusicPlayer musicPlayer;

    @Test
    public void playingAllMusic() {
        musicPlayer.playingAllMusic();
    }

    @Test
    public void playingSpecificMusic() {
        String name = "muzic1";

        musicPlayer.playingSpecificMusic(name);
    }
}