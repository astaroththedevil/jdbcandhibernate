package jdbc;

import java.sql.*;

public class Books {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/jdbc?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "root",
                    "admin");
            Statement statement = connection.createStatement();
            String stringSelect = "select * from books";
            System.out.println("The SQL query is: " + stringSelect);
            ResultSet resultSet = statement.executeQuery(stringSelect);

            System.out.println("The records selected are: ");
            int rows = 0;
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                float price = resultSet.getFloat("price");
                int qty = resultSet.getInt("qty");
                System.out.println(id + ", " + title + ", " + author + ", " + price + ", " + qty + ", ");
                ++rows;
            }
            System.out.println("Total number of records = " + rows);

            statement = connection.createStatement();
            String selectQ = "select * from books where qty > 3";
            System.out.println("The SQL query is: " + selectQ);
            resultSet = statement.executeQuery(selectQ);

            System.out.println("The records selected are: ");

            int rows2 = 0;
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                float price = resultSet.getFloat("price");
                int qty = resultSet.getInt("qty");
                System.out.println(id + ", " + title + ", " + author + ", " + price + ", " + qty + ", ");
                ++rows2;
            }
            System.out.println("Total number of records = " + rows2);

            statement = connection.createStatement();
            String selectQ2 = "select * from books where qty > 3 and price < 40";
            System.out.println("The SQL query is: " + selectQ2);
            resultSet = statement.executeQuery(selectQ2);

            System.out.println("The records selected are: ");

            int rows3 = 0;
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                float price = resultSet.getFloat("price");
                int qty = resultSet.getInt("qty");
                System.out.println(id + ", " + title + ", " + author + ", " + price + ", " + qty + ", ");
                ++rows3;
            }
            System.out.println("Total number of records = " + rows3);

            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
