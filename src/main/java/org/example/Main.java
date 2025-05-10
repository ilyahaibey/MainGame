package org.example;

import javax.swing.*;

public class Main {
    public static final int WIDTH = 1200;
    public static final int HEIGHT = 700;


    public static void main(String[] args) {
        JFrame window = new JFrame("Space Game");
        window.setSize(WIDTH, HEIGHT);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setLayout(null);
        window.setResizable(false);

        SpaceBackground background = new SpaceBackground();

        // שימוש במערך כדי שנוכל לגשת ל-startScreen בתוך הלמבדות
        StartScreen[] startScreen = new StartScreen[1];

        startScreen[0] = new StartScreen(
                e -> {
                    // לוגיקה עבור כפתור Start Game
                    window.remove(startScreen[0]);
                    window.add(background);
                    window.revalidate();
                    window.repaint();
                    background.requestFocusInWindow(); // כדי שהמקלדת תעבוד
                    background.startGame();
                },
                e -> {
                    // לוגיקה עבור כפתור Instructions
                    JOptionPane.showMessageDialog(window,
                            "הוראות המשחק:\nהזז את החללית עם החצים\nירה עם מקש רווח!");
                }
        );

        startScreen[0].setBounds(0, 0, WIDTH, HEIGHT);
        window.add(startScreen[0]);
        window.setVisible(true);
    }
//    Sound sound=new Sound();
//    Sound
}