package org.philips.solid;

import java.sql.SQLException;
import javax.swing.JFrame;
import org.philips.solid.app.controller.db.DatabaseBootstrapper;
import org.philips.solid.app.view.AppView;

public class App {

    public static void main(String[] args) throws SQLException {
        // Bootstrap database, creating tables and mock data.
        DatabaseBootstrapper.bootstrap();
        // Create app main window
        final JFrame frame = new AppView();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setTitle("Gerenciamento de Carros");
    }
    
}
