package org.example;

import javax.swing.*;
import java.awt.*;

public class PlayerExplotion extends JPanel {
    public static final int WIDTH = 150;
    public static final int HEIGHT = 150;
    public static final int X= 0;
    public static final int Y=0;

    private Image[] explosions;      // מערך של תמונות הפיצוץ בשלבים
    private int currentFrame = 0;    // באיזה שלב הפיצוץ אנחנו
    private JPanel parent;           // הפאנל הראשי שעליו מצויר הפיצוץ

    public PlayerExplotion(JPanel parent) {
        this.parent = parent;

        // טוען את שלושת התמונות של הפיצוץ לתוך מערך
        explosions = new Image[]{
                new ImageIcon(getClass().getResource("/explotion1.png")).getImage(),
                new ImageIcon(getClass().getResource("/explotion2.png")).getImage(),
                new ImageIcon(getClass().getResource("/explotion3.png")).getImage()
        };

        setLayout(null);
        setBounds(X, Y, WIDTH, HEIGHT);
        setOpaque(false); // חשוב כדי לא להסתיר דברים אחרים
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (currentFrame < explosions.length) {
            g.drawImage(explosions[currentFrame], X, Y, getWidth(), getHeight(), this);
        }
    }

    // כאן מתחילה האנימציה של הפיצוץ
    public void startExplosion(int x, int y) {
        setBounds(x, y, WIDTH, HEIGHT); // מיקום על המסך לפי הפגיעה
        parent.add(this);               // מוסיפים את הפיצוץ למסך
        parent.setComponentZOrder(this, 0); // מביא קדימה למעלה

        new Thread(() -> {
            try {
                for (int i = 0; i < explosions.length; i++) {
                    currentFrame = i; // מחליפים שלב
                    repaint();        // מציירים את הפאנל מחדש
                    Thread.sleep(150); // זמן בין שלבים (200 מילישניות)
                }
                // מסיימים - מסירים את הפאנל מהמסך
                parent.remove(this);
                parent.repaint();

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();
    }

}
