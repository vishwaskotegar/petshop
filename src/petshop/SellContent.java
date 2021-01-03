package petshop;

import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.text.*;
import java.util.Date;

public class SellContent extends JFrame {
    Connector con = new Connector();
    JPanel sellContent = new JPanel();


    public JPanel sellContent(String empName){

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

        JLabel emp = new JLabel("EMPLOYEE NAME - "+empName,SwingConstants.RIGHT);
        emp.setBounds(1150,80,400,25);
        emp.setFont(new Font("Open Sans",Font.PLAIN,20));
        emp.setForeground(Color.WHITE);
        sellContent.add(emp);

        JLabel cusPhone = new JLabel("CUSTOMER PHNO.");
        cusPhone.setBounds(25,200,200,25);
        cusPhone.setFont(new Font("Open Sans",Font.PLAIN,20));
        cusPhone.setForeground(Color.WHITE);
        sellContent.add(cusPhone);

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

        JLabel  customer = new JLabel("CUSTOMER NAME");
        customer.setBounds(25,350,200,25);
        customer.setFont(new Font("Open Sans",Font.PLAIN,20));
        customer.setForeground(Color.WHITE);
        sellContent.add(customer);


        JLabel jdate = new JLabel("DATE");
        jdate.setBounds(25,400,150,25);
        jdate.setFont(new Font("Open Sans",Font.PLAIN,20));
        jdate.setForeground(Color.WHITE);
        sellContent.add(jdate);

        JLabel price = new JLabel("PRICE");
        price.setBounds(25,450,150,25);
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


        JTextField customerPhno = new JTextField();
        customerPhno.setBounds(220,200,275,25);
        customerPhno.setFont(new Font("",Font.PLAIN,20));
        customerPhno.setForeground(Color.WHITE);
        customerPhno.setCaretColor(Color.WHITE);
        customerPhno.setBorder(null);
        customerPhno.setOpaque(false);
        sellContent.add(customerPhno);

        JComboBox typeField = new JComboBox();
        typeField.setBounds(220,300,275,25);
        typeField.setFont(new Font("",Font.PLAIN,20));
        //typeField.setCaretColor(Color.WHITE);
        typeField.setForeground(Color.WHITE);
        typeField.setBorder(null);
        typeField.setOpaque(false);
        sellContent.add(typeField);

        JTextField customerField = new JTextField();
        customerField.setBounds(220,350,275,25);
        customerField.setFont(new Font("",Font.PLAIN,20));
        customerField.setCaretColor(Color.WHITE);
        customerField.setForeground(Color.WHITE);
        customerField.setBorder(null);
        customerField.setOpaque(false);
        sellContent.add(customerField);

        /*DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        java.util.Date date = new Date();
        dateFormat.format(date);*/

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date date = new Date();

        JTextField dateField = new JTextField(dateFormat.format(date));
        dateField.setBounds(220,400,275,25);
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
        priceField.setBounds(220,450,275,25);
        priceField.setFont(new Font("",Font.PLAIN,20));
        priceField.setForeground(Color.WHITE);
        priceField.setCaretColor(Color.WHITE);
        priceField.setBorder(null);
        priceField.setOpaque(false);
        sellContent.add(priceField);

        JSeparator s1 = new JSeparator();
        s1.setBounds(215,225,275,5);
        sellContent.add(s1);

        /*JSeparator s2 = new JSeparator();
        s2.setBounds(215,325,275,5);
        sellContent.add(s2);*/

        JSeparator s3 = new JSeparator();
        s3.setBounds(215,375,275,5);
        sellContent.add(s3);

        JSeparator s4 = new JSeparator();
        s4.setBounds(215,425,275,5);
        sellContent.add(s4);

        JSeparator s5 = new JSeparator();
        s5.setBounds(215,475,275,5);
        sellContent.add(s5);


        JLabel sell = new JLabel("SELL");
        sell.setForeground(Color.BLACK.darker());
        sell.setFocusable(true);
        //newUser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        sell.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                /*try{
                    //Connector con = new Connector();
                    con.s.executeUpdate("INSERT INTO inventory(pet,typeOrBreed,supplier,date,price,soldOrBought) " +
                            "VALUES ('"+petField.getSelectedItem()+"','"+typeField.getSelectedItem()+"','"+customerField.getText()+"'," +
                            "'"+dateField.getText()+"','"+priceField.getText() +"','bought')");
                    //JOptionPane.showMessageDialog(null,"added to inventory");
                    //petField.setText("");
                    petField.requestFocus();
                    //typeField.setText("");
                    customerField.setText("");
                    //dateField.setText("");
                    priceField.setText("");

                }catch (Exception se){
                    System.out.println(se);
                    JOptionPane.showMessageDialog(null,se);
                }*/


                // revalidate();
                //repaint();
                viewTable();
                new Billing();
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
        sell.setBounds(220,500,55,25);
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

            ResultSet rs = con.s.executeQuery("SELECT * FROM INVENTORY;");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            table.setFont(new Font("",Font.PLAIN,20));
            table.getTableHeader().setFont(new Font(null,Font.PLAIN,18));
            table.setRowHeight(30);
            //SQL command  ---> ALTER TABLE tablename AUTO_INCREMENT = 1
            JScrollPane pane = new JScrollPane(table);
            pane.setBounds(600,200,800,600);
            sellContent.add(pane);
        }catch(Exception se){
            System.out.println(se);
        }
        revalidate();
        repaint();
    }
}
