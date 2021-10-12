package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class GamesInsert {
    public static void main(String[] args) {

        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://sql65.lh.pl/serwer103916_mainbase?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "serwer103916",
                    "adminadmin"
            );

            Statement statement = connection.createStatement();

            String sql = "INSERT INTO Games(title, developer, year) values ('Metal Gear Solid', 'Konami', 1998);";
            int rowsAffected = statement.executeUpdate(sql);
            System.out.println("Total number of records affected " + rowsAffected);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
