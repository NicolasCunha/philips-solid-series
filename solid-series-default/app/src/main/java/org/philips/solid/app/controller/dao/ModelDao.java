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

}
