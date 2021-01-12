package petshop;

import com.mysql.cj.jdbc.result.ResultSetImpl;
import net.proteanit.sql.DbUtils;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.text.*;
import java.util.Date;

public class SellContent extends JFrame {
    Connector con = new Connector();
    JPanel sellContent = new JPanel();
    String value;


    public JPanel sellContent(String lID){

        sellContent.setBackground(Color.DARK_GRAY);

        //table.setBackground(Color.DARK_GRAY);
        //table.setForeground(Color.WHITE);



        JLabel profile = new JLabel("SELLING");
        profile.setBounds(45,50,550,40);
        profile.setFont(new Font("Open Sans",Font.PLAIN,50));
        profile.setForeground(Color.WHITE);
        sellContent.add(profile);

        sellContent.setBounds(300,0,1700,1047);
        sellContent.setLayout(null);

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
        sellContent.add(emp);



        JLabel pet = new JLabel("PET");
        pet.setBounds(25,250,150,25);
        pet.setFont(new Font("Open Sans",Font.PLAIN,20));
        pet.setForeground(Color.WHITE);
        sellContent.add(pet);

        JLabel type = new JLabel("TYPE/BREED");
        type.setBounds(25,300,150,25);
        type.setFont(new Font("Open Sans",Font.PLAIN,20));
        type.setForeground(Color.WHITE);
        sellContent.add(type);

        JRadioButton breed = new JRadioButton("BREED");
        breed.setBounds(220,300,100,25);
        breed.setFont(new Font("Open Sans",Font.PLAIN,20));
        breed.setOpaque(false);
        breed.setActionCommand("breed");
//        breed.setFocusable(false);
        breed.setForeground(Color.WHITE);
        sellContent.add(breed);

        JRadioButton accessories = new JRadioButton("ACCESSORY");
        accessories.setBounds(340,300,150,25);
        accessories.setFont(new Font("Open Sans",Font.PLAIN,20));
        accessories.setOpaque(false);
        accessories.setActionCommand("accessory");
//        breed.setFocusable(false);
        accessories.setForeground(Color.WHITE);
        sellContent.add(accessories);

        ButtonGroup bg = new ButtonGroup();
        bg.add(breed);bg.add(accessories);




        JLabel jdate = new JLabel("DATE");
        jdate.setBounds(25,550,150,25);
        jdate.setFont(new Font("Open Sans",Font.PLAIN,20));
        jdate.setForeground(Color.WHITE);
        sellContent.add(jdate);

        JLabel price = new JLabel("PRICE");
        price.setBounds(25,600,150,25);
        price.setFont(new Font("Open Sans",Font.PLAIN,20));
        price.setForeground(Color.WHITE);
        sellContent.add(price);


        JComboBox petField = new JComboBox();
        petField.setBounds(220,250,275,30);
        petField.setOpaque(true);
        try{
            Connector con = new Connector();
            ResultSet rs = con.s.executeQuery("SELECT DISTINCT Pet " +
                    "FROM pet p,inventory i " +
                    "WHERE i.TQuantity IS NOT NULL AND i.pID = p.pID");
            while(rs.next()){
                petField.addItem(rs.getString(1));
                petField.setFont(new Font("",Font.PLAIN,20));
                petField.setOpaque(true);
            }
        }catch(Exception ce){
            ce.printStackTrace();
        }
        sellContent.add(petField);



        JLabel name = new JLabel("NAME");
        name.setBounds(25,350,150,25);
        name.setFont(new Font("Open Sans",Font.PLAIN,20));
        name.setForeground(Color.WHITE);
        sellContent.add(name);

        JComboBox nameField = new JComboBox();
        nameField.setBounds(220,350,275,25);
        nameField.setFont(new Font("",Font.PLAIN,20));
        //typeField.setCaretColor(Color.WHITE);
        //nameField.setForeground(Color.WHITE);
        nameField.setBorder(null);
        nameField.setOpaque(false);
        sellContent.add(nameField);

        JLabel  quantity = new JLabel("QUANTITY");
        quantity.setBounds(25,400,200,25);
        quantity.setFont(new Font("Open Sans",Font.PLAIN,20));
        quantity.setForeground(Color.WHITE);
        sellContent.add(quantity);

        JTextField quantityField = new JTextField();
        quantityField.setBounds(220,400,275,25);
        quantityField.setFont(new Font("",Font.PLAIN,20));
        quantityField.setCaretColor(Color.WHITE);
        quantityField.setForeground(Color.WHITE);
        quantityField.setBorder(null);
        quantityField.setOpaque(false);
        sellContent.add(quantityField);

        JLabel  customer = new JLabel("CUSTOMER NAME");
        customer.setBounds(25,450,200,25);
        customer.setFont(new Font("Open Sans",Font.PLAIN,20));
        customer.setForeground(Color.WHITE);
        sellContent.add(customer);

        JTextField customerField = new JTextField();
        customerField.setBounds(220,450,275,25);
        customerField.setFont(new Font("",Font.PLAIN,20));
        customerField.setCaretColor(Color.WHITE);
        customerField.setForeground(Color.WHITE);
        customerField.setBorder(null);
        customerField.setOpaque(false);
        sellContent.add(customerField);

        JLabel cusPhone = new JLabel("CUSTOMER PHNO.");
        cusPhone.setBounds(25,500,200,25);
        cusPhone.setFont(new Font("Open Sans",Font.PLAIN,20));
        cusPhone.setForeground(Color.WHITE);
        sellContent.add(cusPhone);

        JTextField customerPhno = new JTextField();
        customerPhno.setBounds(220,500,275,25);
        customerPhno.setFont(new Font("",Font.PLAIN,20));
        customerPhno.setForeground(Color.WHITE);
        customerPhno.setCaretColor(Color.WHITE);
        customerPhno.setBorder(null);
        customerPhno.setOpaque(false);
        sellContent.add(customerPhno);


        /*DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        java.util.Date date = new Date();
        dateFormat.format(date);*/

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm aa");
        Date date = new Date();

        JTextField dateField = new JTextField(dateFormat.format(date));
        dateField.setBounds(220,550,275,25);
        dateField.setFont(new Font("",Font.PLAIN,20));
        dateField.setForeground(Color.WHITE);
        dateField.setCaretColor(Color.WHITE);
        dateField.setBorder(null);
        dateField.setOpaque(false);
        sellContent.add(dateField);

        JTextField priceField = new JTextField();
        /*try{
            ResultSet rs = con.s.executeQuery("select * from inventory where id = '6'");
            priceField.setText(rs.getString(6));
        }catch (Exception se){
            System.out.println(se);
        }*/
        priceField.setBounds(220,600,275,25);
        priceField.setFont(new Font("",Font.PLAIN,20));
        priceField.setForeground(Color.WHITE);
        priceField.setCaretColor(Color.WHITE);
        priceField.setBorder(null);
        priceField.setOpaque(false);
        sellContent.add(priceField);

        JSeparator s1 = new JSeparator();
        s1.setBounds(215,475,275,5);
        sellContent.add(s1);

        JSeparator s2 = new JSeparator();
        s2.setBounds(215,625,275,5);
        sellContent.add(s2);

        JSeparator s3 = new JSeparator();
        s3.setBounds(215,425,275,5);
        sellContent.add(s3);

        JSeparator s4 = new JSeparator();
        s4.setBounds(215,525,275,5);
        sellContent.add(s4);

        JSeparator s5 = new JSeparator();
        s5.setBounds(215,575,275,5);
        sellContent.add(s5);

//        petField.addActionListener(e -> {
//            try{
//
//                ResultSet rs = con.s.executeQuery("SELECT");
//
//            }catch (Exception ce){
//                ce.printStackTrace();
//            }
//        });
        petField.addActionListener(e -> {
            nameField.removeAllItems();
            priceField.setText("");
            bg.clearSelection();
            petField.setEditable(false);
        });


        breed.addActionListener(e -> {
            try{
                petField.disable();
                accessories.setVisible(false);
                sellContent.remove(accessories);
                ResultSet rs = con.s.executeQuery("SELECT name FROM pet WHERE pet = '"+petField.getSelectedItem()+"' and type = 'breed'");
                nameField.removeAllItems();
                priceField.setText("");

                while(rs.next()){
//                    String a = "";
                    nameField.addItem(rs.getString(1));
                    nameField.setFont(new Font("",Font.PLAIN,20));
                    nameField.setOpaque(true);
//                    System.out.println(a);
                }
                rs = con.s.executeQuery("SELECT unitPrice FROM pet WHERE pet = '"+petField.getSelectedItem()+"' and type = 'breed'");
                if (rs.next()) {
                    value = rs.getString(1);
                    priceField.setText(rs.getString(1) + "/-");
                }
                priceField.setText("0/-");
                revalidate();
                repaint();

            }catch (Exception ce){
                ce.printStackTrace();
            }
        });

        accessories.addActionListener(e -> {
            try{
                petField.disable();
                breed.setVisible(false);
                sellContent.remove(breed);
                ResultSet rs = con.s.executeQuery("SELECT name FROM pet WHERE pet = '"+petField.getSelectedItem()+"' and type = 'accessory'");
                nameField.removeAllItems();
                priceField.setText("");

                while(rs.next()){
//                    String a = "";
                    nameField.addItem(rs.getString(1));
                    nameField.setFont(new Font("",Font.PLAIN,20));
                    nameField.setOpaque(true);
//                    System.out.println(a);
                }
                rs = con.s.executeQuery("SELECT unitPrice FROM pet WHERE pet = '"+petField.getSelectedItem()+"' and type = 'accessory'");
                if (rs.next()) {
                    value = rs.getString(1);
//                    unitPField.setText(rs.getString(1) + "/-");
                }
                priceField.setText("0/-");
                revalidate();
                repaint();

            }catch (Exception ce){
                ce.printStackTrace();
            }
        });



        nameField.addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                nameField.addActionListener(e1 -> {
                    try{
                        quantityField.setText("");
                        priceField.setText("");
                        ResultSet rs = con.s.executeQuery("SELECT unitPrice FROM pet WHERE pet = '"+petField.getSelectedItem()+"' and type = '"
                                +bg.getSelection().getActionCommand()+"' and name = '"+nameField.getSelectedItem()+"'");
                        if (rs.next()){
                            value = rs.getString(1);
//                            unitPField.setText(rs.getString(1)+"/-");
                            priceField.setText("0/-");
                            // System.out.println(rs.getString(1));
                        }
                        rs.close();
                        revalidate();
                        repaint();
                    }catch (Exception ce){
                        ce.printStackTrace();
                    }
                });
            }
        });

        quantityField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                int a = 0;
                if (isNumeric(value) && isNumeric(quantityField.getText()))
                    a = Integer.parseInt(value) * Integer.parseInt(quantityField.getText());
                priceField.setText(""+a+"/-");
                revalidate();
                repaint();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                int a = 0;
                if (isNumeric(value) && isNumeric(quantityField.getText()))
                    a = Integer.parseInt(value) * Integer.parseInt(quantityField.getText());
                priceField.setText(""+a+"/-");
                revalidate();
                repaint();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                int a = 0;
                if (isNumeric(value) && isNumeric(quantityField.getText()))
                    a = Integer.parseInt(value) * Integer.parseInt(quantityField.getText());
                priceField.setText(""+a+"/-");
                revalidate();
                repaint();
            }
        });


        JLabel sell = new JLabel("SELL");
        sell.setForeground(Color.BLACK.darker());
        sell.setFocusable(true);
        //newUser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        sell.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try{
                    //Connector con = new Connector();
                    con.s.executeUpdate("call sell('"+dateField.getText()+"','"+nameField.getSelectedItem()+"','"+quantityField.getText()+"','"+value+"','"+lID+"','"+customerField.getText()+"')");
                    JOptionPane.showMessageDialog(null,"added to inventory");
                    //petField.setText("");
                    petField.requestFocus();
                    //typeField.setText("");
                    customerField.setText("");
                    //dateField.setText("");
//                    priceField.setText("");

                }catch (Exception se){
                    System.out.println(se);
                    JOptionPane.showMessageDialog(null,se);
                }


                // revalidate();
                //repaint();
                viewTable();
//                new Billing();
            }

            @Override
            public void mouseEntered(MouseEvent e){
                sell.setForeground(new Color(0x1C97A3));
            }

            @Override
            public void mouseExited(MouseEvent e){
                sell.setForeground(Color.BLACK.darker());
            }
        });
        sell.setBounds(220,650,55,25);
        sell.setFont(new Font("",Font.PLAIN,20));
        sellContent.add(sell);

        viewTable();
        revalidate();
        repaint();
        return sellContent;
    }

    private void viewTable() {
        JTable table = new JTable();
        try{
            ResultSet rs = con.s.executeQuery("SELECT pet,type,name,TQuantity,unitPrice" +
                    " FROM INVENTORY i , PET p " +
                    "WHERE p.pID = i.pID");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            //SQL command  ---> ALTER TABLE tablename AUTO_INCREMENT = 1
            JScrollPane pane = new JScrollPane(table);
            table.setFont(new Font("",Font.PLAIN,20));
            table.getTableHeader().setFont(new Font(null,Font.PLAIN,18));
            table.setRowHeight(30);
            pane.setBounds(600,200,800,600);
            sellContent.add(pane);
        }catch(Exception se){
            se.printStackTrace();
        }
        revalidate();
        repaint();
    }
    
    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}
