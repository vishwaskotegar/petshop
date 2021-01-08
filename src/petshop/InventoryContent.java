package petshop;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class InventoryContent {
    Connector con = new Connector();
    JPanel inventoryContent = new JPanel();

    public JPanel inventoryContent(String lID){
        inventoryContent.setBounds(300,0,1700,1047);
        inventoryContent.setLayout(null);
        inventoryContent.setBackground(Color.DARK_GRAY);

        JLabel transactions = new JLabel("INVENTORY");
        transactions.setBounds(45,50,550,40);
        transactions.setFont(new Font("Open Sans",Font.PLAIN,50));
        transactions.setForeground(Color.WHITE);
        inventoryContent.add(transactions);

        String empName = "";
        try{
            Connector con = new Connector();
            ResultSet rs = con.s.executeQuery("SELECT Fname, lname from emp where lID = "+lID);
            if (rs.next()) {
                empName = (rs.getString(1) +" "+ rs.getString(2));
            }
        }catch(Exception ce){
            ce.printStackTrace();
        }

        JLabel emp = new JLabel("EMPLOYEE NAME - "+empName,SwingConstants.RIGHT);
        emp.setBounds(1150,80,400,25);
        emp.setFont(new Font("Open Sans",Font.PLAIN,20));
        emp.setForeground(Color.WHITE);
        inventoryContent.add(emp);

        JTable table = new JTable();
        table.setBounds(200,200,1200,700);
        inventoryContent.add(table);


        return inventoryContent;
    }
}
