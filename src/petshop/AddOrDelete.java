package petshop;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

public class AddOrDelete extends JFrame {
    Connector con = new Connector();
    JPanel manageContent = new JPanel();

    public JPanel addOrDelete(String empName){
        manageContent.setBounds(300,0,1700,1047);
        manageContent.setLayout(null);
        manageContent.setBackground(Color.DARK_GRAY);


//        JPanel panel = new MotionPanel(this);
//        panel.setBounds(0, 0, 1200, 50);
//        panel.setOpaque(false);
//        panel.setLayout(null);
//        manageContent.add(panel);
//
//        ImageIcon cancel = new ImageIcon("resources\\cancel.png");
//        JButton jcancel = new JButton();
//        jcancel.setBounds(1150,0,50,50);
//        jcancel.setIcon(cancel);
//        jcancel.setOpaque(false);
//        jcancel.setContentAreaFilled(false);
//        jcancel.setBorderPainted(false);
//        jcancel.setFocusable(false);
//        jcancel.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent c) {
//
//            }
//
//            @Override
//            public void mouseEntered(MouseEvent c) {
//                ImageIcon cancel1 = new ImageIcon("resources\\cancel1.png");
//                jcancel.setIcon(cancel1);
//
//            }
//
//            @Override
//            public void mouseExited(MouseEvent c) {
//                jcancel.setIcon(cancel);
//            }
//        });
//        panel.add(jcancel);
//
//        jcancel.addActionListener(e -> dispose());


//        JButton b = new JButton("b");
//        b.setBounds(0,0,25,25);
//        add(b);

//        b.addActionListener(e -> {
//            Dimension x = getSize();
//            System.out.println(x);
//        });

        JLabel addRemove = new JLabel("Manage PET");
        addRemove.setBounds(45,50,550,60);
        addRemove.setFont(new Font("Open Sans",Font.PLAIN,50));
        addRemove.setForeground(Color.white);
        manageContent.add(addRemove);

        JLabel addHere = new JLabel("ADD NEW PET");
        addHere.setBounds(50, 150,200,25);
        addHere.setFont(new Font("Open Sans",Font.PLAIN,20));
        addHere.setForeground(Color.WHITE);
        manageContent.add(addHere);

        JLabel  pet = new JLabel("PET");
        pet.setBounds(25, 200,150,25);
        pet.setFont(new Font("Open Sans",Font.PLAIN,20));
        pet.setForeground(Color.WHITE);
        manageContent.add(pet);

        JTextField petfield = new JTextField();
        petfield.setBounds(170, 200,275,25);
        petfield.setFont(new Font("",Font.PLAIN,20));
        petfield.setCaretColor(Color.WHITE);
        petfield.setForeground(Color.WHITE);
        petfield.setBorder(null);
        petfield.setOpaque(false);
        manageContent.add(petfield);

        JSeparator s1 = new JSeparator();
        s1.setBounds(165,225,275,5);
        manageContent.add(s1);

        JLabel  type = new JLabel("TYPE");
        type.setBounds(25, 250,150,25);
        type.setFont(new Font("Open Sans",Font.PLAIN,20));
        type.setForeground(Color.WHITE);
        manageContent.add(type);

        JRadioButton breed = new JRadioButton("BREED");
        breed.setBounds(170,250,100,25);
        breed.setFont(new Font("Open Sans",Font.PLAIN,20));
        breed.setOpaque(false);
        breed.setFocusable(false);
        breed.setForeground(Color.WHITE);
        manageContent.add(breed);

        JRadioButton accessory = new JRadioButton("ACCESSORY");
        accessory.setBounds(300,250,150,25);
        accessory.setFont(new Font("Open Sans",Font.PLAIN,20));
        accessory.setOpaque(false);
        breed.setFocusable(false);
        accessory.setForeground(Color.WHITE);
        manageContent.add(accessory);

        ButtonGroup bg = new ButtonGroup();
        bg.add(breed);bg.add(accessory);


        JLabel  name = new JLabel("NAME");
        name.setBounds(25, 300,150,25);
        name.setFont(new Font("Open Sans",Font.PLAIN,20));
        name.setForeground(Color.WHITE);
        manageContent.add(name);

        JTextField namefield = new JTextField();
        namefield.setBounds(170, 300,275,25);
        namefield.setFont(new Font("",Font.PLAIN,20));
        namefield.setCaretColor(Color.WHITE);
        namefield.setForeground(Color.WHITE);
        namefield.setBorder(null);
        namefield.setOpaque(false);
        manageContent.add(namefield);

        JSeparator s2 = new JSeparator();
        s2.setBounds(165,325,275,5);
        manageContent.add(s2);

        JLabel  unitPrice = new JLabel("UNIT PRICE");
        unitPrice.setBounds(25, 350,150,25);
        unitPrice.setFont(new Font("Open Sans",Font.PLAIN,20));
        unitPrice.setForeground(Color.WHITE);
        manageContent.add(unitPrice);

        JTextField pricefield = new JTextField();
        pricefield.setBounds(170, 350,275,25);
        pricefield.setFont(new Font("",Font.PLAIN,20));
        pricefield.setCaretColor(Color.WHITE);
        pricefield.setForeground(Color.WHITE);
        pricefield.setBorder(null);
        pricefield.setOpaque(false);
        manageContent.add(pricefield);

        JSeparator s3 = new JSeparator();
        s3.setBounds(165,375,275,5);
        manageContent.add(s3);

        JLabel add = new JLabel("ADD");
        add.setForeground(Color.BLACK.darker());
        add.setFocusable(true);
        //newUser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String type;
                System.out.println(pricefield.getText());
                if (isNumeric(pricefield.getText())){
                    if (breed.isSelected())
                        type = "breed";
                    else
                        type = "accessory";

                    try{
                        con.s.executeUpdate("INSERT INTO pet VALUES(DEFAULT,'"+petfield.getText()+"','"+namefield.getText()+"'," +
                                "'"+type+"','"+pricefield.getText()+"')");
                        viewTable("SELECT * from pet");
                    }catch (Exception ce){
                        ce.printStackTrace();
                    }
                }
                else
                    JOptionPane.showMessageDialog(null,"Enter valid price");
            }

            @Override
            public void mouseEntered(MouseEvent e){
                add.setForeground(new Color(0x1C97A3));
            }

            @Override
            public void mouseExited(MouseEvent e){
                add.setForeground(Color.BLACK.darker());
            }
        });
        add.setBounds(250,400,45,25);
        add.setFont(new Font("",Font.PLAIN,20));
        manageContent.add(add);



//        JSeparator s4 = new JSeparator();
//        s4.setBounds(0,450,500,10);
//        manageContent.add(s4);

        JLabel  removeHere = new JLabel("REMOVE PET");
        removeHere.setBounds(50, 500,150,25);
        removeHere.setFont(new Font("Open Sans",Font.PLAIN,20));
        removeHere.setForeground(Color.WHITE);
        manageContent.add(removeHere);

        JLabel  pID = new JLabel("PET ID");
        pID.setBounds(25, 550,150,25);
        pID.setFont(new Font("Open Sans",Font.PLAIN,20));
        pID.setForeground(Color.WHITE);
        manageContent.add(pID);

        JTextField pIDfield = new JTextField();
        pIDfield.setBounds(170, 550,275,25);
        pIDfield.setFont(new Font("",Font.PLAIN,20));
        pIDfield.setCaretColor(Color.WHITE);
        pIDfield.setForeground(Color.WHITE);
        pIDfield.setBorder(null);
        pIDfield.setOpaque(false);
        manageContent.add(pIDfield);

        JSeparator s5 = new JSeparator();
        s5.setBounds(165,575,275,5);
        manageContent.add(s5);

        JLabel remove = new JLabel("REMOVE");
        remove.setForeground(Color.BLACK.darker());
        remove.setFocusable(true);
        //newUser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        remove.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int a = JOptionPane.showConfirmDialog(null,"Are you sure you want to remove this item?\n" +
                        "Removing this item will result in loss of data in your 'TRANSACTIONS' too","confirm",JOptionPane.YES_NO_OPTION);
                if (a == 0) {
                    try {
                        con.s.executeUpdate("DELETE FROM pet WHERE pID = " + pIDfield.getText() + ";");
                        viewTable("SELECT * FROM pet");
                    } catch (Exception ce) {
                        ce.printStackTrace();
                    }
                }
            }

            @Override
            public void mouseEntered(MouseEvent e){
                remove.setForeground(new Color(0x1C97A3));
            }

            @Override
            public void mouseExited(MouseEvent e){
                remove.setForeground(Color.BLACK.darker());
            }
        });
        remove.setBounds(250,600,90,25);
        remove.setFont(new Font("",Font.PLAIN,20));
        manageContent.add(remove);

//        JTable table = new JTable();
//        table.setBounds(500,200,600,400);
//        manageContent.add(table);

        viewTable("SELECT * from pet");


        return manageContent;
    }

    private void viewTable(String sql) {
        JTable table = new JTable();
        try{
            ResultSet rs = con.s.executeQuery(sql);
            table.setModel(DbUtils.resultSetToTableModel(rs));
            //SQL command  ---> ALTER TABLE tablename AUTO_INCREMENT = 1
            JScrollPane pane = new JScrollPane(table);
            table.setFont(new Font("",Font.PLAIN,20));
            table.getTableHeader().setFont(new Font(null,Font.PLAIN,18));
            table.setRowHeight(30);
            pane.setBounds(600,200,800,600);
            manageContent.add(pane);
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

    public static void main(String[] args) {
        new AddOrDelete();
    }
}
