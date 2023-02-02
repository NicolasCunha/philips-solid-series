package org.philips.solid.app.controller.ui;

import java.util.List;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.philips.solid.app.controller.dao.VehicleDao;
import org.philips.solid.app.model.Vehicle;
import org.philips.solid.app.view.CreateVehicle;
import org.philips.solid.app.view.EditVehicle;

public class VehicleUiController extends UiController {

    @Override
    public void refreshData(final JTable table) {
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

    @Override
    public void create(final JFrame parent) {
        CreateVehicle createVehicle = new CreateVehicle(parent, true);
        createVehicle.setVisible(true);
    }

    @Override
    public void update(final JFrame parent, final JTable table) {
        int selectedVehicle = table.getSelectedRow();
        long vehicleId = (long) table.getValueAt(selectedVehicle, 0);
        EditVehicle editVehicle = new EditVehicle(parent, true, vehicleId);
        editVehicle.setVisible(true);
        refreshData(table);
        selectRow(table, selectedVehicle);
    }

    @Override
    public void delete(final JTable table) {
        int selectedVehicle = table.getSelectedRow();
        long vehicleId = (long) table.getValueAt(selectedVehicle, 0);
        VehicleDao.deleteVehicle(vehicleId);
        this.refreshData(table);

        if (selectedVehicle - 1 < 0) {
            selectedVehicle = 1;
        }

        this.selectRow(table, selectedVehicle - 1);
    }

}
