/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Admin;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author ibrahem abdelaziz
 */
public class NavigationPanel extends JPanel {
    
    
    private ImageIcon img ;
    Color co1 = new Color(232,234,230);
    Color co11 = new Color(207,218,200);
    
    public NavigationPanel ()
    {
        this.setLayout(null);
        this.setSize(300,700);
        this.setBackground(co11);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
   
        g.setColor(co1);
        g.fill3DRect(10, 10, 280, 640, true);
        g.setColor(co11);
        g.fill3DRect(20, 30, 260, 600, true);
        g.setColor(co1);
        g.fill3DRect(30, 50, 240, 560, true);
        g.setColor(co11);
        g.fill3DRect(40, 70, 220, 520, true);
        g.setColor(co1);
        g.fill3DRect(50, 90, 200, 480, true);
        
        g.setColor(co11);
        g.fill3DRect(55, 150, 190, 50, true);
        g.setColor(co11);
        g.fill3DRect(55, 300, 190, 50, true);
        g.setColor(co11);
        g.fill3DRect(55, 450, 190, 50, true);
        
        
    }
    
    
    
}
