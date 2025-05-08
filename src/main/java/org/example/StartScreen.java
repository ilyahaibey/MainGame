package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class StartScreen extends JPanel{
    private Image instructions ;




    public StartScreen(ActionListener onStartClicked) {



        instructions = new ImageIcon(getClass().getResource("/inst.png")).getImage();

        setLayout(null);
        setBounds(0, 0, 1200, 700);

        // רקע (תמונה או צבע)
       JLabel background = new JLabel(new ImageIcon(getClass().getResource("/manu.png")));
        background.setBounds(0, 0, 1200, 700);
        add(background);

        // כותרת המשחק
        JLabel title = new JLabel("SPACE ADVENTURE");
        title.setFont(new Font("Arial", Font.BOLD, 50));
        title.setForeground(Color.WHITE);
        title.setBounds(350, 100, 800, 60);
        background.add(title);


        JButton startButton = new JButton("Start Game");
        startButton.setFont(new Font("Arial", Font.BOLD, 30));
        startButton.setBounds(450, 450, 300, 70);
        startButton.addActionListener(onStartClicked);
        background.add(startButton);

        JButton instructionsB  = new JButton("instructions");
        instructionsB.setFont(new Font("Arial", Font.BOLD, 30));
        instructionsB.setBounds(450, 520, 300, 70);
        instructionsB.addActionListener(onStartClicked);
        background.add(instructionsB);
        startButton.addActionListener(e -> {

        });
    }
}












