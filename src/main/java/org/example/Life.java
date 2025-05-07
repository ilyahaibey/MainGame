package org.example;

import javax.swing.*;
import java.awt.*;

public class Life extends JPanel {
    public static final int HEIGHT = 30 ;
    public static final int WIDTH = 30 ;
    public static final int Y_LOCATION = 0 ;




    private int y = Y_LOCATION ;
    private int x ;
    private  int width = WIDTH ;
    private int  height = HEIGHT ;
    private JPanel parent ;
    private Image life ;


    public Life(int x  ) {
        this.x = x ;

        life = new ImageIcon(getClass().getResource("/lev.png")).getImage();
        setLayout(null);
        setBounds(this.x,this.y, width, height);
        setOpaque(false);

    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(life, 0, 0, getWidth(), getHeight(), this);

    }

}
