package GUI.Customer;

import GUI.mainBoard;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Customer extends JFrame implements ActionListener {

    NavigationPanel navigationPanel = new NavigationPanel();
    mainBoard board = new mainBoard();
    CreateEventPanel createEventPanel = new CreateEventPanel();
    ShowBillPanel showBillPanel = new ShowBillPanel();

    JLabel welcomeLabel;
    JButton createEventBtn, showBillBtn;

    Font newFontlog = new Font("Comic Sans MS", Font.BOLD, 30);
    Font newFont = new Font("Comic Sans MS", Font.BOLD, 20);
    Color co1 = new Color(0, 136, 145);
    Color co2 = new Color(232, 234, 230);
    Color co3 = new Color(53, 31, 57);
    Color co4 = new Color(24, 77, 71);
    Color co11 = new Color(207, 218, 200);

    public Customer() {

        this.setTitle("Customer");
        this.setSize(1000, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocation(250, 10);
        this.setLayout(null);
        this.add(navigationPanel);
        this.add(board);

        ///////////////////////////
        welcomeLabel = new JLabel("Welcome Customer");
        welcomeLabel.setFont(newFontlog);
        welcomeLabel.setForeground(co1);
        welcomeLabel.setBounds(13, 20, 300, 30);
        navigationPanel.add(welcomeLabel);

        ///////////////////////////
        createEventBtn = new JButton("Create Event");
        createEventBtn.setBounds(65, 205, 170, 40);
        createEventBtn.setFont(newFont);
        createEventBtn.setBorder(null);
        createEventBtn.setBackground(co11);
        createEventBtn.setForeground(co3);
        navigationPanel.add(createEventBtn);

        showBillBtn = new JButton("Show Bill");
        showBillBtn.setBounds(65, 405, 170, 40);
        showBillBtn.setFont(newFont);
        showBillBtn.setBorder(null);
        showBillBtn.setBackground(co11);
        showBillBtn.setForeground(co3);
        navigationPanel.add(showBillBtn);

        createEventBtn.addActionListener(this);
        showBillBtn.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == createEventBtn) {
            board.removeAll();
            board.add(createEventPanel);
            this.repaint();
        }
        if (e.getSource() == showBillBtn) {
            board.removeAll();
            board.add(showBillPanel);
            this.repaint();
        }
    }
}
