package com.company.dao.inter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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

    private static EntityManagerFactory emf = null;

    public EntityManager em() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("resumeAppPU");
        }

        EntityManager entityManager = emf.createEntityManager();
        return entityManager;
    }

    public void closeEmf() {
        emf.close();
    }
}
