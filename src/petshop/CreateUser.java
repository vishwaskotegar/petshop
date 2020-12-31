package petshop;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;


class CreateUser extends JFrame {
    CreateUser() {
        setTitle("PET SHOP");
        setSize(500, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setUndecorated(true);
        setLocationRelativeTo(null);

        // setExtendedState(JFrame.MAXIMIZED_BOTH);

        JPanel panel = new MotionPanel(this);
        panel.setBounds(0, 0, 500, 50);
        panel.setOpaque(false);
        panel.setLayout(null);
        add(panel);

        JLabel signUp = new JLabel("S I G N  U P");
        signUp.setBounds(10,70,300,40 );
        signUp.setFont(new Font("Acumin variable concept",Font.PLAIN,50));
        signUp.setForeground(Color.BLACK);
        add(signUp);


        JLabel firstName = new JLabel("FIRST NAME");
        firstName.setBounds(25,250,150,25);
        firstName.setFont(new Font("Open Sans",Font.PLAIN,20));
        add(firstName);

        JLabel lastName = new JLabel("LAST NAME");
        lastName.setBounds(25,300,150,25);
        lastName.setFont(new Font("Open Sans",Font.PLAIN,20));
        add(lastName);

        JLabel  email = new JLabel("EMAIL");
        email.setBounds(25,350,150,25);
        email.setFont(new Font("Open Sans",Font.PLAIN,20));
        add(email);

        JLabel phNo = new JLabel("PHONE NO.");
        phNo.setBounds(25,400,150,25);
        phNo.setFont(new Font("Open Sans",Font.PLAIN,20));
        add(phNo);

        JLabel userID = new JLabel("USER ID");
        userID.setBounds(25,450,150,25);
        userID.setFont(new Font("Open Sans",Font.PLAIN,20));
        add(userID);

        JLabel password = new JLabel("PASSWORD");
        password.setBounds(25,500,150,25);
        password.setFont(new Font("Open Sans",Font.PLAIN,20));
        add(password);

        JTextField firstField = new JTextField();
        firstField.setBounds(155,250,275,25);
        firstField.setFont(new Font("",Font.PLAIN,20));
        firstField.setBorder(null);
        firstField.setOpaque(false);
        add(firstField);

        JTextField lastField = new JTextField();
        lastField.setBounds(155,300,275,25);
        lastField.setFont(new Font("",Font.PLAIN,20));
        lastField.setBorder(null);
        lastField.setOpaque(false);
        add(lastField);

        JTextField emailField = new JTextField();
        emailField.setBounds(155,350,275,25);
        emailField.setFont(new Font("",Font.PLAIN,20));
        emailField.setBorder(null);
        emailField.setOpaque(false);
        add(emailField);

        JTextField phField = new JTextField();
        phField.setBounds(155,400,275,25);
        phField.setFont(new Font("",Font.PLAIN,20));
        phField.setBorder(null);
        phField.setOpaque(false);
        add(phField);

        JTextField userField = new JTextField();
        userField.setBounds(155,450,275,25);
        userField.setFont(new Font("",Font.PLAIN,20));
        userField.setBorder(null);
        userField.setOpaque(false);
        add(userField);

        JPasswordField passField = new JPasswordField();
        passField.setBounds(155,500,250,25);
        passField.setFont(new Font("",Font.PLAIN,20));
        passField.setBorder(null);
        passField.setOpaque(false);
        add(passField);

        JCheckBox hide = new JCheckBox("hide",true);
        hide.setBounds(410,500,100,25);
        hide.setFont(new Font("",Font.PLAIN,18));
        hide.setFocusable(false);
        hide.setContentAreaFilled(false);
        char default1 = passField.getEchoChar();
        hide.addActionListener(e -> {
            if(hide.isSelected())
                passField.setEchoChar(default1);
            else
                passField.setEchoChar((char)0);
        });
        hide.setOpaque(false);
        add(hide);

        JLabel exists = new JLabel("Username already exists");
        exists.setBounds(170,540,200,25);
        exists.setFont(new Font("",Font.PLAIN,16));
        //add(exists);

        JButton submit = new JButton("SUBMIT");
        submit.setBounds(130,585,275,50);
        //submit.setFocusPainted(false);
        //submit.setOpaque(false);
        //submit.setBorderPainted(false);
        submit.setBackground(new Color(0x1C97A3));
        submit.setFont(new Font("Open Sans",Font.PLAIN,20));
        add(submit);

        submit.addActionListener(e -> {

            try{
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/petshop","root","1234");

                String mysqlFN = firstField.getText();
                String mysqlLN = lastField.getText();
                String mysqlEm = emailField.getText();
                String mysqlPH = phField.getText();
                String mysqlUID = userField.getText();
                String mysqlP = passField.getText();

                if (isNumeric(mysqlPH)) {

                    Statement stm = con.createStatement();

                    ResultSet rs = stm.executeQuery("select * from login where username = '" + userField.getText() + "';");
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(this, "Username already exits!");
                    } else {
                        stm.executeUpdate("INSERT INTO login VALUES(DEFAULT,'" + userField.getText() + "','" + passField.getText() + "');");
                        String sql = "INSERT INTO EMPLOYEE VALUES(LAST_INSERT_ID(),'" + mysqlFN + "','" + mysqlLN + "','" + mysqlEm + "','" + mysqlPH + "')";
                        stm.executeUpdate(sql);
                        JOptionPane.showMessageDialog(this, "new user '" + mysqlUID + "' created");
                        new Login(mysqlUID);
                        dispose();
                    }
                }else{
                    JOptionPane.showMessageDialog(this,"Enter valid phone number");
                }


            }catch (Exception ce){
                System.out.println(ce.getMessage());
            }
        });

        ImageIcon cancel = new ImageIcon("resources\\cancel.png");
        JButton jcancel = new JButton();
        jcancel.setBounds(450,0,50,50);
        jcancel.setIcon(cancel);
        jcancel.setOpaque(false);
        jcancel.setContentAreaFilled(false);
        jcancel.setBorderPainted(false);
        jcancel.setFocusable(false);
        jcancel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent c) {

            }

            @Override
            public void mouseEntered(MouseEvent c) {
                ImageIcon cancel1 = new ImageIcon("resources\\cancel1.png");
                jcancel.setIcon(cancel1);

            }

            @Override
            public void mouseExited(MouseEvent c) {
                jcancel.setIcon(cancel);
            }
        });
        panel.add(jcancel);
        jcancel.addActionListener(e ->{
                    int a = JOptionPane.showConfirmDialog(null,"Are you sure you want to exit the application?","Confirm exit",JOptionPane.YES_NO_OPTION);
                    if(a == 0)
                    System.exit(0);
                }
        );

        JLabel back = new JLabel("<");
        //newUser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new Login("");
                dispose();
            }

            @Override
            public void mouseEntered(MouseEvent e){
                back.setForeground(new Color(0x1C97A3));
            }

            @Override
            public void mouseExited(MouseEvent e){
                back.setForeground(Color.BLACK.darker());
            }
        });
        back.setBounds(20,10,50,25);
        back.setFont(new Font("",Font.PLAIN,50));
        panel.add(back);

        ImageIcon bkg = new ImageIcon("resources\\PicsArt_07-18-08.47.54.jpg");
        JLabel background = new JLabel();
        background.setBounds(0,0,500,700);
        background.setIcon(bkg);
        add(background);

        ImageIcon icon = new ImageIcon("resources\\createUser.png");
        JLabel jicon = new JLabel();
        jicon.setBounds(220,-20,500,300);
        jicon.setIcon(icon);
        background.add(jicon);


        setVisible(true);

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
        new CreateUser();
    }
}
