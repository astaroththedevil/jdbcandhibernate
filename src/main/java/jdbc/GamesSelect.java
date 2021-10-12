package jdbc;

import java.sql.*;

public class GamesSelect {
    public static void main(String[] args) {

        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://sql65.lh.pl/serwer103916_mainbase?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "serwer103916",
                    "adminadmin"
            );
            Statement statement = connection.createStatement();
            String stringSelect = "select * from Games";
            System.out.println("The SQL query is: " + stringSelect);
            ResultSet resultSet = statement.executeQuery(stringSelect);

            System.out.println("The records selected are: ");
            int rows = 0;
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String developer = resultSet.getString("developer");
                int year = resultSet.getInt("year");
                System.out.println(id + ", " + title + ", " + developer + ", " + year);
                ++rows;
            }
            System.out.println("Total number of records = " + rows);

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
