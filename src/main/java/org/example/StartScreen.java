package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class StartScreen extends JPanel {
    // משתניפ קבועים לכותרת
    public static final int TITLE_WIDTH = 500;
    public static final int TITLE_HEIGHT = 300;
    public static final int TITLE_X = (1200 - TITLE_WIDTH) / 2;
    public static final int TITLE_Y = 50;
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
        ImageIcon titleIcon = new ImageIcon(getClass().getResource("/Title.png"));
        Image scaledTitle = titleIcon.getImage().getScaledInstance(TITLE_WIDTH, TITLE_HEIGHT, Image.SCALE_SMOOTH);
        JLabel titleImage = new JLabel(new ImageIcon(scaledTitle));
        titleImage.setBounds(TITLE_X, TITLE_Y, TITLE_WIDTH, TITLE_HEIGHT);
        background.add(titleImage);
//
//        JLabel title = new JLabel("SPACE ADVENTURE");
//        title.setFont(new Font("Arial", Font.BOLD, 50));
//        title.setForeground(Color.WHITE);
//        title.setBounds(350, 100, 800, 60);
//        background.add(title);

        // כפתור Start Game עם תמונה
        ImageIcon originalIcon = new ImageIcon(getClass().getResource("/buttom_StartGame.png"));
        Image img = originalIcon.getImage();
        Image scaledImg = img.getScaledInstance(400,TITLE_HEIGHT, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImg);

        JButton startButton = new JButton(scaledIcon);
        startButton.setBounds((1200 - 400) / 2, 350, 400, 120);
        startButton.setContentAreaFilled(false);
        startButton.setBorderPainted(false);
        startButton.setFocusPainted(false);
        startButton.addActionListener(onStartClicked);
        background.add(startButton);
//        JButton startButton = new JButton("Start Game");
//        startButton.setFont(new Font("Arial", Font.BOLD, 30));
//        startButton.setBounds(450, 450, 300, 70);
//        startButton.addActionListener(onStartClicked);
//        background.add(startButton);
        ///


        // כפתור Instructions עם תמונה
        ImageIcon originalInstructionsIcon = new ImageIcon(getClass().getResource("/INSTRUCTIONS.png"));
        Image imgInstructions = originalInstructionsIcon.getImage();
        Image scaledInstructionsImg = imgInstructions.getScaledInstance(400, 350, Image.SCALE_SMOOTH);
        ImageIcon scaledInstructionsIcon = new ImageIcon(scaledInstructionsImg);

        JButton instructionsB = new JButton(scaledInstructionsIcon);
        instructionsB.setBounds((1200 - 400) / 2, 480, 400, 120); // היה קודם 580
        instructionsB.setContentAreaFilled(false);
        instructionsB.setBorderPainted(false);
        instructionsB.setFocusPainted(false);
        instructionsB.addActionListener(onInstructionsClicked);
        background.add(instructionsB);


//        JButton instructionsB = new JButton("Instructions");
//        instructionsB.setFont(new Font("Arial", Font.BOLD, 30));
//        instructionsB.setBounds(450, 560, 300, 70);
//        instructionsB.addActionListener(onInstructionsClicked);
//        background.add(instructionsB);
    }
}











