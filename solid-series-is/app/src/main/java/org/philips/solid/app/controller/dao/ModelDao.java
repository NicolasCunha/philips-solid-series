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

public class ModelDao {

    public static List<Model> getModels() {
        try {
            final Connection conn = ConnectionFactory.getConnection();
            final List<Model> models = new ArrayList<>();
            final PreparedStatement ps = conn.prepareStatement("SELECT * FROM MODEL");
            final ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                final Brand brand = BrandDao.getBrand(rs.getLong("ID_BRAND"));
                final Model model = new Model(
                        rs.getLong("ID"),
                        rs.getString("NAME"),
                        rs.getString("IS_AUTOMATIC").equalsIgnoreCase("Y"),
                        rs.getString("IS_COMBUSTION").equalsIgnoreCase("Y"),
                        brand
                );
                models.add(model);
            }
            return models;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static List<Model> getModelsByBrand(final long brandId) {
        try {
            final Brand brand = BrandDao.getBrand(brandId);
            final Connection conn = ConnectionFactory.getConnection();
            final List<Model> models = new ArrayList<>();
            final PreparedStatement ps = conn.prepareStatement("SELECT * FROM MODEL WHERE ID_BRAND = ?");
            ps.setLong(1, brandId);
            final ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                final Model model = new Model(
                        rs.getLong("ID"),
                        rs.getString("NAME"),
                        rs.getString("IS_AUTOMATIC").equalsIgnoreCase("Y"),
                        rs.getString("IS_COMBUSTION").equalsIgnoreCase("Y"),
                        brand
                );
                models.add(model);
            }
            return models;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static Model getModel(final long modelId) {
        try {
            final Connection conn = ConnectionFactory.getConnection();
            final PreparedStatement ps = conn.prepareStatement("SELECT * FROM MODEL WHERE ID = ?");
            ps.setLong(1, modelId);
            final ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                final Brand brand = BrandDao.getBrand(rs.getLong("ID_BRAND"));
                return new Model(
                        rs.getLong("ID"),
                        rs.getString("NAME"),
                        rs.getString("IS_AUTOMATIC").equalsIgnoreCase("Y"),
                        rs.getString("IS_COMBUSTION").equalsIgnoreCase("Y"),
                        brand
                );
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return null;
    }

    public static void createModel(final String name,
            final String automatic,
            final String combustion,
            final Long brand) {
        try {
            final Connection conn = ConnectionFactory.getConnection();
            final PreparedStatement ps = conn.prepareStatement("INSERT INTO MODEL (NAME, IS_AUTOMATIC, IS_COMBUSTION, ID_BRAND) VALUES (?, ?, ?, ?) ");
            ps.setString(1, name);
            ps.setString(2, automatic);
            ps.setString(3, combustion);
            ps.setLong(4, brand);
            ps.execute();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void updateModel(final long id,
            final String name,
            final String automatic,
            final String combustion,
            final long brandId) {
        try {
            final Connection conn = ConnectionFactory.getConnection();
            final PreparedStatement ps = conn.prepareStatement("UPDATE MODEL SET NAME = ?, IS_AUTOMATIC = ?, IS_COMBUSTION = ?, ID_BRAND = ? WHERE ID = ?");
            ps.setString(1, name);
            ps.setString(2, automatic);
            ps.setString(3, combustion);
            ps.setLong(4, brandId);
            ps.setLong(5, id);
            ps.execute();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public static void deleteModel(final long id) {
        VehicleDao.deleteVehicleByModel(id);
        try {
            final Connection conn = ConnectionFactory.getConnection();
            final PreparedStatement ps = conn.prepareStatement("DELETE FROM MODEL WHERE ID = ?");
            ps.setLong(1, id);
            ps.execute();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }    
    
    public static void deleteModelByBrand(final long brandId) {
        getModelsByBrand(brandId).forEach(model -> {
            VehicleDao.deleteVehicleByModel(model.getId());
        });
        try {
            final Connection conn = ConnectionFactory.getConnection();
            final PreparedStatement ps = conn.prepareStatement("DELETE FROM MODEL WHERE ID_BRAND = ?");
            ps.setLong(1, brandId);
            ps.execute();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

}
