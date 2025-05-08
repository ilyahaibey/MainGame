package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class SpaceBackground extends JPanel implements KeyListener {
    private Image backgroundImage;
    private Player playerRocet;
    private ArrayList<Gunshot> shots;
    private ArrayList<ObstacleOfAsteroid> asteroids;
    private ArrayList<Life> lifes;
    private boolean gameOverShown = false;

    public SpaceBackground() {
        backgroundImage = new ImageIcon(getClass().getResource("/space1.png")).getImage();
        this.setLayout(null);
        this.setBounds(0, 0, 1200, 700);

        playerRocet = new Player();
        this.add(playerRocet);
        playerRocet.setLocation(600, 700);
        playerRocet.setFocusable(true);
        playerRocet.requestFocusInWindow();

        shots = new ArrayList<>();
        asteroids = new ArrayList<>();
        lifes = new ArrayList<>();

        this.setFocusable(true);
        this.addKeyListener(this);
        this.requestFocusInWindow();

        treeLife();
        addAsteroids();       // מתחיל להציף אסטרואידים
        playerDead();         // מתחיל לבדוק התנגשות
        hittingInAsteroid();  // בודק התנגשות כדור בסטרואיד
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) playerRocet.move(-1, 0);
        if (key == KeyEvent.VK_RIGHT) playerRocet.move(1, 0);
        if (key == KeyEvent.VK_UP) playerRocet.move(0, -1);
        if (key == KeyEvent.VK_DOWN) playerRocet.move(0, 1);

        if (key == KeyEvent.VK_SPACE) {
            Gunshot shot = new Gunshot(playerRocet.getX() + 25, playerRocet.getY() + 40, this);
            shots.add(shot);
            this.add(shot);
            shot.shotFromPlayer();
            repaint();
        }


    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    public void addAsteroids() {
        new Thread(() -> {
            try {
                while (!gameOverShown) {
                    ObstacleOfAsteroid asteroid = new ObstacleOfAsteroid(this);
                    asteroids.add(asteroid);
                    this.add(asteroid);
                    asteroid.addInAsteroid();

                    // מסיר אסטרואידים שיצאו מהמסך
                    asteroids.removeIf(ObstacleOfAsteroid::isOutOfScreen);
                    repaint();

                    Thread.sleep(2000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();
    }

    public void playerDead() {
        new Thread(() -> {
            try {
                while (!gameOverShown) {
                    for (ObstacleOfAsteroid asteroid : asteroids) {
                        if (!lifes.isEmpty()) {
                            if (playerRocet.getBounds().intersects(asteroid.getBounds())) {
                                System.out.println("ONE");

                                PlayerExplotion explosion = new PlayerExplotion(this);

                                add(explosion);
                                explosion.startExplosion(playerRocet.getX(), playerRocet.getY());

                                removeAllAsteroid();


                                playerRocet.setVisible(false);
                                playerRocet.setLocation(100, 100);
                                Thread.sleep(600);
                                playerRocet.setVisible(true);


                                Life lostLife = lifes.remove(lifes.size() - 1);
                                remove(lostLife);
                                repaint();
                                break;

                            }
                        }
                    }

                    if (lifes.isEmpty()) {
                        gameOverShown = true;
                        GameOver gameOver = new GameOver();
                        this.removeAll(); // מסיר את כל הרכיבים הקודמים
                        this.add(gameOver); // מוסיף את מסך הסיום
                        this.revalidate();  // מרנדר מחדש את מבנה הפאנלים
                        this.repaint();     // מצייר מחדש
                    }

                    Thread.sleep(20);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();
    }

    public void treeLife() {
        int start = 0;
        for (int i = 0; i < 3; i++) {
            Life life = new Life(start);
            lifes.add(life);
            this.add(life);
            start += 30;
        }
    }

    public void hittingInAsteroid() {
        new Thread(() -> {
            try {
                while (true) {

                    ArrayList<Gunshot> shotsToRemove = new ArrayList<>();
                    ArrayList<ObstacleOfAsteroid> asteroidsToRemove = new ArrayList<>();

                    for (Gunshot shot : new ArrayList<>(shots)) {
                        for (ObstacleOfAsteroid asteroid : new ArrayList<>(asteroids)) {
                            if (asteroid.getBounds().intersects(shot.getBounds())) {

                                asteroid.counter();
                                shotsToRemove.add(shot);

                                if (asteroid.getCounterOfShooting() >= 9) {
                                    asteroidsToRemove.add(asteroid);
                                }
                            }
                        }
                    }

                    // הסרת יריות
                    for (Gunshot shot : shotsToRemove) {
                        shots.remove(shot);
                        remove(shot);
                    }

                    // הסרת אסטרואידים
                    for (ObstacleOfAsteroid asteroid : asteroidsToRemove) {
                        asteroids.remove(asteroid);
                        remove(asteroid);
                    }

                    repaint(); // עדכון גרפי
                    Thread.sleep(20);

                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();
    }
    public void removeAllAsteroid() {
        for (int i = asteroids.size() - 1; i >= 0; i--) {
            ObstacleOfAsteroid curentAsteroid = asteroids.get(i);
            this.remove(curentAsteroid);   // הסרה מהמסך
            asteroids.remove(i);     // הסרה מהלוגיקה
        }
        repaint();  // רענון אחרי הכל
    }

}
