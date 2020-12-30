package petshop;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HomePage extends JFrame{

    Connector con = new Connector();
    JPanel panel = new JPanel();

    public HomePage(){

        setTitle("HOME PAGE");
        setSize(974, 1047);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

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

        buying.addActionListener(e -> {
            add(new BuyContent().buyContent());
            revalidate();
            repaint();
        });

        setVisible(true);
    }



    public static void main(String[] args) {
        new HomePage();
    }
}
