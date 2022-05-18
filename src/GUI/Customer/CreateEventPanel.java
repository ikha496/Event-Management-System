package GUI.Customer;


import Database.Database;
import GUI.login1;
import event.managment.system.Mailer;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CreateEventPanel extends JPanel implements ActionListener{
    
    private  ImageIcon img;
    
    JLabel createNewEventLbl,reservationNoLbl,eventNameLbl,locationLbl,eventDetailsLbl,passwordLbl,rePasswordLbl;
    JTextField re,eventName,locationTextField;
    JTextArea eventDetailsTextArea;
    JPasswordField password,rePassword;
    JButton submitBtn;
    NavigationPanel navigationPanel = new NavigationPanel();
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

    
    public CreateEventPanel() {
        this.setSize(1000, 700);
        this.setLayout(null);
        
        ////////////////////
        
        createNewEventLbl = new JLabel("Create New Event...");
        createNewEventLbl.setBounds(310, 30, 350, 30);
        createNewEventLbl.setFont(newFontlog);
        createNewEventLbl.setForeground(co3);
        this.add(createNewEventLbl);
        
        reservationNoLbl = new JLabel("Reservation Number");
        reservationNoLbl.setBounds(500, 100, 300, 30);
        reservationNoLbl.setFont(newFont);
        reservationNoLbl.setForeground(co3);
        this.add(reservationNoLbl);
        
        eventNameLbl = new JLabel("Event Name");
        eventNameLbl.setBounds(500, 170, 300, 30);
        eventNameLbl.setFont(newFont);
        eventNameLbl.setForeground(co3);
        this.add(eventNameLbl);
        
        locationLbl = new JLabel("Location");
        locationLbl.setBounds(500, 240, 300, 30);
        locationLbl.setFont(newFont);
        locationLbl.setForeground(co3);
        this.add(locationLbl);
        
        eventDetailsLbl = new JLabel("Event Details");
        eventDetailsLbl.setBounds(500, 310, 300, 30);
        eventDetailsLbl.setFont(newFont);
        eventDetailsLbl.setForeground(co5);
        this.add(eventDetailsLbl);
        
        passwordLbl = new JLabel("Password");
        passwordLbl.setBounds(500, 450, 300, 30);
        passwordLbl.setFont(newFont);
        passwordLbl.setForeground(co6);
        this.add(passwordLbl);
        
        rePasswordLbl = new JLabel("Re-Password");
        rePasswordLbl.setBounds(500, 530, 300, 30);
        rePasswordLbl.setFont(newFont);
        rePasswordLbl.setForeground(co8);
        this.add(rePasswordLbl);
        ///////////////////////////
        
        re = new JTextField();
        re.setBounds(750, 107, 100, 20);
        re.setBorder(null);
        re.setBackground(co12);
        this.add(re);
        
        eventName = new JTextField();
        eventName.setBounds(650, 177, 280, 20);
        eventName.setBorder(null);
        eventName.setBackground(co13);
        this.add(eventName);
        
        locationTextField = new JTextField();
        locationTextField.setBounds(650, 247, 280, 20);
        locationTextField.setBorder(null);
        locationTextField.setBackground(co14);
        this.add(locationTextField);
        
        eventDetailsTextArea = new JTextArea(4,4);
        eventDetailsTextArea.setBounds(660, 317, 280, 100);
        eventDetailsTextArea.setBorder(null);
        eventDetailsTextArea.setBackground(co4);
        this.add(eventDetailsTextArea);
        
        password = new JPasswordField();
        password.setBounds(655, 457, 280, 20);
        password.setBorder(null);
        password.setBackground(co4);
        this.add(password);
        
        rePassword = new JPasswordField();
        rePassword.setBounds(655, 537, 280, 20);
        rePassword.setBorder(null);
        rePassword.setBackground(co4);
        this.add(rePassword);
        
        /////////////////////////////
        
        submitBtn = new JButton("Submit");
        submitBtn.setBounds(750, 590, 170, 40);
        submitBtn.setFont(newFont);
        submitBtn.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, co11));
        submitBtn.setBackground(co9);
        submitBtn.setForeground(co10);
        submitBtn.addActionListener(this);
        this.add(submitBtn);
        
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
        if(arg0.getSource()==submitBtn){
        Database d=new Database();
        if(password.getText().equals(rePassword.getText())){
            d.insertEvent(eventName.getText(),locationTextField.getText(), eventDetailsTextArea.getText()
                    , password.getText(),Integer.parseInt(re.getText()),login1.email);
            JOptionPane.showMessageDialog(null, "Event Created Successfully");
            ResultSet resultSet=d.sendEvents(eventName.getText(), password.getText());
            
            navigationPanel.repaint();
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
