package petshop;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class Login extends JFrame{
    Login(){
        setTitle("PET SHOP");
        setSize(500,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setUndecorated(true);
        setLocationRelativeTo(null);


        JLabel login = new JLabel("L O G I N  ");
        login.setBounds(10,70,300,40 );
        login.setFont(new Font("Acumin variable concept",Font.PLAIN,50));
        login.setForeground(Color.BLACK);
        add(login);


        JLabel username = new JLabel("USERNAME ");
        username.setBounds(25,450,150,25 );
        username.setFont(new Font("Open Sans",Font.PLAIN,20));
        add(username);

        JTextField userField = new JTextField();
        userField.setBounds(150,450,275,25);
        userField.setBorder(null);
        userField.setOpaque(false);
        add(userField);

        JSeparator userSeperator = new JSeparator();
        userSeperator.setBounds(150,475,275,5);
        add(userSeperator);

        JLabel password = new JLabel("PASSWORD ");
        password.setBounds(25,500,150,25 );
        password.setFont(new Font("Open Sans",Font.PLAIN,20));
        add(password);

        JPasswordField passField = new JPasswordField();
        passField.setOpaque(false);
        passField.setBounds(150,500,275,25);
        passField.setBorder(null);
        add(passField);

        JSeparator passSeperator = new JSeparator();
        passSeperator.setBounds(150,525,275,5);
        add(passSeperator);

        JButton logButton = new JButton("LOGIN ");
        logButton.setBounds(150,600,200,25);
        logButton.setFocusable(false);
        //logButton.setBackground(new Color(0xBED0EA));
        add(logButton);

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

        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
                new Login();

    }
}
