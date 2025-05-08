package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static final int WIDTH = 1200;
    public static final int HEIGHT = 700;
    public static final  StartScreen[] startScreen = new StartScreen[1];// יצירת מערך בגודל 1 שמכיל את מסך הפתיחה זה מאפשר גישה אליו מתוך המחלקה

    public static void main(String[] args) {
        JFrame window = new JFrame("Space Game");
        window.setSize(WIDTH, HEIGHT);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setLayout(null);
        window.setResizable(false);


        SpaceBackground background = new SpaceBackground();
//        window.add(background);
        ///
        startScreen[0] = new StartScreen(e -> {
            window.remove(startScreen[0]);
            window.add(background);
            window.revalidate();
            window.repaint();
            background.requestFocusInWindow(); // כדי שהמקלדת תעבוד
        });

        startScreen[0].setBounds(0, 0, WIDTH, HEIGHT);
        window.add(startScreen[0]);

        Sound sound1= new Sound("src/main/resources/sound2.wav");
        sound1.backgroundMusic();




//        startScreen[0] = new StartScreen(new ActionListener() { // יצירת אובייקט של מסך הפתיחה עם מאזין לחיצה על כפתור התחלה
//            public void actionPerformed(ActionEvent e){// פעולות כשאר לוחצים על כפתור ההחל
//                window.remove(startScreen[0]);// הסרת המסך הפתיחה מהחלון
//                window.add(background);//הוספת מסך המשחק במקום
//                window.revalidate();//עדכון מבנה המסך החדש
//                window.repaint();//רענון גרפי של המסך
//                background.requestFocusInWindow();// נותן פוקוס למסך המשחק
//
//            }
//
//        });
//
//       // startScreen[0].setBounds(0, 0, WIDTH, HEIGHT);// קביעת גודל
//        //window.add(startScreen[0]); // הוספת מסך הפתיחה לחלון

       window.setVisible(true);


        window.repaint();
        window.revalidate();
    }
}