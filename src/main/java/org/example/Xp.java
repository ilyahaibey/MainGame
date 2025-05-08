package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Xp extends JPanel {
    public static final int X = 1200 ;
    public static final int Y = 700 ;
    public static final int HIGHT = 20 ;
    public static final int WHIDHT = 1000 ;



    private int xp ;
    private int x = X ;
    private int y = Y ;
    private int hight = HIGHT ;
    private int whidh = WHIDHT;


    public Xp() {
        this.setLayout(null);
        this.setBounds(20, 20, 200, 50);
        this.setOpaque(false);
        this.xp = 20;

        JLabel xpText = new JLabel(String.valueOf(this.xp));
        xpText.setBounds(0, 0, 200, 50);
        xpText.setFont(new Font("Arial", Font.PLAIN, 24));
        xpText.setForeground(Color.WHITE);


        this.add(xpText);





    }


    public void addXp(){
        this.xp+=10 ;
    }

}
