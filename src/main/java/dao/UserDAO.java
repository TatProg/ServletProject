package dao;

import entity.User;

import java.sql.*;

public class UserDAO {
    public User findUser(String name, String password) {
        User user = null;
        try {
            Connection connection = ConnectionDB.getDBConnection();
            PreparedStatement statement = connection.prepareStatement("select * from usr where name=?");
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();

            if (rs.next() && rs.getString("password").equals(password)) {
                user = new User();
                user.setId(rs.getLong("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
            }

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
