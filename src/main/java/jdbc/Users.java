package jdbc;

import java.sql.*;

public class Users {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/next_jdbc?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "root",
                    "admin");


            Statement statement = connection.createStatement();

            String sql = "drop table if exists USERS;";
            int rowsAffected = statement.executeUpdate(sql);
            System.out.println("Total number of records affected " + rowsAffected);


            statement = connection.createStatement();
            sql = "CREATE TABLE if not exists USERS(ID int NOT NULL AUTO_INCREMENT,FIRST_NAME VARCHAR(255)," +
                    "LAST_NAME VARCHAR(255),AGE INT,PRIMARY KEY (ID));";
            rowsAffected = statement.executeUpdate(sql);
            System.out.println("Total number of records affected " + rowsAffected);

            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM USERS");
            ResultSetMetaData rsmd = resultSet.getMetaData();
            int numberOfColumns = rsmd.getColumnCount();

            for (int i = 1; i <= numberOfColumns; i++){
                System.out.println(rsmd.getColumnName(i) + " " + rsmd.getColumnTypeName(i));
            }

            boolean b = rsmd.isSearchable(1);
            System.out.println("number of columns : " + numberOfColumns );

            statement.close();
            connection.close();



        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

