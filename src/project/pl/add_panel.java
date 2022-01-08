package project.pl;

import Database.database;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;


public class add_panel extends JPanel implements ActionListener{
    
    private ImageIcon img ; 
    JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    admin_panel1 p1 = new admin_panel1();
    admin_panel2 p2 = new admin_panel2();
    JTextField us,phone,email;
    JPasswordField pass,rpass;
    JRadioButton r1,r2;
    JComboBox c1;
    JButton b1;
    Font newFontlog = new Font("Comic Sans MS", Font.BOLD, 30);
    Font newFont = new Font("Comic Sans MS", Font.BOLD, 24);
    Color co1 = new Color(207,218,200);
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
    
    public add_panel()
    {
        this.setSize(1000, 700);
        this.setLayout(null);
        
        
        ///////////////////////////
        l1 = new JLabel("Add New User..");
        l1.setBounds(350, 30, 300, 30);
        l1.setFont(newFontlog);
        l1.setBackground(co1);
        this.add(l1);
        
        l2 = new JLabel("Username");
        l2.setBounds(500, 100, 300, 30);
        l2.setFont(newFont);
        l2.setForeground(co3);
        this.add(l2);
        
        l3 = new JLabel("Phone-num");
        l3.setBounds(500, 170, 300, 30);
        l3.setFont(newFont);
        l3.setForeground(co3);
        this.add(l3);
        
        l4 = new JLabel("E-mail");
        l4.setBounds(500, 240, 300, 30);
        l4.setFont(newFont);
        l4.setForeground(co3);
        this.add(l4);
        
        l5 = new JLabel("Password");
        l5.setBounds(500, 310, 300, 30);
        l5.setFont(newFont);
        l5.setForeground(co5);
        this.add(l5);
        
        l6 = new JLabel("Re-Password");
        l6.setBounds(500, 380, 300, 30);
        l6.setFont(newFont);
        l6.setForeground(co6);
        this.add(l6);
        
        l7 = new JLabel("Role");
        l7.setBounds(500, 450, 300, 30);
        l7.setFont(newFont);
        l7.setForeground(co7);
        this.add(l7);
        
        l8 = new JLabel("Gender");
        l8.setBounds(500, 520, 300, 30);
        l8.setFont(newFont);
        l8.setForeground(co8);
        this.add(l8);
        
        ////////////////////////////
        
        
        us = new JTextField();
        us.setBounds(630, 107, 280, 20);
        us.setBorder(null);
        us.setBackground(co12);
        this.add(us);
        
        phone = new JTextField();
        phone.setBounds(635, 177, 280, 20);
        phone.setBorder(null);
        phone.setBackground(co13);
        this.add(phone);
        
        email = new JTextField();
        email.setBounds(635, 247, 280, 20);
        email.setBorder(null);
        email.setBackground(co14);
        this.add(email);
        
        pass = new JPasswordField();
        pass.setBounds(635, 317, 280, 20);
        pass.setBorder(null);
        pass.setBackground(co4);
        this.add(pass);
        
        rpass = new JPasswordField();
        rpass.setBounds(655, 387, 265, 20);
        rpass.setBorder(null);
        rpass.setBackground(co4);
        this.add(rpass);
        
        c1 = new JComboBox();
        c1.setBounds(570, 457, 300, 20);
        c1.addItem("Admin");
        c1.addItem("SP");
        c1.addItem("PM");
        c1.addItem("User");
        c1.setBackground(co4);
        this.add(c1);
        
        r1 = new JRadioButton("Male");
        r2 = new JRadioButton("Female");
        r1.setBackground(co4);
        r2.setBackground(co4);
        r1.setBounds(610, 527, 70, 20);
        r2.setBounds(750, 527, 70, 20);
        this.add(r1);this.add(r2);
        
        b1 = new JButton("Submit");
        b1.setBounds(750, 590, 170, 40);
        
        b1.setFont(newFont);
        b1.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, co11));
        b1.setBackground(co9);
        b1.setForeground(co10);
        this.add(b1);
        
        b1.addActionListener(this);
        
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        img = new ImageIcon(getClass().getResource("pnn1.jpg"));
        img.paintIcon(this, g, 0, 0);
        g.setColor(co1);
        g.fill3DRect(301, 25, 330, 50, true);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        if(arg0.getSource()==b1){
            database d=new database();
            d.connect();
            int phone;
            try {
                phone=Integer.parseInt(this.phone.getText());
            } catch (Exception y) {
                JOptionPane.showMessageDialog(null,"Enter A valid phone number","Error",
                        JOptionPane.ERROR_MESSAGE);
            }
            phone=Integer.parseInt(this.phone.getText());

            if(!pass.getText().equals(rpass.getText()))
                JOptionPane.showMessageDialog(null,"Password don't match","Error",
                        JOptionPane.ERROR_MESSAGE);
            else if((pass.getText().length())<8)
                JOptionPane.showMessageDialog(null,"Password should be more than 8 characters",
                        "Error",JOptionPane.ERROR_MESSAGE);
            
            else{
                String gender="Unkown";
                if(r1.isSelected())gender="Male";
                else gender="Female";
                d.insertUser(us.getText(),
                email.getText(),
                pass.getText(),
                phone,
                String.valueOf(c1.getSelectedItem()).toLowerCase(),
                gender);
                
                JOptionPane.showMessageDialog(null,"Account created succesfully");
                
                for(Component control : this.getComponents())
                {
                    if(control instanceof JTextField)
                    {
                        JTextField ctrl = (JTextField) control;
                        ctrl.setText("");
                    }
                    else if (control instanceof JPasswordField)
                    {
                        JPasswordField ctr = (JPasswordField) control;
                        ctr.setText("");
                    }
                    else if (control instanceof JRadioButton)
                    {
                        JRadioButton ctr = (JRadioButton) control;
                        ctr.setSelected(false);
                    }
                }
                
                
                
                p1.repaint();
                           
                
                
            }
        }
        }
    }
