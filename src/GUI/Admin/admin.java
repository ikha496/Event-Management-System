package GUI.Admin;

import GUI.mainBoard;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Admin extends JFrame implements ActionListener {
    
        NavigationPanel adminNavigationPanel = new NavigationPanel();
        mainBoard adminBoard = new mainBoard();
        AddUserPanel addUserPanel = new AddUserPanel();
        UpdateDeletePanel updateDeletePanel = new UpdateDeletePanel();
        ShowRequestsPanel showRequestsPanel = new ShowRequestsPanel();
        JLabel welcomeLbl;
        JButton addNewUserBtn,UpdateDeleteUserBtn,showRequestsBtn;
        
        Font newFontlog = new Font("Comic Sans MS", Font.BOLD, 30);
        Font newFont = new Font("Comic Sans MS", Font.BOLD, 20);
        Color co1 = new Color(0,136,145);
        Color co2 = new Color(207,218,200);
        Color co3 = new Color(53,31,57);
        Color co4 = new Color(24,77,71);
        
        
        public Admin()
        {
            this.setTitle("Admin");
            this.setSize(1000, 700);
            this.setVisible(true);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setResizable(false);
            this.setLocation(250, 10);
            this.setLayout(null);
            this.add(adminNavigationPanel);
            this.add(adminBoard);
            
            ///////////////////////////
            
            welcomeLbl = new JLabel("Welcome Admin...");
            welcomeLbl.setFont(newFontlog);
            welcomeLbl.setForeground(co1);
            welcomeLbl.setBounds(15, 30, 280, 70);
            adminNavigationPanel.add(welcomeLbl);
            
            
            ///////////////////////////
            
            addNewUserBtn = new JButton("Add New User");
            addNewUserBtn.setBounds(60, 155, 180, 40);
            addNewUserBtn.setFont(newFont);
            addNewUserBtn.setBorder(null);
            addNewUserBtn.setBackground(co2);
            addNewUserBtn.setForeground(co3);
            adminNavigationPanel.add(addNewUserBtn);
            
            UpdateDeleteUserBtn = new JButton("Update & Delete");
            UpdateDeleteUserBtn.setBounds(60, 305, 180, 40);
            UpdateDeleteUserBtn.setFont(newFont);
            UpdateDeleteUserBtn.setBorder(null);
            UpdateDeleteUserBtn.setBackground(co2);
            UpdateDeleteUserBtn.setForeground(co3);
            adminNavigationPanel.add(UpdateDeleteUserBtn);
            
            showRequestsBtn = new JButton("Show Requests");
            showRequestsBtn.setBounds(60, 455, 180, 40);
            showRequestsBtn.setFont(newFont);
            showRequestsBtn.setBorder(null);
            showRequestsBtn.setBackground(co2);
            showRequestsBtn.setForeground(co3);
            adminNavigationPanel.add(showRequestsBtn);
            addNewUserBtn.addActionListener(this);
            UpdateDeleteUserBtn.addActionListener(this);
            showRequestsBtn.addActionListener(this);
            ///////////////////////////////////
        }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == addNewUserBtn)
        {
            adminBoard.removeAll();
            adminBoard.add(addUserPanel);
            this.repaint();
        }
        
        if(e.getSource() == UpdateDeleteUserBtn)
        {
            adminBoard.removeAll();
            adminBoard.add(updateDeletePanel);
            this.repaint();
        }
        
        if(e.getSource() == showRequestsBtn)
        {
            adminBoard.removeAll();
            adminBoard.add(showRequestsPanel);
            this.repaint();
        }
    }
}
