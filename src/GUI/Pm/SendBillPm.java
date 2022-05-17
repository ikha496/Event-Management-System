package GUI.Pm;

import Database.database;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.table.*;


public class SendBillPm extends JPanel implements ActionListener{
    
    private ImageIcon img ;
    JLabel l1;
    JScrollPane soc;
    JButton sendToCus_Btn ;
    javax.swing.JTable jTableEvents = new javax.swing.JTable();
    DefaultTableModel dtm = new DefaultTableModel();
    database db=new database();
    Font newFontlog = new Font("Comic Sans MS", Font.BOLD, 30);
    Font newFont = new Font("Comic Sans MS", Font.BOLD, 24);
    Color co1 = new Color(207,218,200);
    Color co11 = new Color(0,136,145);
    Color co15 = new Color(232,234,230);
    Color co3 = new Color(33,33,33);
    
    
    

    public SendBillPm() {
        this.setLayout(null);
        this.setSize(1000, 700);
        
        l1 = new JLabel("Send The Bill...");
        l1.setBounds(350, 30, 300, 30);
        l1.setFont(newFontlog);
        l1.setBackground(co1);
        this.add(l1);
        
        
        ////////////////////////////////
        jTableEvents.setModel(dtm);
        dtm.addColumn("Event Name");
        dtm.addColumn("Price");
        dtm.addColumn("Date");
        try {
        ResultSet events=db.getEvents("pm2");
        
        while(events.next()){
            dtm.addRow(new Object[]{events.getString("eventName"),
                events.getString("price"),events.getString("readyDate")
            });
        }
        events.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        
        soc = new JScrollPane(jTableEvents);
        soc.setBounds(320, 100, 635, 350);
        this.add(soc);
        
      
        
        ///////////////////////////////
        
            sendToCus_Btn = new JButton("Send To Customer");
            sendToCus_Btn.setBounds(500, 500, 300, 70);
            sendToCus_Btn.setFont(newFont);
            sendToCus_Btn.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, co11));
            sendToCus_Btn.setBackground(co15);
            sendToCus_Btn.setForeground(co3);
            sendToCus_Btn.addActionListener(this);
            this.add(sendToCus_Btn);
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
        if(arg0.getSource()==sendToCus_Btn){
            database.update("pm2", "user2");
            dtm.setRowCount(0);
            dtm.fireTableDataChanged();
            JOptionPane.showMessageDialog(null,"Bills sent succesfully");
        
    }   
}
}
    
    
        

