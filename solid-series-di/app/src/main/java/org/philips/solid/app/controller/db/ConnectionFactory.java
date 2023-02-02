package org.philips.solid.app.controller.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Stack;

public class ConnectionFactory {

    private static final Stack<Connection> POOL = new Stack<>();
    
    static {
        for (int i = 0; i < 10; i++) {
            POOL.add(openConnection());
        }
    }

    public static Connection getConnection() {
        if (POOL.isEmpty()) {
            return openConnection();
        }
        return POOL.pop();
    }
    
    public static void close(final Connection conn) {
        POOL.add(conn);
    }

    private static Connection openConnection() {
        try {
            Class.forName("org.h2.Driver");
            return DriverManager.getConnection("jdbc:h2:mem:test", "sa", "");
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

}
