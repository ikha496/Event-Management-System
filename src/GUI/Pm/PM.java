package GUI.Pm;

import GUI.mainBoard;
import GUI.Customer.NavigationPanel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class PM extends JFrame implements ActionListener{
    
    NavigationPanel navigationPanel = new NavigationPanel();
    mainBoard board = new mainBoard();
    ShowEventPanel showEventPanel = new ShowEventPanel();
    SendBillPm sendBillPm = new SendBillPm();
    
        JLabel welcomeLbl;
        JButton showEventBtn,showSendBillBtn,b3;
        
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
        this.add(navigationPanel);
        this.add(board);
        
        ///////////////////////////
            
            welcomeLbl = new JLabel("Welcome PM");
            welcomeLbl.setFont(newFontlog);
            welcomeLbl.setForeground(co1);
            welcomeLbl.setBounds(53, 20, 300, 30);
            navigationPanel.add(welcomeLbl);
            
            
            ///////////////////////////
            
            showEventBtn = new JButton("Show Event");
            showEventBtn.setBounds(65, 205, 170, 40);
            showEventBtn.setFont(newFont);
            showEventBtn.setBorder(null);
            showEventBtn.setBackground(co11);
            showEventBtn.setForeground(co3);
            navigationPanel.add(showEventBtn);
            
            showSendBillBtn = new JButton("Show & send Bill");
            showSendBillBtn.setBounds(65, 405, 170, 40);
            showSendBillBtn.setFont(newFont);
            showSendBillBtn.setBorder(null);
            showSendBillBtn.setBackground(co11);
            showSendBillBtn.setForeground(co3);
            navigationPanel.add(showSendBillBtn);
            
            
            showEventBtn.addActionListener(this);
            showSendBillBtn.addActionListener(this);
            
            ////////////////////////////////////
            

        }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == showEventBtn)
        {
            board.removeAll();
            board.add(showEventPanel);
            this.repaint();
        }
        if(e.getSource() == showSendBillBtn)
         {
            board.removeAll();
            board.add(sendBillPm);
            this.repaint();
       }
    
}
}
