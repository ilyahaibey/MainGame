package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GameOver extends JPanel {
    private Image gameOverImage;
    private JPanel perent;


    public GameOver() {
        gameOverImage = new ImageIcon(getClass().getResource("/gameover.png")).getImage();
        this.setLayout(null);
        this.setBounds(0, 0, 1200, 700);
        JButton playAgain = new JButton("play again");
        playAgain.setFont(new Font("Arial", Font.BOLD, 30));
        playAgain.setLayout(null);
        playAgain.setBounds(500, 50, 300, 100);
        this.add(playAgain);

        playAgain.addActionListener(e -> {

            JFrame window = (JFrame) SwingUtilities.getWindowAncestor(this);
            window.getContentPane().removeAll();

            SpaceBackground newGame = new SpaceBackground();
            window.add(newGame);
            window.revalidate();
            window.repaint();
            newGame.requestFocusInWindow();
            newGame.startGame(); // מתחיל את המשחק מחדש
        });
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(gameOverImage, 0, 0, getWidth(), getHeight(), this);
    }


}
