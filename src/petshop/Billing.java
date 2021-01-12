package petshop;

import javax.swing.*;
import java.awt.*;


public class Billing extends JFrame{


    public Billing(){

        setTitle("BILLING");
        setSize(974, 1047);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        //setUndecorated(true);
        //setLocationRelativeTo(null);


        /*JButton b = new JButton("b");
        b.setBounds(0,0,25,25);
        add(b);

        b.addActionListener(e -> {
            Dimension x = getSize();
            System.out.println(x);
        });*/

        JLabel shopName = new JLabel("SHOP NAME");
        shopName.setBounds(50,50,400,50);
        shopName.setFont(new Font("Tahoma",Font.TRUETYPE_FONT,40));
        add(shopName);

        JLabel invoice = new JLabel("Invoice");
        invoice.setBounds(805,60,100,25);
        invoice.setFont(new Font("Arial",Font.BOLD,25));
        invoice.setForeground(new Color(0x018293));
        add(invoice);

        JLabel address = new JLabel("address1");
        address.setBounds(50,110,300,25);
        address.setFont(new Font("Arial",Font.PLAIN,20));
        add(address);

        JLabel address1 = new JLabel("address2");
        address1.setBounds(50,135,300,25);
        address1.setFont(new Font("Arial",Font.PLAIN,20));
        add(address1);

        JLabel address2 = new JLabel("address3");
        address2.setBounds(50,160,300,25);
        address2.setFont(new Font("Arial",Font.PLAIN,20));
        add(address2);

        JLabel invoiceNo = new JLabel("#",SwingConstants.RIGHT);
        invoiceNo.setBounds(790,90,100,25);
        invoiceNo.setFont(new Font("Arial",Font.PLAIN,20));
        add(invoiceNo);

        JLabel billTo = new JLabel("Bill To:");
        billTo.setBounds(50,215,300,25);
        billTo.setFont(new Font("Arial",Font.BOLD,20));
        billTo.setForeground(new Color(0x018293));
        add(billTo);

        JLabel customerName = new JLabel("Cusname");
        customerName.setBounds(50,240,300,25);
        customerName.setFont(new Font("Arial",Font.PLAIN,20));
        add(customerName);

        JLabel email = new JLabel("email");
        email.setBounds(50,260,300,25);
        email.setFont(new Font("Arial",Font.PLAIN,20));
        add(email);

        JLabel invoiceDate = new JLabel("Invoice Date");
        invoiceDate.setBounds(50,320,300,25);
        invoiceDate.setFont(new Font("Arial",Font.BOLD,24));
        invoiceDate.setForeground(new Color(0x018293));
        add(invoiceDate);

        JLabel date = new JLabel("date");
        date.setBounds(50,350,300,25);
        date.setFont(new Font("Arial",Font.PLAIN,20));
        add(date);

        JTable table = new JTable();
        table.setBounds(50,400,840,400);
        add(table);

        JLabel total = new JLabel("  Total");
        total.setBounds(650,800,240,30);
        total.setFont(new Font("Arial",Font.PLAIN,20));
        total.setOpaque(true);
        total.setBackground(new Color(0x018293));
        total.setForeground(Color.WHITE);
        add(total);

        JLabel totalValue = new JLabel("200",SwingConstants.RIGHT);
        totalValue.setBounds(100,0,120,30);
        totalValue.setFont(new Font("Arial",Font.PLAIN,20));
        //totalValue.setOpaque(true);
        //totalValue.setBackground(new Color(0x018293));
        totalValue.setForeground(Color.WHITE);
        total.add(totalValue);

        JLabel wishes = new JLabel("Thank you for Your purchase");
        wishes.setBounds(50,830,300,30);
        wishes.setFont(new Font("Arial",Font.ITALIC,20));
        wishes.setForeground(Color.GRAY);
        add(wishes);


        setVisible(true);
    }



    public static void main(String[] args) {
        new Billing();
    }
}
