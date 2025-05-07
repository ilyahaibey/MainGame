package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class ObstacleOfAsteroid extends JPanel {
    private int x;
    private int y;
    private Image AsteroidPhoto;
    private Image AsteroidPhotoTwo;
    private Image AsteroidPhotoTree;
    private int width;
    private int height;
    private int speed = 7;
    private JPanel parent;
    private int counterOfShooting = 0;
    private Image currentImage;




    public ObstacleOfAsteroid(JPanel parent) {
        this.parent = parent;
        Random random = new Random();

        AsteroidPhoto = new ImageIcon(getClass().getResource("/asteroid.png")).getImage();
        AsteroidPhotoTwo = new ImageIcon(getClass().getResource("/asteroid-2.png")).getImage();
        AsteroidPhotoTree = new ImageIcon(getClass().getResource("/asteroid3.png")).getImage();

        this.currentImage = AsteroidPhoto ;

        this.x = random.nextInt(0, 1200);
        this.height = random.nextInt(100, 200);
        this.width = random.nextInt(100, 200);
        this.y = -height;
        setLayout(null);
        setBounds(x, y, width, height);
        setOpaque(false);

    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(this.currentImage, 0, 0, getWidth(), getHeight(), this);

    }

    public boolean isOutOfScreen() {
        return getY() > parent.getHeight();
    }

    public void addInAsteroid() {
        new Thread(() -> {
            try {
                while (!isOutOfScreen()) {
                    this.setLocation(getX(), getY() + speed);
                    Thread.sleep(80);
                    repaint();
                    changePhoto();
                }
                parent.remove(this);
                repaint();

            } catch (Exception e) {
                throw new RuntimeException(e);

            }

        }).start();
    }

    @Override
    public Rectangle getBounds() {
        int offsetX = (int) (width * 0.15);  // 15% מהצדדים
        int offsetY = (int) (height * 0.15); // 15% מלמעלה ומלמטה
        int reducedWidth = width - 2 * offsetX;
        int reducedHeight = height - 2 * offsetY;
        return new Rectangle(getX() + offsetX, getY() + offsetY, reducedWidth, reducedHeight);

    }

    public int getCounterOfShooting() {
        return this.counterOfShooting;

    }

    public void counter() {
        this.counterOfShooting++;
    }
    public void changePhoto(){
        if (this.counterOfShooting == 3){
            this.currentImage = AsteroidPhotoTwo ;
            repaint();

        }
        if (this.counterOfShooting == 6){
            this.currentImage = AsteroidPhotoTree ;
        }


    }


}













