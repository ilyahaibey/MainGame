package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class StartScreen extends JPanel{
    public StartScreen(ActionListener onStartClicked) {
        setLayout(null);
        setBounds(0, 0, 1200, 800);

        // רקע (תמונה או צבע)
       JLabel background = new JLabel(new ImageIcon(getClass().getResource("/manu.png")));
        background.setBounds(0, 0, 1200, 800);
        add(background);

        // כותרת המשחק
        JLabel title = new JLabel("SPACE ADVENTURE");
        title.setFont(new Font("Arial", Font.BOLD, 50));
        title.setForeground(Color.WHITE);
        title.setBounds(350, 100, 800, 60);
        background.add(title);



        // הוראות
        JTextArea instructions = new JTextArea(
                "Instructions:\n" +
                        "• Use the arrow keys to move your spaceship.\n" +
                        "• Press the spacebar to shoot.\n" +
                        "• Avoid the asteroids!\n" +
                        "• You have 3 lives — don't lose them all!\n" +
                        "• Good luck, pilot!\n\n"

        );
        instructions.setFont(new Font("Arial", Font.PLAIN, 20));
        instructions.setForeground(Color.WHITE);
        instructions.setBackground(new Color(0, 0, 0, 0)); // שקוף
        instructions.setEditable(false);
        instructions.setBounds(350, 200, 500, 200);
        background.add(instructions);

        // כפתור Start
        JButton startButton = new JButton("Start Game");
        startButton.setFont(new Font("Arial", Font.BOLD, 30));
        startButton.setBounds(450, 450, 300, 70);
        startButton.addActionListener(onStartClicked);
        background.add(startButton);
    }
}












