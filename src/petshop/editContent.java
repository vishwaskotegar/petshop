package petshop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class EditContent extends JFrame {
    Connector con = new Connector();
    JPanel editContent = new JPanel();


    public JPanel editContent(String lID){

        editContent.setBackground(Color.DARK_GRAY);

        //table.setBackground(Color.DARK_GRAY);
        //table.setForeground(Color.WHITE);

        editContent.setBounds(300,0,1700,1047);
        editContent.setLayout(null);

        JLabel profile = new JLabel("EDIT PROFILE");
        profile.setBounds(45,50,550,40);
        profile.setFont(new Font("Open Sans",Font.PLAIN,50));
        profile.setForeground(Color.WHITE);
        editContent.add(profile);

        JLabel fisrtName = new JLabel("FIRST NAME");
        fisrtName.setBounds(25,250,150,25);
        fisrtName.setFont(new Font("Open Sans",Font.PLAIN,20));
        fisrtName.setForeground(Color.WHITE);
        editContent.add(fisrtName);

        JLabel lastName = new JLabel("LAST NAME");
        lastName.setBounds(25,300,150,25);
        lastName.setFont(new Font("Open Sans",Font.PLAIN,20));
        lastName.setForeground(Color.WHITE);
        editContent.add(lastName);

        JLabel  email = new JLabel("EMAIL");
        email.setBounds(25,350,150,25);
        email.setFont(new Font("Open Sans",Font.PLAIN,20));
        email.setForeground(Color.WHITE);
        editContent.add(email);


        JLabel phoneNo = new JLabel("PHONE NO.");
        phoneNo.setBounds(25,400,150,25);
        phoneNo.setFont(new Font("Open Sans",Font.PLAIN,20));
        phoneNo.setForeground(Color.WHITE);
        editContent.add(phoneNo);

        JLabel username = new JLabel("USERNAME");
        username.setBounds(25,450,150,25);
        username.setFont(new Font("Open Sans",Font.PLAIN,20));
        username.setForeground(Color.WHITE);
        editContent.add(username);

        JLabel password = new JLabel("PASSWORD");
        password.setBounds(25,500,150,25);
        password.setFont(new Font("Open Sans",Font.PLAIN,20));
        password.setForeground(Color.WHITE);
        editContent.add(password);



        JTextField firstNameField = new JTextField();
        firstNameField.setBounds(170,250,275,25);
        firstNameField.setFont(new Font("",Font.PLAIN,20));
        firstNameField.setForeground(Color.WHITE);
        firstNameField.setCaretColor(Color.WHITE);
        firstNameField.setBorder(null);
        firstNameField.setOpaque(false);
        editContent.add(firstNameField);



        JTextField lastNameField = new JTextField();
        lastNameField.setBounds(170,300,275,25);
        lastNameField.setFont(new Font("",Font.PLAIN,20));
        lastNameField.setCaretColor(Color.WHITE);
        lastNameField.setForeground(Color.WHITE);
        lastNameField.setBorder(null);
        lastNameField.setOpaque(false);
        editContent.add(lastNameField);

        JTextField emailField = new JTextField();
        emailField.setBounds(170,350,275,25);
        emailField.setFont(new Font("",Font.PLAIN,20));
        emailField.setCaretColor(Color.WHITE);
        emailField.setForeground(Color.WHITE);
        emailField.setBorder(null);
        emailField.setOpaque(false);
        editContent.add(emailField);



        JTextField phoneField = new JTextField();
        phoneField.setBounds(170,400,275,25);
        phoneField.setFont(new Font("",Font.PLAIN,20));
        phoneField.setForeground(Color.WHITE);
        phoneField.setCaretColor(Color.WHITE);
        phoneField.setBorder(null);
        phoneField.setOpaque(false);
        editContent.add(phoneField);

        JTextField userField = new JTextField();
        userField.setBounds(170,450,275,25);
        userField.setFont(new Font("",Font.PLAIN,20));
        userField.setForeground(Color.WHITE);
        userField.setCaretColor(Color.WHITE);
        userField.setBorder(null);
        userField.setOpaque(false);
        editContent.add(userField);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(170,500,275,25);
        passwordField.setFont(new Font("",Font.PLAIN,20));
        passwordField.setForeground(Color.WHITE);
        passwordField.setCaretColor(Color.WHITE);
        passwordField.setBorder(null);
        passwordField.setOpaque(false);
        editContent.add(passwordField);

        JSeparator s1 = new JSeparator();
        s1.setBounds(165,275,275,5);
        editContent.add(s1);

        JSeparator s2 = new JSeparator();
        s2.setBounds(165,325,275,5);
        editContent.add(s2);

        JSeparator s3 = new JSeparator();
        s3.setBounds(165,375,275,5);
        editContent.add(s3);

        JSeparator s4 = new JSeparator();
        s4.setBounds(165,425,275,5);
        editContent.add(s4);

        JSeparator s5 = new JSeparator();
        s5.setBounds(165,475,275,5);
        editContent.add(s5);

        JSeparator s6 = new JSeparator();
        s6.setBounds(165,525,275,5);
        editContent.add(s6);

        try{
            Connector con = new Connector();
            ResultSet rs = con.s.executeQuery("SELECT fName,lName,email,phno,l.username,l.password " +
                    "FROM emp e, login l " +
                    "WHERE l.lID = '"+lID+"' and e.lID = '"+lID+"'");
            if (rs.next()){
                firstNameField.setText(rs.getString(1));
                lastNameField.setText(rs.getString(2));
                emailField.setText(rs.getString(3));
                phoneField.setText(rs.getString(4));
                userField.setText(rs.getString(5));
                passwordField.setText(rs.getString(6));
            }
        }catch(Exception ce){
            ce.printStackTrace();
        };

        JCheckBox hide = new JCheckBox("hide",true);
        hide.setForeground(Color.white);
        hide.setBounds(440,500,100,25);
        hide.setFont(new Font("",Font.PLAIN,20));
        hide.setFocusable(false);
        hide.setContentAreaFilled(false);
        char default1 = passwordField.getEchoChar();
        hide.addActionListener(e -> {
            if(hide.isSelected())
                passwordField.setEchoChar(default1);
            else
                passwordField.setEchoChar((char)0);
        });
        hide.setOpaque(false);
        editContent.add(hide);


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
        update.setBounds(220,550,80,25);
        update.setFont(new Font("",Font.PLAIN,20));
        editContent.add(update);

        JLabel delete = new JLabel("DELETE ACCOUNT");
        delete.setForeground(Color.BLACK.darker());
        delete.setFocusable(true);
        //newUser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        delete.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int choice = JOptionPane.showConfirmDialog(editContent,"Are you sure you want to delete your account?","CONFIRM DELETE",JOptionPane.YES_NO_OPTION);
                if (choice == 0){
                    try{
                        con.s.executeUpdate("DELETE FROM login where lID = '"+lID+"'");
                        JOptionPane.showMessageDialog(editContent,"User Removed");
                        new Login("");
                        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(editContent);
                        frame.dispose();

                    }catch (Exception se){
                        se.printStackTrace();
                        JOptionPane.showMessageDialog(null,se);
                    }

                }

            }

            @Override
            public void mouseEntered(MouseEvent e){
                delete.setForeground(new Color(0x1C97A3));
            }

            @Override
            public void mouseExited(MouseEvent e){
                delete.setForeground(Color.BLACK.darker());
            }
        });
        delete.setBounds(350,550,180,25);
        delete.setFont(new Font("",Font.PLAIN,20));
        editContent.add(delete);

        revalidate();
        repaint();
        return editContent;
    }

}
