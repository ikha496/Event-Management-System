package project.pl;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class PM extends JFrame implements ActionListener{
    
    cus_panel1 p1 = new cus_panel1();
    admin_panel2 p2 = new admin_panel2();
    ShowEvent_pm p3 = new ShowEvent_pm();
    SendBillPm p4 = new SendBillPm();
    
        JLabel l1,l2;
        JButton b1,b2,b3;
        
        Font newFontlog = new Font("Comic Sans MS", Font.BOLD, 30);
        Font newFont = new Font("Comic Sans MS", Font.BOLD, 20);
        Color co1 = new Color(0,136,145);
        Color co2 = new Color(232,234,230);
        Color co3 = new Color(53,31,57);
        Color co4 = new Color(24,77,71);
        Color co11 = new Color(207,218,200);

    public PM() throws HeadlessException {
    
        
        
        this.setTitle("Project Manager");
        this.setSize(1000, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocation(250, 10);
        this.setLayout(null);
        this.add(p1);
        this.add(p2);
        
        ///////////////////////////
            
            l1 = new JLabel("Welcome PM");
            l1.setFont(newFontlog);
            l1.setForeground(co1);
            l1.setBounds(53, 20, 300, 30);
            p1.add(l1);
            
            
            ///////////////////////////
            
            b1 = new JButton("Show Event");
            b1.setBounds(65, 205, 170, 40);
            b1.setFont(newFont);
            b1.setBorder(null);
            b1.setBackground(co11);
            b1.setForeground(co3);
            p1.add(b1);
            
            b2 = new JButton("Show & send Bill");
            b2.setBounds(65, 405, 170, 40);
            b2.setFont(newFont);
            b2.setBorder(null);
            b2.setBackground(co11);
            b2.setForeground(co3);
            p1.add(b2);
            
            
            b1.addActionListener(this);
            b2.addActionListener(this);
            
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
    
}
}
