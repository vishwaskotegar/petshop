package petshop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Connector {

    public Connection c;
    public Statement s;

    public Connector() {

        try {
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/petshop", "root", "1234");
            s = c.createStatement();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}