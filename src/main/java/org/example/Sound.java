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

    public void backgroundMusic(){// מתודה למוזיקת רקע
        if(clip!=null){// רק אם הצליל נטען בהצלחה
            clip.loop(Clip.LOOP_CONTINUOUSLY);// מגדיר לנגן שוב ושוב בלי סוף
            clip.start(); // התחל לנגן
        }
    }


    public void explosionSound(){// מנגן את הצליל פעם אחת
        if (clip != null) {
            clip.setFramePosition(0); // מחזיר את הנגן להתחלה (כדי שיתנגן מההתחלה)
            clip.start();             // התחל לנגן
        }
    }

    // עוצר את הצליל – מתאים כשרוצים לעצור את מוזיקת הרקע או צליל מתמשך
    public void stop() {
        if (clip != null && clip.isRunning()) {
            clip.stop(); // עצור את הצליל
        }
    }


}
