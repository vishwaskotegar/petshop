package petshop;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HomePage extends JFrame{
    public HomePage(){
        setTitle("HOME PAGE");
        setSize(974, 1047);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setBackground(Color.DARK_GRAY);
        //setUndecorated(true);
        //setLocationRelativeTo(null);


        /*JButton b = new JButton("b");
        b.setBounds(0,0,25,25);
        add(b);

        b.addActionListener(e -> {
            Dimension x = getSize();
            System.out.println(x);
        });*/

        JPanel navigator = new JPanel();
        navigator.setBounds(0,0,300,1047);
        navigator.setBackground(Color.CYAN);
        navigator.setLayout(null);
        add(navigator);

        JPanel contentArea = new JPanel();


        JButton selling = new JButton("SELL");
        selling.setBounds(30,20,225,50);
        navigator.add(selling);

        JButton buying = new JButton("BUY");
        buying.setBounds(30,90,225,50);
        navigator.add(buying);

        JButton inventory = new JButton("INVENTORY");
        inventory.setBounds(30,160,225,50);
        navigator.add(inventory);

        JButton transactions = new JButton("TRANSACTIONS");
        transactions.setBounds(30,230,225,50);
        navigator.add(transactions);

        JButton editUser = new JButton("EDIT USER");
        editUser.setBounds(30,300,225,50);
        navigator.add(editUser);

        JTable table = new JTable();
        try {

            Connector con = new Connector();
            ResultSet rs = con.s.executeQuery("SELECT * FROM INVENTORY;");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            JScrollPane pane = new JScrollPane(table);
            pane.setBounds(900,50,500,200);
            contentArea.add(pane);
        }catch (SQLException se){
            System.out.println(se);
        }



        buying.addActionListener(e -> {
            contentArea.setBounds(300,0,1700,1047);
            contentArea.setLayout(null);
            add(contentArea);

            JButton bls = new JButton("BALINESE");
            bls.setBounds(400,50,225,50);
            contentArea.add(bls);

            JButton kb = new JButton("KURILIAN BOBTAIL");
            kb.setBounds(800,50,225,50);
            contentArea.add(kb);

            JButton  mk = new JButton("MUNCHKIN");
            mk.setBounds(0,150,225,50);
            contentArea.add(mk);

            JButton p = new JButton("PERSIAN");
            p.setBounds(400,150,225,50);
            contentArea.add(p);

            JButton s = new JButton("SIBERIAN");
            s.setBounds(800,150,225,50);
            contentArea.add(s);
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new HomePage();
    }
}
