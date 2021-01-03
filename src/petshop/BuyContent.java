package petshop;

import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.text.*;
import java.util.Date;

public class BuyContent extends JFrame {
    Connector con = new Connector();
    JPanel buyContent = new JPanel();


    public JPanel buyContent(String empName){

        buyContent.setBackground(Color.DARK_GRAY);

        //table.setBackground(Color.DARK_GRAY);
        //table.setForeground(Color.WHITE);

        JLabel buying = new JLabel("BUYING");
        buying.setBounds(45,50,550,40);
        buying.setFont(new Font("Open Sans",Font.PLAIN,50));
        buying.setForeground(Color.WHITE);
        buyContent.add(buying);

        buyContent.setBounds(300,0,1700,1047);
        buyContent.setLayout(null);

        JLabel emp = new JLabel("EMPLOYEE NAME - "+empName,SwingConstants.RIGHT);
        emp.setBounds(1150,80,400,25);
        emp.setFont(new Font("Open Sans",Font.PLAIN,20));
        emp.setForeground(Color.WHITE);
        buyContent.add(emp);

        JLabel addOrDelete = new JLabel("ADD TO INVENTORY");
        addOrDelete.setForeground(Color.BLACK.darker());
        addOrDelete.setFocusable(true);
        //newUser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addOrDelete.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new AddOrDelete();
            }

            @Override
            public void mouseEntered(MouseEvent e){
                addOrDelete.setForeground(new Color(0x1C97A3));
            }

            @Override
            public void mouseExited(MouseEvent e){
                addOrDelete.setForeground(Color.BLACK.darker());
            }
        });
        addOrDelete.setBounds(220,600,200,25);
        addOrDelete.setFont(new Font("",Font.PLAIN,20));
        buyContent.add(addOrDelete);

        JLabel pet = new JLabel("PET");
        pet.setBounds(25,300,150,25);
        pet.setFont(new Font("Open Sans",Font.PLAIN,20));
        pet.setForeground(Color.WHITE);
        buyContent.add(pet);

        JLabel type = new JLabel("TYPE");
        type.setBounds(25,350,150,25);
        type.setFont(new Font("Open Sans",Font.PLAIN,20));
        type.setForeground(Color.WHITE);
        buyContent.add(type);

        JRadioButton breed = new JRadioButton("BREED");
        breed.setBounds(170,350,150,25);
        breed.setFont(new Font("Open Sans",Font.PLAIN,20));
        breed.setOpaque(false);
//        breed.setFocusable(false);
        breed.setForeground(Color.WHITE);
        buyContent.add(breed);

        JRadioButton accessories = new JRadioButton("ACCESSORY");
        accessories.setBounds(300,350,150,25);
        accessories.setFont(new Font("Open Sans",Font.PLAIN,20));
        accessories.setOpaque(false);
//        breed.setFocusable(false);
        accessories.setForeground(Color.WHITE);
        buyContent.add(accessories);

        ButtonGroup bg = new ButtonGroup();
        bg.add(breed);bg.add(accessories);

        JLabel  supplier = new JLabel("SUPPLIER");
        supplier.setBounds(25, 250,150,25);
        supplier.setFont(new Font("Open Sans",Font.PLAIN,20));
        supplier.setForeground(Color.WHITE);
        buyContent.add(supplier);

        JSeparator s1 = new JSeparator();
        s1.setBounds(165,275,275,5);
        buyContent.add(s1);

        JComboBox petField = new JComboBox();
        petField.setBounds(165,300,275,25);
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
        buyContent.add(petField);

        JTextField supplierField = new JTextField();
        supplierField.setBounds(170, 250,275,25);
        supplierField.setFont(new Font("",Font.PLAIN,20));
        supplierField.setCaretColor(Color.WHITE);
        supplierField.setForeground(Color.WHITE);
        supplierField.setBorder(null);
        supplierField.setOpaque(false);
        buyContent.add(supplierField);

        JLabel name = new JLabel("NAME");
        name.setBounds(25,400,100,25);
        name.setFont(new Font("Open Sans",Font.PLAIN,20));
        name.setForeground(Color.WHITE);
        buyContent.add(name);

        JComboBox nameField = new JComboBox();
        nameField.setBounds(165,400,275,25);
        nameField.setOpaque(true);
        try{
            Connector con = new Connector();
            ResultSet rs = con.s.executeQuery("SELECT DISTINCT p.Pet " +
                    "FROM pet p,inventory i " +
                    "WHERE (i.TQuantity != 0) AND (i.pID = p.pID)");
            while(rs.next()){
                nameField.addItem(rs.getString(1));
                nameField.setFont(new Font("",Font.PLAIN,20));
                nameField.setOpaque(true);
            }
        }catch(Exception ce){
            ce.printStackTrace();
        }
        buyContent.add(nameField);

        JLabel quantity = new JLabel("QUANTITY");
        quantity.setBounds(25,450,150,25);
        quantity.setFont(new Font("Open Sans",Font.PLAIN,20));
        quantity.setForeground(Color.WHITE);
        buyContent.add(quantity);

        JTextField quantityField = new JTextField();
        quantityField.setBounds(170,450,275,25);
        quantityField.setFont(new Font("",Font.PLAIN,20));
        quantityField.setForeground(Color.WHITE);
        quantityField.setCaretColor(Color.WHITE);
        quantityField.setBorder(null);
        quantityField.setOpaque(false);
        buyContent.add(quantityField);

        JSeparator s5 = new JSeparator();
        s5.setBounds(165,475,275,5);
        buyContent.add(s5);

        JLabel unitPrice = new JLabel("UNIT PRICE");
        unitPrice.setBounds(25,500,150,25);
        unitPrice.setFont(new Font("Open Sans",Font.PLAIN,20));
        unitPrice.setForeground(Color.WHITE);
        buyContent.add(unitPrice);

        JTextField unitPField = new JTextField(null,SwingConstants.RIGHT);
        unitPField.setBounds(170,500,275,25);
        unitPField.setFont(new Font("",Font.PLAIN,20));
        unitPField.setForeground(Color.WHITE);
        unitPField.setCaretColor(Color.WHITE);
        unitPField.setBorder(null);
        unitPField.setOpaque(false);
        buyContent.add(unitPField);

//
        /*DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        java.util.Date date = new Date();
        dateFormat.format(date);*/

        JLabel jdate = new JLabel("DATE");
        jdate.setBounds(25,550,150,25);
        jdate.setFont(new Font("Open Sans",Font.PLAIN,20));
        jdate.setForeground(Color.WHITE);
        buyContent.add(jdate);

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm aa");
        java.util.Date date = new Date();

        JTextField dateField = new JTextField(dateFormat.format(date));
        dateField.setBounds(170,550,275,25);
        dateField.setFont(new Font("",Font.PLAIN,20));
        dateField.setForeground(Color.WHITE);
        dateField.setCaretColor(Color.WHITE);
        dateField.setBorder(null);
        dateField.setOpaque(false);
        buyContent.add(dateField);

//
        JLabel submit = new JLabel("ADD TO INVENTORY");
        submit.setForeground(Color.BLACK.darker());
        submit.setFocusable(true);
        //newUser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        submit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try{
                    //Connector con = new Connector();
                    con.s.executeUpdate("INSERT INTO transaction " +
                            "VALUES()");
                    //JOptionPane.showMessageDialog(null,"added to inventory");
                    supplierField.setText("");
                    supplierField.requestFocus();
                    quantityField.setText("");
                    unitPField.setText("");
                    //totalPricefield.setText("");
                    dateField.setText("");

                }catch (Exception se){
                    se.printStackTrace();
                    JOptionPane.showMessageDialog(null,se);
                }


                revalidate();
                repaint();
                viewTable();
            }

            @Override
            public void mouseEntered(MouseEvent e){
                submit.setForeground(new Color(0x1C97A3));
            }

            @Override
            public void mouseExited(MouseEvent e){
                submit.setForeground(Color.BLACK.darker());
            }
        });
        submit.setBounds(220,600,200,25);
        submit.setFont(new Font("",Font.PLAIN,20));
        buyContent.add(submit);

        viewTable();
        revalidate();
        repaint();
        return buyContent;
    }

    private void viewTable() {
        JTable table = new JTable();
        try{
            ResultSet rs = con.s.executeQuery("SELECT pet,name,breedOrAccessory,TQuantity,unitPrice" +
                    " FROM INVENTORY i , PET p " +
                    "WHERE p.pID = i.pID");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            //SQL command  ---> ALTER TABLE tablename AUTO_INCREMENT = 1
            JScrollPane pane = new JScrollPane(table);
            table.setFont(new Font("",Font.PLAIN,20));
            table.getTableHeader().setFont(new Font(null,Font.PLAIN,18));
            table.setRowHeight(30);
            pane.setBounds(600,200,800,600);
            buyContent.add(pane);
        }catch(Exception se){
            se.printStackTrace();
        }
        revalidate();
        repaint();
    }
}
