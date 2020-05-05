package dao;

import java.sql.*;

public class DocumentDAO {
    public void saveDocument(StringBuilder data) {
        try {
            Connection connection = ConnectionDB.getDBConnection();
            PreparedStatement statement = connection.prepareStatement("insert into documents (data) values (?)");
            statement.setString(1, data.toString());
            statement.executeUpdate();

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();


        }
    }
}
