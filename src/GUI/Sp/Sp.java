package GUI.Sp;

import GUI.Sp.sendSP;
import GUI.mainBoard;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Sp extends JFrame implements ActionListener {

    spPanel p1 = new spPanel();
    mainBoard p2 = new mainBoard();
    sendSP p3 = new sendSP();

    JLabel l1, l2;
    JButton b1, b2, b3;

    Font newFontlog = new Font("Comic Sans MS", Font.BOLD, 30);
    Font newFont = new Font("Comic Sans MS", Font.BOLD, 20);
    Color co1 = new Color(0, 136, 145);
    Color co2 = new Color(232, 234, 230);
    Color co3 = new Color(53, 31, 57);
    Color co4 = new Color(24, 77, 71);
    Color co11 = new Color(207, 218, 200);

    public Sp() {
        this.setTitle("Service Provider");
        this.setSize(1000, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocation(250, 10);
        this.setLayout(null);
        this.add(p1);
        this.add(p2);

        ///////////////////////////
        l1 = new JLabel("Welcome SP");
        l1.setFont(newFontlog);
        l1.setForeground(co1);
        l1.setBounds(53, 20, 300, 30);
        p1.add(l1);

        ///////////////////////////
        b1 = new JButton("Show & Send");
        b1.setBounds(65, 305, 170, 40);
        b1.setFont(newFont);
        b1.setBorder(null);
        b1.setBackground(co11);
        b1.setForeground(co3);
        p1.add(b1);

        b1.addActionListener(this);

        ////////////////////////////////////
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b1) {
            p2.removeAll();
            p2.add(p3);
            this.repaint();
        }

    }
}
