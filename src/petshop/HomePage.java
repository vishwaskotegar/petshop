package petshop;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;


public class HomePage extends JFrame{
    JPanel panel;


    public HomePage(String lID){

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

        JButton manage = new JButton("MANAGE PETS");
        manage.setBounds(30,20,225,50);
        navigator.add(manage);

        JButton selling = new JButton("SELL");
        selling.setBounds(30,90,225,50);
        navigator.add(selling);

        JButton buying = new JButton("BUY");
        buying.setBounds(30,160,225,50);
        navigator.add(buying);

        JButton inventory = new JButton("INVENTORY");
        inventory.setBounds(30,230,225,50);
        navigator.add(inventory);

        JButton transactions = new JButton("TRANSACTIONS");
        transactions.setBounds(30,300,225,50);
        navigator.add(transactions);

        JButton editProfile = new JButton("EDIT PROFILE");
        editProfile.setBounds(30,370,225,50);
        navigator.add(editProfile);

        JButton logOut = new JButton("LOGOUT");
        logOut.setBounds(30,440,225,50);
        navigator.add(logOut);

//        String empName = "";
//        try{
//            Connector con = new Connector();
//            ResultSet rs = con.s.executeQuery("SELECT Fname from emp where lID = "+Lid);
//            if (rs.next()) {
//                empName = (rs.getString(1));
//            }
//        }catch(Exception ce){
//            ce.printStackTrace();
//        }

        add(panel = new SellContent().sellContent(lID));
        revalidate();
        repaint();

        manage.addActionListener(e -> {
            remove(panel);
            add(panel = new AddOrDelete().addOrDelete(lID));
            revalidate();
            repaint();
        });


        buying.addActionListener(e -> {
            remove(panel);
            add(panel = new BuyContent().buyContent(lID));
            revalidate();
            repaint();
        });

        selling.addActionListener(e -> {
            remove(panel);
            add(panel = new SellContent().sellContent(lID));
            revalidate();
            repaint();

        });

        editProfile.addActionListener(e -> {
            remove(panel);
            add(panel = new EditContent().editContent(lID));
            revalidate();
            repaint();
        });

        transactions.addActionListener(e -> {
            remove(panel);
            add(panel = new TransactContent().transactContent(lID));
            revalidate();
            repaint();
        });

        inventory.addActionListener(e -> {
            remove(panel);
            add(panel = new InventoryContent().inventoryContent(lID));
            revalidate();
            repaint();
        });

        logOut.addActionListener(e -> {
            new Login("");
            dispose();
        });


        setVisible(true);
    }



    public static void main(String[] args) {
        new HomePage("3");
    }
}
