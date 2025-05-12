package org.example;
import javax.sound.sampled.*;// מיבא מחלקה לניגון קבצי קול
import java.io.File;


public class Sound {
    private Clip clip; //  אובייקט מובנה  שמיצג צליל

    public Sound(String clips){
        try {
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File(clips)));// פותח את הקובץ ישירות מהנתיב שצויין
        } catch (Exception e) {
            System.out.println(clips+"שגיאה");
        }

    }

    public void backgroundMusic() {
        if (clip != null) {
            new Thread(() -> {
                while (true) {
                    clip.setFramePosition(0);
                    clip.start();

                    // מחכה לסיום הצליל
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


    public void explosionSound(){// מנגן את הצליל פעם אחת
        if (clip != null) {
            clip.setFramePosition(0); // מחזיר את הנגן להתחלה (כדי שיתנגן מההתחלה)
            clip.start();             // התחל לנגן
        }
    }

}
