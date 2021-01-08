package petshop;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class TransactContent  {
    Connector con = new Connector();
    JPanel transactContent = new JPanel();

    public JPanel transactContent(String lID){
        transactContent.setBounds(300,0,1700,1047);
        transactContent.setLayout(null);
        transactContent.setBackground(Color.DARK_GRAY);

        JLabel transactions = new JLabel("TRANSACTIONS");
        transactions.setBounds(45,50,550,40);
        transactions.setFont(new Font("Open Sans",Font.PLAIN,50));
        transactions.setForeground(Color.WHITE);
        transactContent.add(transactions);

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
        transactContent.add(emp);

        JTable table = new JTable();
        table.setBounds(200,200,1200,700);
        transactContent.add(table);


        return transactContent;
    }
}
