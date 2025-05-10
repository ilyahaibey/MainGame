package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GameOver extends JPanel {

    public static final int X = 0;
    public static final int Y = 0;
    public static final int X_PLAYAGAIN = 450;
    public static final int Y_PLAYAGAIN = 30;
    public static final int WIDTH_PLAYAGAIN = 300;
    public static final int HEIGHT_PLAYAGAIN = 220;
    public static final int WIDTH = 1200;
    public static final int HEIGHT = 700;

    
    private Image gameOverImage;

    public GameOver() {
        gameOverImage = new ImageIcon(getClass().getResource("/gameover1.png")).getImage();
        this.setLayout(null);
        this.setBounds(X, Y,WIDTH, HEIGHT);

        ImageIcon originalIcon = new ImageIcon(getClass().getResource("/buttom.png")); // טוען את התמונה המקורית
        Image img = originalIcon.getImage();
        Image scaledImg = img.getScaledInstance(WIDTH_PLAYAGAIN,HEIGHT_PLAYAGAIN, Image.SCALE_SMOOTH); // מקטין לגודל הכפתור
        ImageIcon scaledIcon = new ImageIcon(scaledImg); // יוצר תמונה חדשה מוקטנת

        JButton playAgain = new JButton(scaledIcon); // יוצר כפתור עם תמונה בגודל נכון
        playAgain.setBounds(X_PLAYAGAIN, Y_PLAYAGAIN, WIDTH_PLAYAGAIN, HEIGHT_PLAYAGAIN); // מיקום וגודל מותאם לראש המסך
        playAgain.setContentAreaFilled(false); // לא למלא רקע
        playAgain.setBorderPainted(false);     // בלי מסגרת
        playAgain.setFocusPainted(false);      // בלי גבול כשנלחץ

        this.add(playAgain);

        playAgain.addActionListener(e -> {
            JFrame window = (JFrame) SwingUtilities.getWindowAncestor(this);

            window.getContentPane().removeAll();
            SpaceBackground newGame = new SpaceBackground();
            window.add(newGame);
            window.revalidate();
            window.repaint();
            newGame.requestFocusInWindow();
            newGame.startGame();
        });
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(gameOverImage, X, Y, getWidth(), getHeight(), this);
    }

}
