package test;

import java.sql.*;
import java.util.Properties;

public class Main {
    public static void main(String args[]) {
        try {
            Properties props = new Properties();
            props.load(Main.class.getClassLoader().getResourceAsStream("application.properties"));

            String url = props.getProperty("url");
            String username = props.getProperty("username");
            String password = props.getProperty("password");

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);

            Statement stmt = con.createStatement();

            //
            ResultSet rs = stmt.executeQuery("SELECT * FROM Book");

            while(rs.next())
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));

            con.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}