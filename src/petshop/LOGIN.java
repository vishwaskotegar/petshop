package petshop;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class Login extends JFrame{
    Login(){
        setTitle("PET SHOP");
        setSize(500,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());
        setContentPane(new JLabel(new ImageIcon("resources\\PicsArt_07-18-08.47.54")));
        setLayout(null);



        JLabel login = new JLabel("LOGIN PAGE");
        login.setBounds(160,200,200,25 );
        login.setFont(new Font("Roboto",Font.BOLD,25));
        login.setForeground(new Color(0X045FB4));
        add(login);


        JLabel username = new JLabel("USERNAME ");
        username.setBounds(50,350,100,25 );
        add(username);

        JTextField userField = new JTextField();
        userField.setBounds(150,350,200,25);
        //userField.setForeground(Color.WHITE);
        //userField.setBackground(new Color(10,120,140,85));
        add(userField);

        JLabel password = new JLabel("PASSWORD ");
        password.setBounds(50,400,100,25 );
        add(password);

        JPasswordField passField = new JPasswordField();
        passField.setBounds(150,400,200,25);
        //passField.setBackground(new Color(10,120,140,85));
        add(passField);

        JButton logButton = new JButton("LOGIN ");
        logButton.setBounds(150,450,200,25);
        add(logButton);

        setVisible(true);
    }

    public static void main(String[] args) {
                new Login();

    }
}
