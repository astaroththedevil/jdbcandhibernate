package jdbc;

import java.sql.*;

public class PeopleInsert {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/jdbc_example?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "root",
                    "admin");

            Statement statement = connection.createStatement();

            String sql = "INSERT INTO people(job,age) values ('pilot',31);";
            int rowsAffected = statement.executeUpdate(sql);
            System.out.println("Total number of records affected " + rowsAffected);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
