package petshop;

import javax.swing.*;
import java.awt.*;

public class InventoryContent {
    Connector con = new Connector();
    JPanel inventoryContent = new JPanel();

    public JPanel inventoryContent(String empName){
        inventoryContent.setBounds(300,0,1700,1047);
        inventoryContent.setLayout(null);
        inventoryContent.setBackground(Color.DARK_GRAY);

        JLabel transactions = new JLabel("INVENTORY");
        transactions.setBounds(45,50,550,40);
        transactions.setFont(new Font("Open Sans",Font.PLAIN,50));
        transactions.setForeground(Color.WHITE);
        inventoryContent.add(transactions);

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
