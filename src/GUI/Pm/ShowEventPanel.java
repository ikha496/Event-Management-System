package GUI.Pm;

import Database.Database;
import event.managment.system.Pm;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ShowEventPanel extends JPanel implements ActionListener{
    
    private ImageIcon img ;
    JLabel label1_the_bill;
    javax.swing.JTable jTableEvents = new javax.swing.JTable();
    DefaultTableModel dtm = new DefaultTableModel();
    Database db=new Database();
    JScrollPane soc;
    JButton sendToSpBtn ;
    Font newFontlog = new Font("Comic Sans MS", Font.BOLD, 30);
    Font newFont = new Font("Comic Sans MS", Font.BOLD, 24);
    Color co1 = new Color(207,218,200);
    Color co11 = new Color(0,136,145);
    Color co15 = new Color(232,234,230);
    Color co3 = new Color(33,33,33);
    

    public ShowEventPanel() {
        
        this.setLayout(null);
        this.setSize(1000, 700);
        
        label1_the_bill = new JLabel("The Bill...");
        label1_the_bill.setBounds(450, 30, 300, 30);
        label1_the_bill.setFont(newFontlog);
        label1_the_bill.setBackground(co1);
        this.add(label1_the_bill);
        
        
        ////////////////////////////////
        
        jTableEvents.setModel(dtm);
        dtm.addColumn("Reservation Number");
        dtm.addColumn("Event Name");
        dtm.addColumn("Location");
        dtm.addColumn("Event Details");
        dtm.addColumn("Password");
        dtm.addColumn("ownerEmail");
        try {
            Pm pm = new Pm();
        ResultSet resulSet=pm.getCustomerRequest();
        while(resulSet.next()){
            dtm.addRow(new Object[]{resulSet.getString("reservationNumber"),
                resulSet.getString("eventName"),resulSet.getString("location"),
                resulSet.getString("eventDetails"),resulSet.getString("password"),
                resulSet.getString("ownerEmail")
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
        
            sendToSpBtn = new JButton("Send To SP...");
            sendToSpBtn.setBounds(500, 500, 300, 70);
            sendToSpBtn.setFont(newFont);
            sendToSpBtn.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, co11));
            sendToSpBtn.setBackground(co15);
            sendToSpBtn.setForeground(co3);
            sendToSpBtn.addActionListener(this);
            this.add(sendToSpBtn);
        
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
        if(arg0.getSource()==sendToSpBtn){
            Pm pm = new Pm();
            pm.sendEventsToSp();
            dtm.setRowCount(0);
            dtm.fireTableDataChanged();
            JOptionPane.showMessageDialog(null,"Requests sent succesfully");
        }
    }
    
    
    
}
