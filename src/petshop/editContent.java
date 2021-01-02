package petshop;

import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.text.*;
import java.util.Date;

public class editContent extends JFrame {
    Connector con = new Connector();
    JPanel userContent = new JPanel();


    public JPanel editContent(){

        userContent.setBackground(Color.DARK_GRAY);

        //table.setBackground(Color.DARK_GRAY);
        //table.setForeground(Color.WHITE);

        userContent.setBounds(300,0,1700,1047);
        userContent.setLayout(null);

        JLabel profile = new JLabel("EDIT PROFILE");
        profile.setBounds(45,50,550,40);
        profile.setFont(new Font("Open Sans",Font.PLAIN,50));
        profile.setForeground(Color.WHITE);
        userContent.add(profile);

        JLabel fisrtName = new JLabel("FIRST NAME");
        fisrtName.setBounds(25,250,150,25);
        fisrtName.setFont(new Font("Open Sans",Font.PLAIN,20));
        fisrtName.setForeground(Color.WHITE);
        userContent.add(fisrtName);

        JLabel lastName = new JLabel("LAST NAME");
        lastName.setBounds(25,300,150,25);
        lastName.setFont(new Font("Open Sans",Font.PLAIN,20));
        lastName.setForeground(Color.WHITE);
        userContent.add(lastName);

        JLabel  email = new JLabel("EMAIL");
        email.setBounds(25,350,150,25);
        email.setFont(new Font("Open Sans",Font.PLAIN,20));
        email.setForeground(Color.WHITE);
        userContent.add(email);


        JLabel phoneNo = new JLabel("PHONE NO.");
        phoneNo.setBounds(25,400,150,25);
        phoneNo.setFont(new Font("Open Sans",Font.PLAIN,20));
        phoneNo.setForeground(Color.WHITE);
        userContent.add(phoneNo);

        JLabel username = new JLabel("USERNAME");
        username.setBounds(25,450,150,25);
        username.setFont(new Font("Open Sans",Font.PLAIN,20));
        username.setForeground(Color.WHITE);
        userContent.add(username);

        JLabel password = new JLabel("PASSWORD");
        password.setBounds(25,500,150,25);
        password.setFont(new Font("Open Sans",Font.PLAIN,20));
        password.setForeground(Color.WHITE);
        userContent.add(password);



        JTextField firstNameField = new JTextField();
        firstNameField.setBounds(170,250,275,25);
        firstNameField.setFont(new Font("",Font.PLAIN,20));
        firstNameField.setForeground(Color.WHITE);
        firstNameField.setCaretColor(Color.WHITE);
        firstNameField.setBorder(null);
        firstNameField.setOpaque(false);
        userContent.add(firstNameField);



        JTextField lastNameField = new JTextField();
        lastNameField.setBounds(170,300,275,25);
        lastNameField.setFont(new Font("",Font.PLAIN,20));
        lastNameField.setCaretColor(Color.WHITE);
        lastNameField.setForeground(Color.WHITE);
        lastNameField.setBorder(null);
        lastNameField.setOpaque(false);
        userContent.add(lastNameField);

        JTextField emailField = new JTextField();
        emailField.setBounds(170,350,275,25);
        emailField.setFont(new Font("",Font.PLAIN,20));
        emailField.setCaretColor(Color.WHITE);
        emailField.setForeground(Color.WHITE);
        emailField.setBorder(null);
        emailField.setOpaque(false);
        userContent.add(emailField);



        JTextField phoneField = new JTextField();
        phoneField.setBounds(170,400,275,25);
        phoneField.setFont(new Font("",Font.PLAIN,20));
        phoneField.setForeground(Color.WHITE);
        phoneField.setCaretColor(Color.WHITE);
        phoneField.setBorder(null);
        phoneField.setOpaque(false);
        userContent.add(phoneField);

        JTextField userField = new JTextField();
        userField.setBounds(170,450,275,25);
        userField.setFont(new Font("",Font.PLAIN,20));
        userField.setForeground(Color.WHITE);
        userField.setCaretColor(Color.WHITE);
        userField.setBorder(null);
        userField.setOpaque(false);
        userContent.add(userField);

        JTextField passwordField = new JTextField();
        passwordField.setBounds(170,500,275,25);
        passwordField.setFont(new Font("",Font.PLAIN,20));
        passwordField.setForeground(Color.WHITE);
        passwordField.setCaretColor(Color.WHITE);
        passwordField.setBorder(null);
        passwordField.setOpaque(false);
        userContent.add(passwordField);

        JSeparator s1 = new JSeparator();
        s1.setBounds(165,275,275,5);
        userContent.add(s1);

        JSeparator s2 = new JSeparator();
        s2.setBounds(165,325,275,5);
        userContent.add(s2);

        JSeparator s3 = new JSeparator();
        s3.setBounds(165,375,275,5);
        userContent.add(s3);

        JSeparator s4 = new JSeparator();
        s4.setBounds(165,425,275,5);
        userContent.add(s4);

        JSeparator s5 = new JSeparator();
        s5.setBounds(165,475,275,5);
        userContent.add(s5);

        JSeparator s6 = new JSeparator();
        s6.setBounds(165,525,275,5);
        userContent.add(s6);


        JLabel update = new JLabel("UPDATE");
        update.setForeground(Color.BLACK.darker());
        update.setFocusable(true);
        //newUser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        update.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try{
                    //Connector con = new Connector();
                    con.s.executeUpdate("INSERT INTO transaction " +
                            "VALUES (DEFAULT,'"+phoneField.getText()+"','"+emailField.getText()+"'," +
                            "'"+phoneField.getText()+"','"+userField.getText() +"','bought')");
                    //JOptionPane.showMessageDialog(null,"added to inventory");
                    //petField.setText("");
                    firstNameField.requestFocus();
                    lastNameField.setText("");
                    emailField.setText("");
                    //dateField.setText("");
                    userField.setText("");

                }catch (Exception se){
                    System.out.println(se);
                    JOptionPane.showMessageDialog(null,se);
                }


                // revalidate();
                //repaint();
            }

            @Override
            public void mouseEntered(MouseEvent e){
                update.setForeground(new Color(0x1C97A3));
            }

            @Override
            public void mouseExited(MouseEvent e){
                update.setForeground(Color.BLACK.darker());
            }
        });
        update.setBounds(220,550,200,25);
        update.setFont(new Font("",Font.PLAIN,20));
        userContent.add(update);

        revalidate();
        repaint();
        return userContent;
    }

}
