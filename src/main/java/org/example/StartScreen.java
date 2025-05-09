package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class StartScreen extends JPanel {
    private Image instructions;

    public StartScreen(ActionListener onStartClicked, ActionListener onInstructionsClicked) {
        instructions = new ImageIcon(getClass().getResource("/inst.png")).getImage();

        setLayout(null);
        setBounds(0, 0, 1200, 700);

        // רקע
        JLabel background = new JLabel(new ImageIcon(getClass().getResource("/manu.png")));
        background.setBounds(0, 0, 1200, 700);
        add(background);

        // כותרת
        JLabel title = new JLabel("SPACE ADVENTURE");
        title.setFont(new Font("Arial", Font.BOLD, 50));
        title.setForeground(Color.WHITE);
        title.setBounds(350, 100, 800, 60);
        background.add(title);

        // כפתור Start Game
        JButton startButton = new JButton("Start Game");
        startButton.setFont(new Font("Arial", Font.BOLD, 30));
        startButton.setBounds(450, 450, 300, 70);
        startButton.addActionListener(onStartClicked);
        background.add(startButton);

        // כפתור Instructions
        JButton instructionsB = new JButton("Instructions");
        instructionsB.setFont(new Font("Arial", Font.BOLD, 30));
        instructionsB.setBounds(450, 560, 300, 70);
        instructionsB.addActionListener(onInstructionsClicked);
        background.add(instructionsB);
    }
}











