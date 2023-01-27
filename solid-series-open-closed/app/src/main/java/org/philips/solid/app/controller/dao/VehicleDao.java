package org.philips.solid.app.controller.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.philips.solid.app.controller.db.ConnectionFactory;
import org.philips.solid.app.model.ElectricVehicle;
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
                final Vehicle vehicle = getSpecificVehicleFromModel(rs, model);
                vehicles.add(vehicle);
            }
            return vehicles;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static Vehicle getVehicle(final long id) {
        try {
            final Connection conn = ConnectionFactory.getConnection();
            final PreparedStatement ps = conn.prepareStatement("SELECT * FROM VEHICLE WHERE ID = ?");
            ps.setLong(1, id);
            final ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                final Model model = ModelDao.getModel(rs.getLong("ID_MODEL"));
                return getSpecificVehicleFromModel(rs, model);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return null;
    }

    public static void createVehicle(final String color,
            final Double price,
            final long modelId) {
        try {
            final Connection conn = ConnectionFactory.getConnection();
            final PreparedStatement ps = conn.prepareStatement("INSERT INTO VEHICLE (COLOR, PRICE, ID_MODEL) VALUES (?, ?, ?) ");
            ps.setString(1, color);
            ps.setDouble(2, price);
            ps.setLong(3, modelId);
            ps.execute();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void updateVehicle(final long id,
            final String color,
            final Double price,
            final long modelId) {
        try {
            final Connection conn = ConnectionFactory.getConnection();
            final PreparedStatement ps = conn.prepareStatement("UPDATE VEHICLE SET COLOR = ?, PRICE = ?, ID_MODEL = ? WHERE ID = ?");
            ps.setString(1, color);
            ps.setDouble(2, price);
            ps.setLong(3, modelId);
            ps.setLong(4, id);
            ps.execute();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void deleteVehicle(final long id) {
        try {
            final Connection conn = ConnectionFactory.getConnection();
            final PreparedStatement ps = conn.prepareStatement("DELETE FROM VEHICLE WHERE ID = ?");
            ps.setLong(1, id);
            ps.execute();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void deleteVehicleByModel(final long modelId) {
        try {
            final Connection conn = ConnectionFactory.getConnection();
            final PreparedStatement ps = conn.prepareStatement("DELETE FROM VEHICLE WHERE ID_MODEL = ?");
            ps.setLong(1, modelId);
            ps.execute();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    private static Vehicle getSpecificVehicleFromModel(final ResultSet rs, final Model model) throws SQLException {
        if (model.isCombustion()) {
            return new Vehicle(
                    rs.getLong("ID"),
                    rs.getString("COLOR"),
                    rs.getDouble("PRICE"),
                    model.getBrand(),
                    model
            );
        } else {
            return new ElectricVehicle(
                    rs.getLong("ID"),
                    rs.getString("COLOR"),
                    rs.getDouble("PRICE"),
                    model.getBrand(),
                    model
            );
        }
    }

}
