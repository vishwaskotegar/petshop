package petshop;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class test extends JFrame {
    private JComboBox comboBox1;
    private JPanel panel1;

    public test(){
        JTable table = new JTable();
        try {
            Connector con = new Connector();
            ResultSet rs = con.s.executeQuery("SELECT * FROM INVENTORY;");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            JScrollPane pane = new JScrollPane(table);

            add(pane);
        }catch (SQLException se){
            System.out.println(se);
        }
        setVisible(true);
    }

    public static void main(String[] args) {
        new test();
    }
}
