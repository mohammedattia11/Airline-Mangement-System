package DB;

import java.sql.*;

public class AdminDB {
    public static Connection connect() throws SQLException {

        return DriverManager.getConnection("jdbc:mysql://localhost:3306/java1",
                "root", "root");

    }


    public static boolean checkAdminLogin(String username, String password) {
        String sql = "SELECT COUNT(*) FROM admin WHERE username = ? AND password = ?";

        try (Connection connection = connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
