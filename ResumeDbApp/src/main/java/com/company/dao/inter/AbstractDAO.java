package com.company.dao.inter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class AbstractDAO {

    public Connection connect() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        String host = "localhost";
        String db = "resume";
        int port = 3306;
        String url = "jdbc:mysql://" + host + ":" + port + "/" + db;
        String username = "root";
        String password = "123456789az";
        Connection c = DriverManager.getConnection(url, username, password);

        return c;
    }
}
