package petshop;

import javax.swing.*;
import java.awt.*;


public class HomePage extends JFrame{
    JPanel panel;

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

        JButton editProfile = new JButton("EDIT PROFILE");
        editProfile.setBounds(30,300,225,50);
        navigator.add(editProfile);

        add(panel = new SellContent().sellContent());
        revalidate();
        repaint();


        buying.addActionListener(e -> {
            remove(panel);
            add(panel = new BuyContent().buyContent());
            revalidate();
            repaint();
        });

        selling.addActionListener(e -> {
            remove(panel);
            add(panel = new SellContent().sellContent());
            revalidate();
            repaint();

        });

        editProfile.addActionListener(e -> {
            remove(panel);
            add(panel = new editContent().editContent());
            revalidate();
            repaint();
        });



        setVisible(true);
    }



    public static void main(String[] args) {
        new HomePage();
    }
}
