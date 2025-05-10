package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Player extends JPanel   {
    private int x;
    private int y;
    private int width;
    private int height;
    private int speed;
    private int lives;
    private Image playerImage;
    private Gunshot gunshot ;



    public Player() {

        this.width = 150;   // רוחב
        this.height = 150;  // אורך
        this.y = 700 - height;
        this.x = (1200 - width) / 2;
        this.speed = 25;    // מהירות
        this.lives = 3;

        playerImage = new ImageIcon(getClass().getResource("/sapceship.png")).getImage();
        setLayout(null);
        setBounds(x, y, width, height);
        setOpaque(false);

    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(playerImage, 0, 0, getWidth(), getHeight(), this);

    }

    public void move(int dx, int dy) {
        x += dx * speed;
        y += dy * speed;
        if (x < -20) x = -20;
        if (x > 1220 - width) x = 1220 - width;

        if (y < 0) y = 0;
        if (y > 700 - height) y = 700 - height;

        setBounds(x, y, width, height);
        repaint();
    }

    @Override
    public int getY() {
        return y;
    }
    @Override
    public int getX() {
        return x;
    }
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public Rectangle getBounds() {
        int offsetX = 40;
        int offsetY = 20;
        int reducedWidth = getWidth() - 2 * offsetX;
        int reducedHeight = getHeight() - 2 * offsetY;
        return new Rectangle(getX() + offsetX, getY() + offsetY, reducedWidth, reducedHeight);
    }

}








