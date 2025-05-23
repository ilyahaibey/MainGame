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

        JFrame instructions = new JFrame("Instructions");

        SpaceBackground background = new SpaceBackground();
        Instructions instructionspanel = new Instructions();

        StartScreen[] startScreen = new StartScreen[1];

        startScreen[0] = new StartScreen(
                e -> {

                    window.remove(startScreen[0]);
                    window.add(background);
                    window.revalidate();
                    window.repaint();
                    background.requestFocusInWindow();
                    background.startGame();
                },
                e -> {
                    instructions.setSize(1000, 600);
                    instructions.setLocationRelativeTo(null);
                    instructions.setLayout(null);
                    instructions.setResizable(false);
                    instructions.setVisible(true);
                    instructions.add(instructionspanel);
                    instructions.revalidate();
                    instructions.repaint();

                }
        );

        startScreen[0].setBounds(0, 0, WIDTH, HEIGHT);

        window.add(startScreen[0]);
        Sound sound =new Sound("src/main/resources/רקע.wav");
        sound.backgroundMusic();
        window.setVisible(true);
    }

}