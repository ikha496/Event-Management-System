package GUI.Admin;

import GUI.Admin.NavigationPanel;
import GUI.mainBoard;
import Database.Database;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;

public class AddUserPanel extends JPanel implements ActionListener {

    private ImageIcon img;
    JLabel addNewUserLbl, usernameLbl, phoneLbl, emailLbl, passwordLbl, rePasswordLbl, roleLbl, genderLbl;
    NavigationPanel navigationPanel = new NavigationPanel();
    mainBoard board = new mainBoard();
    JTextField userName, phone, email;
    JPasswordField pass, rePass;
    JRadioButton maleRadioBtn, femaleRadioBtn;
    JComboBox rolesComboBox;
    JButton submitBtn;
    Font newFontlog = new Font("Comic Sans MS", Font.BOLD, 30);
    Font newFont = new Font("Comic Sans MS", Font.BOLD, 24);
    Color co1 = new Color(207, 218, 200);
    Color co2 = new Color(52, 98, 108);
    Color co3 = new Color(33, 33, 33);
    Color co4 = new Color(244, 244, 242);
    Color co5 = new Color(170, 170, 170);
    Color co6 = new Color(200, 200, 200);
    Color co7 = new Color(230, 230, 230);
    Color co8 = new Color(250, 250, 250);
    Color co9 = new Color(248, 241, 241);
    Color co10 = new Color(53, 31, 57);
    Color co11 = new Color(0, 136, 145);
    Color co12 = new Color(170, 170, 170);
    Color co13 = new Color(185, 185, 185);
    Color co14 = new Color(190, 190, 190);

    public AddUserPanel() {
        this.setSize(1000, 700);
        this.setLayout(null);

        ///////////////////////////
        addNewUserLbl = new JLabel("Add New User..");
        addNewUserLbl.setBounds(350, 30, 300, 30);
        addNewUserLbl.setFont(newFontlog);
        addNewUserLbl.setBackground(co1);
        this.add(addNewUserLbl);

        usernameLbl = new JLabel("Username");
        usernameLbl.setBounds(500, 100, 300, 30);
        usernameLbl.setFont(newFont);
        usernameLbl.setForeground(co3);
        this.add(usernameLbl);

        phoneLbl = new JLabel("Phone-num");
        phoneLbl.setBounds(500, 170, 300, 30);
        phoneLbl.setFont(newFont);
        phoneLbl.setForeground(co3);
        this.add(phoneLbl);

        emailLbl = new JLabel("E-mail");
        emailLbl.setBounds(500, 240, 300, 30);
        emailLbl.setFont(newFont);
        emailLbl.setForeground(co3);
        this.add(emailLbl);

        passwordLbl = new JLabel("Password");
        passwordLbl.setBounds(500, 310, 300, 30);
        passwordLbl.setFont(newFont);
        passwordLbl.setForeground(co5);
        this.add(passwordLbl);

        rePasswordLbl = new JLabel("Re-Password");
        rePasswordLbl.setBounds(500, 380, 300, 30);
        rePasswordLbl.setFont(newFont);
        rePasswordLbl.setForeground(co6);
        this.add(rePasswordLbl);

        roleLbl = new JLabel("Role");
        roleLbl.setBounds(500, 450, 300, 30);
        roleLbl.setFont(newFont);
        roleLbl.setForeground(co7);
        this.add(roleLbl);

        genderLbl = new JLabel("Gender");
        genderLbl.setBounds(500, 520, 300, 30);
        genderLbl.setFont(newFont);
        genderLbl.setForeground(co8);
        this.add(genderLbl);

        ////////////////////////////
        userName = new JTextField();
        userName.setBounds(630, 107, 280, 20);
        userName.setBorder(null);
        userName.setBackground(co12);
        this.add(userName);

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

        rePass = new JPasswordField();
        rePass.setBounds(655, 387, 265, 20);
        rePass.setBorder(null);
        rePass.setBackground(co4);
        this.add(rePass);

        rolesComboBox = new JComboBox();
        rolesComboBox.setBounds(570, 457, 300, 20);
        rolesComboBox.addItem("Admin");
        rolesComboBox.addItem("SP");
        rolesComboBox.addItem("PM");
        rolesComboBox.addItem("User");
        rolesComboBox.setBackground(co4);
        this.add(rolesComboBox);

        maleRadioBtn = new JRadioButton("Male");
        femaleRadioBtn = new JRadioButton("Female");
        maleRadioBtn.setBackground(co4);
        femaleRadioBtn.setBackground(co4);
        maleRadioBtn.setBounds(610, 527, 70, 20);
        femaleRadioBtn.setBounds(750, 527, 70, 20);
        this.add(maleRadioBtn);
        this.add(femaleRadioBtn);

        submitBtn = new JButton("Submit");
        submitBtn.setBounds(750, 590, 170, 40);
        submitBtn.setFont(newFont);
        submitBtn.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, co11));
        submitBtn.setBackground(co9);
        submitBtn.setForeground(co10);
        this.add(submitBtn);

        submitBtn.addActionListener(this);

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
        if (arg0.getSource() == submitBtn) {
            Database d = new Database();
            d.connect();
            int phone;
            try {
                phone = Integer.parseInt(this.phone.getText());
            } catch (Exception y) {
                JOptionPane.showMessageDialog(null, "Enter A valid phone number", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
            phone = Integer.parseInt(this.phone.getText());

            if (!pass.getText().equals(rePass.getText())) {
                JOptionPane.showMessageDialog(null, "Password don't match", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else if ((pass.getText().length()) < 8) {
                JOptionPane.showMessageDialog(null, "Password should be more than 8 characters",
                        "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                String gender = "Unkown";
                if (maleRadioBtn.isSelected()) {
                    gender = "Male";
                } else {
                    gender = "Female";
                }
                d.insertUser(userName.getText(),
                        email.getText(),
                        pass.getText(),
                        phone,
                        String.valueOf(rolesComboBox.getSelectedItem()).toLowerCase(),
                        gender);

                JOptionPane.showMessageDialog(null, "Account created succesfully");
                
                //Empty the textboxes in the form
                for (Component control : this.getComponents()) {
                    if (control instanceof JTextField) {
                        JTextField ctrl = (JTextField) control;
                        ctrl.setText("");
                    } else if (control instanceof JPasswordField) {
                        JPasswordField ctr = (JPasswordField) control;
                        ctr.setText("");
                    } else if (control instanceof JRadioButton) {
                        JRadioButton ctr = (JRadioButton) control;
                        ctr.setSelected(false);
                    }
                }
                navigationPanel.repaint();
            }
        }
    }
}
