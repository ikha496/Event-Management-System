package project.pl;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class admin extends JFrame implements ActionListener {
    
        admin_panel1 p1 = new admin_panel1();
        admin_panel2 p2 = new admin_panel2();
        add_panel p3 = new add_panel();
        up_panel p4 = new up_panel();
        admin_show p5 = new admin_show();
        JLabel l1,l2;
        JButton b1,b2,b3;
        
        Font newFontlog = new Font("Comic Sans MS", Font.BOLD, 30);
        Font newFont = new Font("Comic Sans MS", Font.BOLD, 20);
        Color co1 = new Color(0,136,145);
        Color co2 = new Color(207,218,200);
        Color co3 = new Color(53,31,57);
        Color co4 = new Color(24,77,71);
        
        
        public admin()
        {
            this.setTitle("Admin");
            this.setSize(1000, 700);
            this.setVisible(true);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setResizable(false);
            this.setLocation(250, 10);
            this.setLayout(null);
            this.add(p1);
            this.add(p2);
            
            ///////////////////////////
            
            l1 = new JLabel("Welcome Admin...");
            l1.setFont(newFontlog);
            l1.setForeground(co1);
            l1.setBounds(15, 30, 280, 70);
            p1.add(l1);
            
            
            ///////////////////////////
            
            b1 = new JButton("Add New User");
            b1.setBounds(60, 155, 180, 40);
            b1.setFont(newFont);
            b1.setBorder(null);
            b1.setBackground(co2);
            b1.setForeground(co3);
            p1.add(b1);
            
            b2 = new JButton("Update & Delete");
            b2.setBounds(60, 305, 180, 40);
            b2.setFont(newFont);
            b2.setBorder(null);
            b2.setBackground(co2);
            b2.setForeground(co3);
            p1.add(b2);
            
            b3 = new JButton("Show Requests");
            b3.setBounds(60, 455, 180, 40);
            b3.setFont(newFont);
            b3.setBorder(null);
            b3.setBackground(co2);
            b3.setForeground(co3);
            p1.add(b3);
            b1.addActionListener(this);
            b2.addActionListener(this);
            b3.addActionListener(this);
            
            ////////////////////////////////////
            

        }



    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == b1)
        {
            p2.removeAll();
            p2.add(p3);
            this.repaint();
        }
        
        if(e.getSource() == b2)
        {
            p2.removeAll();
            p2.add(p4);
            this.repaint();
        }
        
        if(e.getSource() == b3)
        {
            p2.removeAll();
            p2.add(p5);
            this.repaint();
        }
    }

   
    
}
