package main;

import java.sql.*;

public class DataToSQL {

    private String url = "jdbc:mysql://localhost:3306/users_info";
    private String user = "root";
    private String password = "1234";


    public void addUserToSQL(String userName, int userAge) {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            System.out.println("Connection success");
            statement.execute(
                    "INSERT INTO `users` (`name`, `age`) VALUES ('" + userName + "', " + userAge +")"
            );

            statement.close();
            connection.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void deleteUserFromSQL(Integer userIdToRemove) {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            System.out.println("Connection success");
            statement.execute(
                    "DELETE FROM `users` WHERE `id`=" + userIdToRemove.intValue()
            );

            statement.close();
            connection.close();
            System.out.println("Удалили из Базы");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}
