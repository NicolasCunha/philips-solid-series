package org.philips.solid.app.controller.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.philips.solid.app.controller.db.ConnectionFactory;
import org.philips.solid.app.model.Brand;
import org.philips.solid.app.model.Model;
import org.philips.solid.app.model.Vehicle;

public class VehicleDao {

    public static List<Vehicle> getVehicles() {
        try {
            final Connection conn = ConnectionFactory.getConnection();
            final List<Vehicle> vehicles = new ArrayList<>();
            final PreparedStatement ps = conn.prepareStatement("SELECT * FROM VEHICLE");
            final ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                final Model model = ModelDao.getModel(rs.getLong("ID_MODEL"));
                final Vehicle vehicle = new Vehicle(
                        rs.getLong("ID"),
                        rs.getString("COLOR"),
                        rs.getDouble("PRICE"),
                        model.getBrand(),
                        model
                );
                vehicles.add(vehicle);
            }
            return vehicles;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
}
