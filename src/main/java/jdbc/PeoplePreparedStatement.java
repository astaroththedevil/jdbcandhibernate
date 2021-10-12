package jdbc;

import java.sql.*;
import java.util.Scanner;

public class PeoplePreparedStatement {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Give an occupation:");
        String occupation = scanner.nextLine();
        System.out.println("Give an age:");
        int age2 = scanner.nextInt();

        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/jdbc_example?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "root",
                    "admin");

            String query = "select * from people where job = ? and age > ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, occupation);
            preparedStatement.setInt(2, age2);

            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("Found records:");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String job = resultSet.getString("job");
                double age = resultSet.getInt("age");
                System.out.println(id + ", " + job + ", " + age);
            }
            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
