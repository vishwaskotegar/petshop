package petshop;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;


class Login extends JFrame{
    Login(String preloadedUsername){

        setTitle("PET SHOP");
        setSize(500,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setUndecorated(true);
        setLocationRelativeTo(null);

        JPanel panel = new MotionPanel(this);
        panel.setBounds(0, 0, 500, 50);
        panel.setOpaque(false);
        panel.setLayout(null);
        add(panel);


        JLabel login = new JLabel("L O G I N  ");
        login.setBounds(10,70,300,40 );
        login.setFont(new Font("Acumin variable concept",Font.PLAIN,50));
        login.setForeground(Color.BLACK);
        add(login);


        JLabel username = new JLabel("USERNAME ");
        username.setBounds(25,500,150,25 );
        username.setFont(new Font("Open Sans",Font.PLAIN,20));
        add(username);

        JTextField userField = new JTextField(preloadedUsername);
        userField.setBounds(155,500,275,25);
        userField.setFont(new Font("",Font.PLAIN,20));
        //userField.setForeground(new Color(77, 19, 209,50));
        userField.setBorder(null);
        userField.setOpaque(false);
        add(userField);

        JSeparator userSeperator = new JSeparator();
        userSeperator.setBounds(150,525,275,5);
        add(userSeperator);

        JLabel password = new JLabel("PASSWORD ");
        password.setBounds(25,550,150,25 );
        password.setFont(new Font("Open Sans",Font.PLAIN,20));
        add(password);

        JPasswordField passField = new JPasswordField();
        passField.setOpaque(false);
        passField.setBounds(155,550,275,25);
        passField.setFont(new Font("Open Sans",Font.PLAIN,20));
        passField.setBorder(null);
        add(passField);

        JSeparator passSeperator = new JSeparator();
        passSeperator.setBounds(150,575,275,5);
        add(passSeperator);

        JCheckBox hide = new JCheckBox("hide",true);
        hide.setBounds(430,550,100,25);
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



        JButton logButton = new JButton("LOGIN ");
        logButton.setBounds(150,585,275,50);
        logButton.setFocusable(false);
        logButton.setBackground(new Color(0x1C97A3));
        logButton.setFont(new Font("Open Sans",Font.PLAIN,20));
        logButton.setBorderPainted(false);
        logButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent lb) {
                logButton.setBackground(new Color(0x5EA8B3));
            }

            @Override
            public void mouseExited(MouseEvent lb) {
                logButton.setBackground(new Color(0x1C97A3));
            }
        });
        logButton.addActionListener(e -> {
            try{
                //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/petshop","root","1234");
                Connector con = new Connector();
                //String mysqlUsername = ;
                //String mysqlPassword = ;
                //Statement stm = con.createStatement();

                String sql = "select * from login where username = '"+userField.getText()+"' and password = '"+passField.getText()+"'";

                ResultSet rs = con.s.executeQuery(sql);
                if (rs.next()){
                    new HomePage();
                    dispose();
                }else{
                    JOptionPane.showMessageDialog(this,"wrong username or password!");
                    userField.setText("");
                    passField.setText("");

                    //con.close();
                }
            }catch (Exception ce){
                System.out.println(ce.getMessage());
            }
        });
        add(logButton);

        JLabel newUser = new JLabel("CREATE NEW");
        //newUser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        newUser.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new CreateUser();
                dispose();
            }

            @Override
            public void mouseEntered(MouseEvent e){
                newUser.setForeground(new Color(0x1C97A3));
            }

            @Override
            public void mouseExited(MouseEvent e){
                newUser.setForeground(Color.BLACK.darker());
            }
        });
        newUser.setBounds(350,655,200,25);
        newUser.setFont(new Font("",Font.PLAIN,18));
        add(newUser);

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

        ImageIcon bkg = new ImageIcon("resources\\PicsArt_07-18-08.47.54.jpg");
        JLabel background = new JLabel();
        background.setBounds(0,0,500,700);
        background.setIcon(bkg);
        add(background);

        ImageIcon icon = new ImageIcon("resources\\pet-hotel-sign-with-a-dog-and-a-cat-under-a-roof-line.png");
        JLabel jicon = new JLabel();
        jicon.setBounds(80,0,500,500);
        jicon.setIcon(icon);
        background.add(jicon);
        //setIconImage();

        jcancel.addActionListener(e ->{
                    int a = JOptionPane.showConfirmDialog(null,"Are you sure you want to exit the application?","Confirm exit",JOptionPane.YES_NO_OPTION);
                    if(a == 0)
                        System.exit(0);
                }
                );


        setResizable(false);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Login("");
    }
}
