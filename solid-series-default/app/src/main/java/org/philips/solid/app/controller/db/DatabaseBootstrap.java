package org.philips.solid.app.controller.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import org.philips.solid.app.controller.dao.BrandDao;
import org.philips.solid.app.model.Brand;

public class DatabaseBootstrap {

    private static final String CREATE_BRAND_SEQ = " CREATE SEQUENCE BRAND_SEQ START WITH 0 INCREMENT BY 1 ";
    private static final String CREATE_MODEL_SEQ = " CREATE SEQUENCE MODEL_SEQ START WITH 0 INCREMENT BY 1 ";
    private static final String CREATE_VEHICLE_SEQ = " CREATE SEQUENCE VEHICLE_SEQ START WITH 0 INCREMENT BY 1 ";

    private static final String CREATE_BRAND_TABLE = " CREATE TABLE BRAND ("
            + "ID INT DEFAULT NEXT VALUE FOR BRAND_SEQ PRIMARY KEY, "
            + "NAME VARCHAR(255)"
            + ") ";
    private static final String CREATE_MODEL_TABLE = " CREATE TABLE MODEL ( "
            + "ID INT DEFAULT NEXT VALUE FOR MODEL_SEQ PRIMARY KEY, "
            + "NAME VARCHAR(255), "
            + "IS_AUTOMATIC VARCHAR(1), "
            + "IS_COMBUSTION VARCHAR(1), "
            + "ID_BRAND INT, "
            + "FOREIGN KEY (ID_BRAND) REFERENCES BRAND(ID) "
            + ")";
    private static final String CREATE_VEHICLE_TABLE = " CREATE TABLE VEHICLE ( "
            + "ID INT DEFAULT NEXT VALUE FOR VEHICLE_SEQ PRIMARY KEY, "
            + "COLOR VARCHAR(20), "
            + "PRICE FLOAT, "
            + "ID_MODEL INT, "
            + "FOREIGN KEY (ID_MODEL) REFERENCES MODEL(ID) "
            + ")";

    private static final String INSERT_BRAND = " INSERT INTO BRAND (NAME) "
            + "VALUES (?)";

    private static final String INSERT_MODEL = " INSERT INTO MODEL (NAME, IS_AUTOMATIC, IS_COMBUSTION, ID_BRAND) "
            + " VALUES (?, ?, ?, ?) ";

    public static final void bootstrap() throws SQLException {
        // Create tables
        execSql(CREATE_BRAND_SEQ);
        execSql(CREATE_BRAND_TABLE);
        execSql(CREATE_MODEL_SEQ);
        execSql(CREATE_MODEL_TABLE);
        execSql(CREATE_VEHICLE_SEQ);
        execSql(CREATE_VEHICLE_TABLE);
        // Generate brands
        createBrands();
        // Generate models
        createModels();
    }

    private static void execSql(final String sql) throws SQLException {
        final Connection conn = ConnectionFactory.getConnection();
        final PreparedStatement ps = conn.prepareStatement(sql);
        ps.execute();
        ConnectionFactory.close(conn);
    }

    private static void createBrands() throws SQLException {
        final String[] brands = new String[]{"Toyota", "Honda", "Chevrolet", "Fiat", "Volkswagen", "Nissan", "Mitsubishi"};
        for (final String brand : brands) {
            final Connection conn = ConnectionFactory.getConnection();
            final PreparedStatement ps = conn.prepareStatement(INSERT_BRAND);
            ps.setString(1, brand);
            ps.execute();
            ConnectionFactory.close(conn);
        }
    }

    private static void createModels() throws SQLException {
        final List<Brand> brands = BrandDao.getBrands();
        final String[] models = new String[]{"ModelCarOne", "Mk2", "MXE", "TurboV4", "CoolCarKid", "BetterThanYours"};
        for (int i = 0; i < 1000000; i++) {
            final int brandPos = getNum(brands.size());
            final int modelPos = getNum(models.length);
            final long brandId = brands.get(brandPos).getId();
            final String model = models[modelPos];
            final Connection conn = ConnectionFactory.getConnection();
            final PreparedStatement ps = conn.prepareStatement(INSERT_MODEL);
            ps.setString(1, model);
            ps.setString(2, getYesNo());
            ps.setString(3, getYesNo());
            ps.setLong(4, brandId);
            ps.execute();
            ConnectionFactory.close(conn);
        }
    }
    
    private static String getYesNo() {
        return getNum(2) == 1 ? "Y" : "N";
    }

    private static int getNum(int max) {
        return new Random().nextInt(max);
    }

}
