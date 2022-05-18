package GUI.Sp;

import Database.Database;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyVetoException;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class sendSP extends JPanel implements ActionListener{
    
    private ImageIcon img ;
    JLabel setTheDateLbl;
    javax.swing.JTable jTableEvents = new javax.swing.JTable();
    DefaultTableModel dtm = new DefaultTableModel();
    Database db=new Database();
    JScrollPane soc;
    JButton sendToPmBtn ;
    Font newFontlog = new Font("Comic Sans MS", Font.BOLD, 30);
    Font newFont = new Font("Comic Sans MS", Font.BOLD, 24);
    Color co1 = new Color(207,218,200);
    Color co11 = new Color(0,136,145);
    Color co15 = new Color(232,234,230);
    Color co3 = new Color(33,33,33);
    

    public sendSP() {
    this.setLayout(null);
        this.setSize(1000, 700);
        
        setTheDateLbl = new JLabel("Set The Date And Price For All Event");
        setTheDateLbl.setBounds(310, 30, 400, 30);
        setTheDateLbl.setFont(newFontlog);
        setTheDateLbl.setBackground(co1);
        this.add(setTheDateLbl);
        
        
        ////////////////////////////////
        
        jTableEvents.setModel(dtm);
        dtm.addColumn("Reservation Number");
        dtm.addColumn("Event Name");
        dtm.addColumn("Location");
        dtm.addColumn("Event Details");
        dtm.addColumn("Password");
        dtm.addColumn("Date");
        dtm.addColumn("Price");
        
        try {
        ResultSet resulSet=db.getEvents("sp");
        while(resulSet.next()){
            dtm.addRow(new Object[]{resulSet.getString("reservationNumber"),
                resulSet.getString("eventName"),resulSet.getString("location"),
                resulSet.getString("eventDetails"),resulSet.getString("password"),
                resulSet.getString("readydate"),resulSet.getString("price")
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
        
            sendToPmBtn = new JButton("Send To PM...");
            sendToPmBtn.setBounds(500, 500, 300, 70);
            sendToPmBtn.setFont(newFont);
            sendToPmBtn.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, co11));
            sendToPmBtn.setBackground(co15);
            sendToPmBtn.setForeground(co3);
            sendToPmBtn.addActionListener(this);
            this.add(sendToPmBtn);
        
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        img = new ImageIcon(getClass().getResource("pnn1.jpg"));
        img.paintIcon(this, g, 0, 0);
        g.setColor(co1);
        g.fill3DRect(301, 25, 430, 50, true);
        
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        if(arg0.getSource()==sendToPmBtn){
            for(int i=0; i<dtm.getRowCount();i++)
            {
                db.addPriceDate((String)dtm.getValueAt(i, 0),
                        (String)dtm.getValueAt(i, 6),
                        (String)dtm.getValueAt(i, 5));
            }

            Database.update("sp","pm2");
            dtm.setRowCount(0);
            dtm.fireTableDataChanged();
            JOptionPane.showMessageDialog(null,"Requests sent succesfully");
        
        }
    }
    
}
