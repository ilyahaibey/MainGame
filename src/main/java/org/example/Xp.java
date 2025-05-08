package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Xp extends JPanel {
    public static final int X = 1000 ;
    public static final int Y = 0 ;
    public static final int HIGHT = 20 ;
    public static final int WHIDHT = 1000 ;


    private int xp ;
    private int x = X ;
    private int y = Y ;
    private int hight = HIGHT ;
    private int whidh = WHIDHT;
    private ArrayList<ObstacleOfAsteroid> perentAsteroids;


    public Xp(){
        this.xp = 0 ;
        JLabel xpText = new JLabel(String.valueOf(this.xp));
        this.setLayout(null);
        this.setBounds(x,y,hight,whidh);
    }

}
