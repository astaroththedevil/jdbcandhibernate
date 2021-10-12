package jdbc;

import java.sql.*;

public class PeopleSelect {
    public static void main(String[] args) {

        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/next_jdbc?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "root",
                    "admin");

            Statement statement = connection.createStatement();
            String stringSelect = "select * from people";
            System.out.println("The SQL query is: " + stringSelect);
            ResultSet resultSet = statement.executeQuery(stringSelect);

            System.out.println("The records selected are: ");
            int rows = 0;
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String job = resultSet.getString("job");
                int age = resultSet.getInt("age");
                System.out.println(id + ", " + job + ", " + age);
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
