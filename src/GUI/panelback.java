/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.FlowLayout;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author ibrahem abdelaziz
 */
public class panelback extends JPanel{
    
    private ImageIcon img;
    public panelback()
    {
        this.setLayout(null);
        
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); 
        
        img = new ImageIcon(getClass().getResource("event2.jpg"));
        img.paintIcon(this, g, 0, 0);
    }
    
    
}
