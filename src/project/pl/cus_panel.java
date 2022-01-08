/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.pl;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author ibrahem abdelaziz
 */
public class cus_panel extends JPanel{
    
     private ImageIcon img ; 
    public cus_panel()
    {
        this.setSize(1000, 700);
        this.setLayout(null);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        img = new ImageIcon(getClass().getResource("x5.jpeg"));
        img.paintIcon(this, g, 0, 0);
    }
}
