package com.dao.operations;

import com.operations.mysql.MySQLConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserManager extends MySQLConnection {

    PreparedStatement preparedStatement = null;
    Statement statement = null;
    public static String session;

    public boolean login(String userName, String password) {
        getConnect();
        String loginQuery = "Select * From admin Where userName = ? and password = ?";
        try {
            preparedStatement = conn.prepareStatement(loginQuery);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                session = userName;
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("SQLException");
        } finally {
            disconnect();
        }
        return false;
    }
}
