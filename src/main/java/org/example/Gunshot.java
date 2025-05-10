package org.example;

import javax.swing.*;
import java.awt.*;

public class Gunshot extends JPanel {
    public static final int HEIGHT = 40 ;
    public static final int WIDTH = 100 ;
    public static final int SPEED = 80;
    public static final int  SHOOT_INTERVAL_MS= 50;

        private int y;
        private  int speed = SPEED;
        private  int width = WIDTH;
        private int  height = HEIGHT;
        private Image gunshot;
        private JPanel parent ;

        public Gunshot(int x, int y , JPanel parent ){

            this.parent = parent ;
            this.y=y;
            this.setBounds(x,y,width,height);
            this.gunshot = new ImageIcon(getClass().getResource("/shot.png")).getImage();
            setLayout(null);
            setOpaque(false);
        }

        public boolean isOutOfScreen() {
            return y + height < 0;
        }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(gunshot, 0, 0, getWidth(), getHeight(), this);
    }

    public void shotFromPlayer() {
        new Thread(() -> {
            try {
                while (!isOutOfScreen()) {
                    this.setLocation(getX() , getY()-speed);
                    Thread.sleep(SHOOT_INTERVAL_MS);
                    repaint();
                }

                parent.remove(this);
                parent.repaint();


            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

    public Rectangle getBounds() {
        return new Rectangle(getX(), getY(), getWidth(), getHeight());

    }
}


