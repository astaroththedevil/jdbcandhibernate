package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BooksUpdate {
    public static void main(String[] args) {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/jdbc?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "root",
                    "admin");
            Statement statement = connection.createStatement();
            String sql = "update books set title='Imię Wiatru' where id = 1";
            int rowsAffected = statement.executeUpdate(sql);
            System.out.println("Total number of records affected " + rowsAffected);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
