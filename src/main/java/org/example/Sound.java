package org.example;
import javax.sound.sampled.*;
import java.io.File;


public class Sound {
    private Clip clip;

    public Sound(String clips){
        try {
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File(clips)));
        } catch (Exception e) {

        }
    }

    public void backgroundMusic() {
        if (clip != null) {
            new Thread(() -> {
                while (true) {
                    clip.setFramePosition(0);
                    clip.start();

                    while (clip.isRunning()) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            break;
                        }
                    }
                }
            }).start();
        }
    }


    public void explosionSound(){
        if (clip != null) {
            clip.setFramePosition(0);
            clip.start();
        }
    }

}
