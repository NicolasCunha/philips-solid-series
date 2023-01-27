package org.philips.solid.app.controller.ui;

import java.util.List;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.philips.solid.app.controller.dao.VehicleDao;
import org.philips.solid.app.model.Vehicle;
import org.philips.solid.app.view.CreateVehicle;

public class VehicleUiController {
    
    public void createVehicle(JFrame parent) {
        CreateVehicle createVehicle = new CreateVehicle(parent, true);
        createVehicle.setVisible(true);
    }
    
    public void refreshVehicles(JTable table) {
        List<Vehicle> vehicles = VehicleDao.getVehicles();
        DefaultTableModel vehicleTblModel = (DefaultTableModel) table.getModel();
        vehicleTblModel.setRowCount(0);
        vehicles.forEach(vehicle -> {
            vehicleTblModel.addRow(new Object[]{
                vehicle.getId(), vehicle.getColor(), vehicle.getPrice(),
                vehicle.getModel().getName(), vehicle.getBrand().getName()});
        });
        table.setModel(vehicleTblModel);
    }
    
}
