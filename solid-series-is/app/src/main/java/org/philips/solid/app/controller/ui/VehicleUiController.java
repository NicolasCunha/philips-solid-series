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

    public VehicleUiController(JFrame parent,
            JTable table) {
        super(parent, table);
    }

    @Override
    public void refreshData() {
        List<Vehicle> vehicles = VehicleDao.getVehicles();
        DefaultTableModel vehicleTblModel = (DefaultTableModel) this.getTable().getModel();
        vehicleTblModel.setRowCount(0);
        vehicles.forEach(vehicle -> {
            vehicleTblModel.addRow(new Object[]{
                vehicle.getId(), vehicle.getColor(), vehicle.getPrice(),
                vehicle.getModel().getName(), vehicle.getBrand().getName()});
        });
        this.getTable().setModel(vehicleTblModel);
    }

    @Override
    public void create() {
        CreateVehicle createVehicle = new CreateVehicle(this.getParent(), true);
        createVehicle.setVisible(true);
    }

    @Override
    public void update() {
        int selectedVehicle = this.getTable().getSelectedRow();
        long vehicleId = (long) this.getTable().getValueAt(selectedVehicle, 0);
        EditVehicle editVehicle = new EditVehicle(this.getParent(), true, vehicleId);
        editVehicle.setVisible(true);
        refreshData();
        selectRow(selectedVehicle);
    }

    @Override
    public void delete() {
        int selectedVehicle = this.getTable().getSelectedRow();
        long vehicleId = (long) this.getTable().getValueAt(selectedVehicle, 0);
        VehicleDao.deleteVehicle(vehicleId);
        this.refreshData();

        if (selectedVehicle - 1 < 0) {
            selectedVehicle = 1;
        }

        this.selectRow(selectedVehicle - 1);
    }

}
