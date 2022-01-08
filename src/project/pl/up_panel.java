/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.pl;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.*;

/**
 *
 * @author ibrahem abdelaziz
 */
public class up_panel extends JPanel {

    private ImageIcon img ; 
    Color co1 = new Color(207,218,200);
    JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    JTextField us,phone,email,id,pass,role,ge;
    JButton b1,b2;
    Font newFontlog = new Font("Comic Sans MS", Font.BOLD, 30);
      Font newFont = new Font("Comic Sans MS", Font.BOLD, 24);
      Color co2 = new Color(52,98,108);
      Color co3 = new Color(33,33,33);
      Color co4 = new Color(244,244,242);
      Color co5 = new Color(170,170,170);
      Color co6 = new Color(200,200,200);
      Color co7 = new Color(230,230,230);
      Color co8 = new Color(250,250,250);
      Color co9 = new Color(248,241,241);
      Color co10 = new Color(53,31,57);
      Color co11 = new Color(0,136,145);
      Color co12 = new Color(170,170,170);
      Color co13 = new Color(185,185,185);
      Color co14 = new Color(190,190,190);
      Color co15 = new Color(232,234,230);
      
    public up_panel() {
        
        this.setLayout(null);
        this.setSize(1000, 700);
        
        ////////////////////////
        
        l1 = new JLabel("Upadte & Delete");
        l1.setBounds(350, 30, 300, 30);
        l1.setFont(newFontlog);
        l1.setBackground(co1);
        this.add(l1);
        
        l2 = new JLabel("ID");
        l2.setBounds(450, 100, 300, 30);
        l2.setFont(newFont);
        l2.setForeground(co3);
        this.add(l2);
        
        l3 = new JLabel("Username");
        l3.setBounds(310, 190, 250, 30);
        l3.setFont(newFont);
        l3.setForeground(co3);
        this.add(l3);
        
        l4 = new JLabel("E-mail");
        l4.setBounds(650, 190, 250, 30);
        l4.setFont(newFont);
        l4.setForeground(co3);
        this.add(l4);
        
        l5 = new JLabel("Phone-num");
        l5.setBounds(310, 250, 250, 30);
        l5.setFont(newFont);
        l5.setForeground(co5);
        this.add(l5);
        
        l7 = new JLabel("Password");
        l7.setBounds(650, 250, 250, 30);
        l7.setFont(newFont);
        l7.setForeground(co8);
        this.add(l7);
        
        l8 = new JLabel("Role");
        l8.setBounds(310, 310, 250, 30);
        l8.setFont(newFont);
        l8.setForeground(co8);
        this.add(l8);
        
        l8 = new JLabel("Gender");
        l8.setBounds(650, 310, 250, 30);
        l8.setFont(newFont);
        l8.setForeground(co8);
        this.add(l8);
        
        
        ////////////////////////////
        
        id = new JTextField();
        id.setBounds(500, 107, 350, 20);
        id.setBorder(null);
        id.setBackground(co12);
        this.add(id);
        
        us = new JTextField();
        us.setBounds(430, 197, 200, 20);
        us.setBorder(null);
        us.setBackground(co12);
        this.add(us);
        
        email = new JTextField();
        email.setBounds(750, 197, 200, 20);
        email.setBorder(null);
        email.setBackground(co13);
        this.add(email);
        
        phone = new JTextField();
        phone.setBounds(440, 257, 200, 20);
        phone.setBorder(null);
        phone.setBackground(co14);
        this.add(phone);
        
        pass = new JTextField();
        pass.setBounds(760, 257, 200, 20);
        pass.setBorder(null);
        pass.setBackground(co14);
        this.add(pass);
        
        role = new JTextField();
        role.setBounds(410, 317, 200, 20);
        role.setBorder(null);
        role.setBackground(co14);
        this.add(role);
        
        phone = new JTextField();
        phone.setBounds(760, 317, 200, 20);
        phone.setBorder(null);
        phone.setBackground(co14);
        this.add(phone);
        
        /////////////////////////////////
        
        
        b1 = new JButton("Update...");
            b1.setBounds(650, 458, 200, 50);
            b1.setFont(newFont);
            b1.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, co11));
            b1.setBackground(co15);
            b1.setForeground(co3);
            this.add(b1);
            
            b2 = new JButton("Delete...");
            b2.setBounds(450, 518, 200, 50);
            b2.setFont(newFont);
            b2.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, co11));
            b2.setBackground(co15);
            b2.setForeground(co3);
            this.add(b2);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        img = new ImageIcon(getClass().getResource("pnn1.jpg"));
        img.paintIcon(this, g, 0, 0);
        g.setColor(co1);
        g.fill3DRect(301, 25, 330, 50, true);
        
        
    }
    
    
    
    
    
}
