package org.example;

import javax.swing.*;
import java.awt.*;

public class Instructions extends JPanel {
    private Image instructions;

    public Instructions(){
        instructions = new ImageIcon(getClass().getResource("/inst.png")).getImage();
        this.setLayout(null);
        this.setBounds(0, 0, 1000, 600);

    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(instructions, 0, 0, getWidth(), getHeight(), this);
    }

}
