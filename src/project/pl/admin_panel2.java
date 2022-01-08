/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.pl;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author ibrahem abdelaziz
 */
public class admin_panel2 extends JPanel{
    
    private ImageIcon img ; 
    public admin_panel2()
    {
        this.setSize(1000, 700);
        this.setLayout(null);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        img = new ImageIcon(getClass().getResource("pnn1.jpg"));
        img.paintIcon(this, g, 0, 0);
    }
    
}
