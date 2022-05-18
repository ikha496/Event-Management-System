package GUI.Admin;

import Database.Database;
import event.managment.system.Admin;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ShowRequestsPanel extends JPanel implements ActionListener{

    private ImageIcon img ;
    JLabel theRequestsLbl;
    javax.swing.JTable jTableEvents = new javax.swing.JTable();
    DefaultTableModel dtm = new DefaultTableModel();
    Database db=new Database();
    JScrollPane soc;
    JButton sendRequestsBtn ;
    Font newFontlog = new Font("Comic Sans MS", Font.BOLD, 30);
    Font newFont = new Font("Comic Sans MS", Font.BOLD, 24);
    Color co1 = new Color(207,218,200);
    Color co11 = new Color(0,136,145);
    Color co15 = new Color(232,234,230);
    Color co3 = new Color(33,33,33);
    
    public ShowRequestsPanel() {
        
        this.setLayout(null);
        this.setSize(1000, 700);
        
        theRequestsLbl = new JLabel("The Requests");
        theRequestsLbl.setBounds(350, 30, 300, 30);
        theRequestsLbl.setFont(newFontlog);
        theRequestsLbl.setBackground(co1);
        this.add(theRequestsLbl);
        
        ////////////////////////////////
        
        jTableEvents.setModel(dtm);
        dtm.addColumn("Reservation Number");
        dtm.addColumn("Event Name");
        dtm.addColumn("Location");
        dtm.addColumn("Event Details");
        dtm.addColumn("Password");
        try {
            Admin e = new Admin();
            ResultSet resulSet=e.getEvents();
            while(resulSet.next()){
                dtm.addRow(new Object[]{resulSet.getString("reservationNumber"),
                    resulSet.getString("eventName"),resulSet.getString("location"),
                    resulSet.getString("eventDetails"),resulSet.getString("password")
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
        
        sendRequestsBtn = new JButton("Send Requests...");
        sendRequestsBtn.setBounds(500, 500, 300, 70);
        sendRequestsBtn.setFont(newFont);
        sendRequestsBtn.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, co11));
        sendRequestsBtn.setBackground(co15);
        sendRequestsBtn.setForeground(co3);
        sendRequestsBtn.addActionListener(this);
        this.add(sendRequestsBtn);
        
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
        if(arg0.getSource()==sendRequestsBtn){
            Database.update("admin", "pm1");
            dtm.setRowCount(0);
            dtm.fireTableDataChanged();
            JOptionPane.showMessageDialog(null,"Requests sent succesfully");
        }
    }
    
    
    
}
