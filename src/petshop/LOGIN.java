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
        setLocationRelativeTo(null);


        JLabel login = new JLabel("L O G I N    P A G E");
        login.setBounds(110,200,300,25 );
        login.setFont(new Font("Roboto",Font.BOLD,30));
        login.setForeground(new Color(0x4581D4));
        add(login);


        JLabel username = new JLabel("USERNAME ");
        username.setBounds(50,350,100,25 );
        add(username);

        JTextField userField = new JTextField();
        userField.setBounds(150,350,200,25);
        userField.setBorder(null);
        userField.setOpaque(false);
        add(userField);

        JSeparator userSeperator = new JSeparator();
        userSeperator.setBounds(150,375,200,5);
        add(userSeperator);

        JLabel password = new JLabel("PASSWORD ");
        password.setBounds(50,400,100,25 );
        add(password);

        JPasswordField passField = new JPasswordField();
        passField.setOpaque(false);
        passField.setBounds(150,400,200,25);
        passField.setBorder(null);
        add(passField);

        JSeparator passSeperator = new JSeparator();
        passSeperator.setBounds(150,425,200,5);
        add(passSeperator);

        JButton logButton = new JButton("LOGIN ");
        logButton.setBounds(150,500,200,25);
        logButton.setFocusable(false);
        //logButton.setBackground(new Color(0xBED0EA));
        add(logButton);

        ImageIcon bkg = new ImageIcon("resources\\PicsArt_07-18-08.47.54.jpg");
        JLabel background = new JLabel();
        background.setBounds(0,0,500,700);
        background.setIcon(bkg);
        add(background);

        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
                new Login();

    }
}
