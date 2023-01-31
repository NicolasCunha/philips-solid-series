package org.philips.solid.app.controller.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.philips.solid.app.controller.db.ConnectionFactory;
import org.philips.solid.app.model.Brand;

public class BrandDao {
    
    public static Brand getBrand(final long id) {
        try {
            final Connection conn = ConnectionFactory.getConnection();
            final PreparedStatement ps = conn.prepareStatement("SELECT * FROM BRAND WHERE ID = ?");
            ps.setLong(1, id);
            final ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Brand(rs.getLong("ID"), rs.getString("NAME"));
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return null;
    }

    public static List<Brand> getBrands() {        
        try {
            final Connection conn = ConnectionFactory.getConnection();
            final List<Brand> brands = new ArrayList<>();
            final PreparedStatement ps = conn.prepareStatement("SELECT * FROM BRAND");
            final ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                final Brand brand = new Brand(rs.getLong("ID"), rs.getString("NAME"));
                brands.add(brand);
            }
            return brands;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public static void createBrand(final String name) {
        try {
            final Connection conn = ConnectionFactory.getConnection();
            final PreparedStatement ps = conn.prepareStatement("INSERT INTO BRAND (NAME) VALUES (?) ");
            ps.setString(1, name);
            ps.execute();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public static void updateBrand(final long id, 
            final String name) {
        try {
            final Connection conn = ConnectionFactory.getConnection();
            final PreparedStatement ps = conn.prepareStatement("UPDATE BRAND SET NAME = ? WHERE ID = ?");
            ps.setString(1, name);
            ps.setLong(2, id);
            ps.execute();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public static void deleteBrand(final long id) {
        ModelDao.deleteModelByBrand(id);
        try {
            final Connection conn = ConnectionFactory.getConnection();
            final PreparedStatement ps = conn.prepareStatement("DELETE FROM BRAND WHERE ID = ?");
            ps.setLong(1, id);
            ps.execute();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

}
