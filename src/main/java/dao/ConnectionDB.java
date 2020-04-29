package dao;

import java.sql.*;

public class ConnectionDB {

    public static Connection getDBConnection() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            String dbURL = "jdbc:postgresql://localhost:5432/test_db";      //Add your data and your db name
            connection =
                    DriverManager.getConnection(dbURL, "postgres", "12345");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static boolean validate(String name, String pass) {
        boolean status = false;
        try {
            Connection con = getDBConnection();

            PreparedStatement ps = con.prepareStatement(
                    "select * from usr where login=? and password=?");
            ps.setString(1, name);
            ps.setString(2, pass);

            ResultSet rs = ps.executeQuery();
            status = rs.next();

        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }
}
