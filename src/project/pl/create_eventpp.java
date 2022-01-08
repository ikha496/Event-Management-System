package project.pl;


import Database.database;
import event.managment.system.Mailer;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class create_eventpp extends JPanel implements ActionListener{
    
    private  ImageIcon img;
    
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JTextField re,en,lo;
    JTextArea de;
    JPasswordField pass,rpass;
    JButton b1;
    cus_panel1 p1 = new cus_panel1();
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

    
    public create_eventpp() {
        this.setSize(1000, 700);
        this.setLayout(null);
        
        ////////////////////
        
        l1 = new JLabel("Create New Event...");
        l1.setBounds(310, 30, 350, 30);
        l1.setFont(newFontlog);
        l1.setForeground(co3);
        this.add(l1);
        
        l2 = new JLabel("Reservation Number");
        l2.setBounds(500, 100, 300, 30);
        l2.setFont(newFont);
        l2.setForeground(co3);
        this.add(l2);
        
        l3 = new JLabel("Event Name");
        l3.setBounds(500, 170, 300, 30);
        l3.setFont(newFont);
        l3.setForeground(co3);
        this.add(l3);
        
        l4 = new JLabel("Location");
        l4.setBounds(500, 240, 300, 30);
        l4.setFont(newFont);
        l4.setForeground(co3);
        this.add(l4);
        
        l5 = new JLabel("Event Details");
        l5.setBounds(500, 310, 300, 30);
        l5.setFont(newFont);
        l5.setForeground(co5);
        this.add(l5);
        
        l6 = new JLabel("Password");
        l6.setBounds(500, 450, 300, 30);
        l6.setFont(newFont);
        l6.setForeground(co6);
        this.add(l6);
        
        l7 = new JLabel("Re-Password");
        l7.setBounds(500, 530, 300, 30);
        l7.setFont(newFont);
        l7.setForeground(co8);
        this.add(l7);
        ///////////////////////////
        
        re = new JTextField();
        re.setBounds(750, 107, 100, 20);
        re.setBorder(null);
        re.setBackground(co12);
        this.add(re);
        
        en = new JTextField();
        en.setBounds(650, 177, 280, 20);
        en.setBorder(null);
        en.setBackground(co13);
        this.add(en);
        
        lo = new JTextField();
        lo.setBounds(650, 247, 280, 20);
        lo.setBorder(null);
        lo.setBackground(co14);
        this.add(lo);
        
        de = new JTextArea(4,4);
        de.setBounds(660, 317, 280, 100);
        de.setBorder(null);
        de.setBackground(co4);
        this.add(de);
        
        pass = new JPasswordField();
        pass.setBounds(655, 457, 280, 20);
        pass.setBorder(null);
        pass.setBackground(co4);
        this.add(pass);
        
        rpass = new JPasswordField();
        rpass.setBounds(655, 537, 280, 20);
        rpass.setBorder(null);
        rpass.setBackground(co4);
        this.add(rpass);
        
        /////////////////////////////
        
        b1 = new JButton("Submit");
        b1.setBounds(750, 590, 170, 40);
        b1.setFont(newFont);
        b1.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, co11));
        b1.setBackground(co9);
        b1.setForeground(co10);
        b1.addActionListener(this);
        this.add(b1);
        
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
        if(pass.getText().equals(rpass.getText())){
            d.insertEvent(en.getText(),lo.getText(), de.getText()
                    , pass.getText(),Integer.parseInt(re.getText()),login1.email);
            JOptionPane.showMessageDialog(null, "Event Created Successfully");
            ResultSet resultSet=d.sendEvents(en.getText(), pass.getText());
            
            p1.repaint();
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
                else if (control instanceof JTextArea)
                {
                    JTextArea ctr = (JTextArea) control;
                    ctr.setText("");
                }
            }
            this.repaint();

            
            try {
                Mailer.send("fcai.hu.drive@gmail.com", "FCAIHU20192020"
                        , resultSet.getString("ownerEmail"),
                        "Your Event \""+resultSet.getString("eventName")+"\" Created Successfully",
                        "Hello, \n"+
                        "Your Event \""+resultSet.getString("eventName")+"\" Created Successfully\n"+
                        "Event Location: "+resultSet.getString("location")+"\n"+
                        "Event Details: "+resultSet.getString("eventDetails")+"\n"+
                        "You can use reservation number and password to Login\n"+
                        "Be carefull and don't share them!\n"+
                        "Reservation Number: "+resultSet.getString("reservationNumber")+"\n"+
                        "Password: "+resultSet.getString("password")+"\n"+
                        "Thanks....");
                
                
            } catch (SQLException ex) {
                System.out.println(ex);
            }
            
            
        }
        else
            JOptionPane.showMessageDialog(null, "Enter a correct password", "Error",
                        JOptionPane.ERROR_MESSAGE);
    }
}
    
    
    
}
