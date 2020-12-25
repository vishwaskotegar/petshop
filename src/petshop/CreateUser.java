package petshop;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.*;


class CreateUser extends JFrame {
    CreateUser() {
        setTitle("PET SHOP");
        setSize(500, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        //setUndecorated(true);
        setLocationRelativeTo(null);

        // setExtendedState(JFrame.MAXIMIZED_BOTH);


        Connector con = new Connector();

        //ResultSet rs = con.s.executeQuery();

        setVisible(true);
    }
}
