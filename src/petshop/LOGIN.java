package petshop;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;


class Login extends JFrame{
    Login(){

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

        JTextField userField = new JTextField();
        userField.setBounds(155,500,275,25);
        userField.setFont(new Font("",Font.PLAIN,20));
        //userField.setForeground(new Color(77, 19, 209));
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

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/petshop?useSSL=false","root","1234");

            String mysqlUsername = username.getText();
            String mysqlPassword = password.getText();

            Statement stm = con.createStatement();

            //String sql = "select * from employee where username = '"+mysqlUsername+"'"
        }catch (Exception ce){
            System.out.println(ce.getMessage());
        }

        JButton logButton = new JButton("LOGIN ");
        logButton.setBounds(150,585,275,50);
        logButton.setFocusable(false);
        logButton.setBackground(new Color(0x1C97A3));
        logButton.setFont(new Font("Open Sans",Font.PLAIN,20));
        logButton.addActionListener(e -> {});
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
                newUser.setForeground(Color.WHITE.darker());
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

        jcancel.addActionListener(e -> System.exit(0));


        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
                new Login();

    }
}
