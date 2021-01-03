package petshop;

import javax.swing.*;
import java.awt.*;

public class TransactContent  {
    Connector con = new Connector();
    JPanel transactContent = new JPanel();

    public JPanel transactContent(String empName){
        transactContent.setBounds(300,0,1700,1047);
        transactContent.setLayout(null);
        transactContent.setBackground(Color.DARK_GRAY);

        JLabel transactions = new JLabel("TRANSACTIONS");
        transactions.setBounds(45,50,550,40);
        transactions.setFont(new Font("Open Sans",Font.PLAIN,50));
        transactions.setForeground(Color.WHITE);
        transactContent.add(transactions);

        JLabel emp = new JLabel("EMPLOYEE NAME - "+empName,SwingConstants.RIGHT);
        emp.setBounds(1150,80,400,25);
        emp.setFont(new Font("Open Sans",Font.PLAIN,20));
        emp.setForeground(Color.WHITE);
        transactContent.add(emp);

        JTable table = new JTable();
        table.setBounds(200,200,1200,700);
        transactContent.add(table);


        return transactContent;
    }
}
