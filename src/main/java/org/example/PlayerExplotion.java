package org.example;

import javax.swing.*;
import java.awt.*;

public class PlayerExplotion extends JPanel {
    public static final int WIDTH = 150;
    public static final int HEIGHT = 150;
    public static final int X= 0;
    public static final int Y=0;

    private Image[] explosions;
    private int currentFrame = 0;
    private JPanel parent;

    public PlayerExplotion(JPanel parent) {
        this.parent = parent;

        explosions = new Image[]{
                new ImageIcon(getClass().getResource("/explotion1.png")).getImage(),
                new ImageIcon(getClass().getResource("/explotion2.png")).getImage(),
                new ImageIcon(getClass().getResource("/explotion3.png")).getImage()
        };

        setLayout(null);
        setBounds(X, Y, WIDTH, HEIGHT);
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (currentFrame < explosions.length) {
            g.drawImage(explosions[currentFrame], X, Y, getWidth(), getHeight(), this);
        }
    }

    public void startExplosion(int x, int y) {
        setBounds(x, y, WIDTH, HEIGHT);
        parent.add(this);
        parent.setComponentZOrder(this, 0);

        new Thread(() -> {
            try {
                for (int i = 0; i < explosions.length; i++) {
                    currentFrame = i;
                    repaint();
                    Thread.sleep(150);
                }
                parent.remove(this);
                parent.repaint();

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();
    }

}
