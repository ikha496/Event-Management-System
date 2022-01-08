package project.pl;


import Database.database;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;

public class login1 extends JFrame implements ActionListener{
    public static String email ;
    Color co1 = new Color(0,136,145);
    Color co2 = new Color(248,241,241);
    Color co3 = new Color(53,31,57);
    Color co4 = new Color(24,77,71);
    panelback panel = new panelback();
    JLabel user , pass , add , ti , an,
            re1,re2,re3,re4,re5,re6,re7;
    JTextField us,us1,phone,em;
    JPasswordField pa,pas,rpas;
    JButton b1,b2;
    JRadioButton r1,r2;
    ButtonGroup g;
    JComboBox co ;
    Font newFontlog = new Font("Comic Sans MS", Font.BOLD, 24);
    Font newFont = new Font("Comic Sans MS", Font.BOLD, 20);
      
        
    public login1() {       
        
        this.setTitle("LOGIN");
        this.setSize(1000, 500);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(250, 50);
        this.setVisible(true);
        this.add(panel);

        ti = new JLabel("In Case You Don't Have Acc...");
        ti.setBounds(550,0, 400, 100);
        ti.setFont(newFontlog);
        ti.setForeground(co4);
        panel.add(ti);
        
        
        add = new JLabel("LOGIN...");
        add.setFont(newFontlog);
        add.setBounds(10, 70, 150, 100);
        add.setForeground(co1);
        panel.add(add);
        
        
        user = new JLabel("Username");
        user.setBounds(50, 130, 100, 100);
        user.setForeground(co1);
        user.setFont(newFont);
        panel.add(user);
        
        pass = new JLabel("Password");
        pass.setBounds(50, 200, 100, 100);
        pass.setForeground(co1);
        pass.setFont(newFont);
        panel.add(pass);
        
      
        //////////////////////////////
        
        us = new JTextField();
        us.setBounds(150, 173, 200, 20);
        us.setBackground(co2);
        us.setBorder(null);
        panel.add(us);
        
        
        pa = new JPasswordField();
        pa.setBounds(150, 243, 190, 20);
        pa.setBackground(co2);
        pa.setBorder(null);
        panel.add(pa);
        
        ///////////////////////////////
        
        
        b1 = new JButton("Login");
        b1.setBounds(180, 300, 150, 30);
        b1.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, co1));
        b1.setBackground(co2);
        b1.setForeground(co3);
        panel.add(b1);
        
        ///////////////////////////////
        
        
        
        re1 = new JLabel("Username");
        re1.setBounds(600, 50, 100, 100);
        re1.setForeground(co1);
        re1.setFont(newFont);
        panel.add(re1);
        
        re2 = new JLabel("E-mail");
        re2.setBounds(630, 100, 100, 100);
        re2.setForeground(co1);
        re2.setFont(newFont);
        panel.add(re2);
        
        re3 = new JLabel("Password");
        re3.setBounds(655, 150, 100, 100);
        re3.setForeground(co1);
        re3.setFont(newFont);
        panel.add(re3);
        
        re4 = new JLabel("Re-Password");
        re4.setBounds(670, 200, 150, 100);
        re4.setForeground(co1);
        re4.setFont(newFont);
        panel.add(re4);
        
        re5 = new JLabel("Role");
        re5.setBounds(665, 250, 100, 100);
        re5.setForeground(co1);
        re5.setFont(newFont);
        panel.add(re5);
        
        re6 = new JLabel("Phone-num");
        re6.setBounds(665, 300, 150, 100);
        re6.setForeground(co1);
        re6.setFont(newFont);
        panel.add(re6);
        
        re7 = new JLabel("Gender");
        re7.setBounds(600, 350, 150, 100);
        re7.setForeground(co1);
        re7.setFont(newFont);
        panel.add(re7);
        
        //////////////////////////////////
        
        
        us1 = new JTextField();
        us1.setBounds(710, 93, 230, 20);
        us1.setBackground(co2);
        panel.add(us1);
        
        em = new JTextField();
        em.setBounds(710, 140, 230, 20);
        em.setBackground(co2);
        em.setBorder(null);
        panel.add(em);
        
        pas = new JPasswordField();
        pas.setBounds(750, 190, 230, 20);
        pas.setBackground(co2);
        pas.setBorder(null);
        panel.add(pas);
        
        rpas = new JPasswordField();
        rpas.setBounds(800, 240, 180, 20);
        rpas.setBackground(co2);
        rpas.setBorder(null);
        panel.add(rpas);
        
        phone = new JTextField();
        phone.setBounds(780, 343, 200, 20);
        phone.setBackground(co2);
        phone.setBorder(null);
        panel.add(phone); 
        
        r1 = new JRadioButton("Male");
        r1.setBounds(700, 390, 70, 20);
        //r1.setBackground();
        r1.setBorder(null);
        panel.add(r1);
        
        r2 = new JRadioButton("Female");
        r2.setBounds(800, 390, 70, 20);
        //r2.setBackground();
        r2.setBorder(null);
        panel.add(r2);
        
        
        co = new JComboBox();
        co.addItem("Admin");
        co.addItem("User");
        co.addItem("PM");
        co.addItem("SP");
        co.setForeground(Color.WHITE);
        co.setBounds(730, 290, 200, 20);
        co.setBackground(co1);
        panel.add(co);
        
        b2 = new JButton("Submit");
        b2.setBounds(810, 420, 150, 30);
        b2.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, co1));
        b2.setBackground(co2);
        b2.setForeground(co3);
        panel.add(b2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        panel.repaint();
        panel.revalidate();
        
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == b1)
        {
            database d = new database();
            d.connect();
            try {
                ResultSet resultSet = d.login(us.getText());
                String password = resultSet.getString("password");
                String role = resultSet.getString("role");
                

                if (password.equals(pa.getText())) {
                    email=resultSet.getString("eMail");
                    if ("admin".equals(role.toLowerCase())) {
                        admin admin1 = new admin();
                        this.setVisible(false);
                    } else if ("user".equals(role.toLowerCase())) {
                        Customer cus = new Customer();
                        this.setVisible(false);
                    } else if ("sp".equals(role.toLowerCase())) {
                        PM pm1 = new PM();
                        this.setVisible(false);
                    } else if ("pm".equals(role.toLowerCase())) {
                        Sp sp1 = new Sp();
                        this.setVisible(false);
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Enter a valid account", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
                resultSet.close();
            } catch (Exception t) {
                JOptionPane.showMessageDialog(null, "Enter a valid account", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        
        if(e.getSource() == b2)
        {
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

            if(!pas.getText().equals(rpas.getText()))
                JOptionPane.showMessageDialog(null,"Password don't match","Error",
                        JOptionPane.ERROR_MESSAGE);
            else if((pas.getText().length())<8)
                JOptionPane.showMessageDialog(null,"Password should be more than 8 characters",
                        "Error",JOptionPane.ERROR_MESSAGE);
            
            else{
                try{
                    String gender;
                    if(r1.isSelected())gender="Male";
                    else gender="Female";
                    d.insertUser(us1.getText(),
                    em.getText(),
                    pas.getText(),
                    phone,
                    "user",
                    gender);

                    for(Component control : panel.getComponents())
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
                    this.repaint();
                    JOptionPane.showMessageDialog(null,"Account created succesfully");
                }catch(Exception t){
                    JOptionPane.showMessageDialog(null,"This reservation number is taken",
                        "Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        
    }
    
}
