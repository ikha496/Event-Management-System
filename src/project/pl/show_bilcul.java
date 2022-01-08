package project.pl;

import Database.database;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class show_bilcul extends JPanel implements ActionListener{
    
    private ImageIcon img ;
    JLabel l1;
    javax.swing.JTable jTableEvents = new javax.swing.JTable();
    DefaultTableModel dtm = new DefaultTableModel();
    database db=new database();    JScrollPane soc;
    JButton b1 ;
    Font newFontlog = new Font("Comic Sans MS", Font.BOLD, 30);
    Font newFont = new Font("Comic Sans MS", Font.BOLD, 24);
    Color co1 = new Color(207,218,200);
    Color co11 = new Color(0,136,145);
    Color co15 = new Color(232,234,230);
    Color co3 = new Color(33,33,33);
    

    public show_bilcul() {
        
        this.setLayout(null);
        this.setSize(1000, 700);
        
        l1 = new JLabel("The Requests");
        l1.setBounds(350, 30, 300, 30);
        l1.setFont(newFontlog);
        l1.setBackground(co1);
        this.add(l1);
        
        
        ////////////////////////////////
        
        jTableEvents.setModel(dtm);
        dtm.addColumn("Reservation Number");
        dtm.addColumn("Event Name");
        dtm.addColumn("Location");
        dtm.addColumn("Event Details");
        dtm.addColumn("Password");
        dtm.addColumn("Price");
        dtm.addColumn("ReadyDate");
        try {
            ResultSet resulSet=db.getEvents("user2");
            while(resulSet.next()){
                dtm.addRow(new Object[]{resulSet.getString("reservationNumber"),
                    resulSet.getString("eventName"),resulSet.getString("location"),
                    resulSet.getString("eventDetails"),resulSet.getString("password"),
                    resulSet.getInt("price"),resulSet.getString("readyDate")
                });
            }
            resulSet.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        soc = new JScrollPane(jTableEvents);
        soc.setBounds(320, 100, 635, 350);
        this.add(soc);
        
      
        
        ///////////////////////////////
        
            b1 = new JButton("Confirm ..");
            b1.setBounds(500, 500, 300, 70);
            b1.setFont(newFont);
            b1.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, co11));
            b1.setBackground(co15);
            b1.setForeground(co3);
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
        database.update("user2", "confirmed");
        dtm.setRowCount(0);
        dtm.fireTableDataChanged();
        JOptionPane.showMessageDialog(null,"Congratulations Your Event is Confirmed");
    }
    
    
    
    
}
