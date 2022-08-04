package com.operations.mysql;

import com.dao.operations.DepartmentManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySQLConnection extends ConnectionManager {

    public static Connection conn = null;

    public void getConnect() {
        String url = "jdbc:mysql://" + host + ":" + port + "/" + dbName + "?useUnicode=true&characterEncoding=utf8";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Verilənlər bazası ilə əlaqə yaradıla bilmədi.");
        }
    }

    public void disconnect() {
        try {
            conn.setAutoCommit(false);
            conn.rollback();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
