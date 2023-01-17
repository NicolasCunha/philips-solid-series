package org.philips.solid.app.view;

import java.util.List;
import javax.swing.JTabbedPane;
import javax.swing.table.DefaultTableModel;
import org.philips.solid.app.controller.dao.BrandDao;
import org.philips.solid.app.controller.dao.ModelDao;
import org.philips.solid.app.controller.dao.VehicleDao;
import org.philips.solid.app.model.Brand;
import org.philips.solid.app.model.Model;
import org.philips.solid.app.model.Vehicle;

public class AppView extends javax.swing.JFrame {

    public AppView() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbedPaneContainer = new javax.swing.JTabbedPane();
        vehiclePanel = new javax.swing.JPanel();
        vehicleTableScrollPane = new javax.swing.JScrollPane();
        vehicleTable = new javax.swing.JTable();
        brandPanel = new javax.swing.JPanel();
        brandTableScrollPane = new javax.swing.JScrollPane();
        brandTable = new javax.swing.JTable();
        modelPanel = new javax.swing.JPanel();
        modelTableScrollPane = new javax.swing.JScrollPane();
        modelTable = new javax.swing.JTable();
        btnNovo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabbedPaneContainer.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tabbedPaneContainerStateChanged(evt);
            }
        });

        vehicleTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Cor", "Preço", "Modelo", "Marca"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        vehicleTableScrollPane.setViewportView(vehicleTable);

        javax.swing.GroupLayout vehiclePanelLayout = new javax.swing.GroupLayout(vehiclePanel);
        vehiclePanel.setLayout(vehiclePanelLayout);
        vehiclePanelLayout.setHorizontalGroup(
            vehiclePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(vehicleTableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 742, Short.MAX_VALUE)
        );
        vehiclePanelLayout.setVerticalGroup(
            vehiclePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(vehicleTableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
        );

        tabbedPaneContainer.addTab("Veículos", vehiclePanel);

        brandTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Marca"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        brandTableScrollPane.setViewportView(brandTable);

        javax.swing.GroupLayout brandPanelLayout = new javax.swing.GroupLayout(brandPanel);
        brandPanel.setLayout(brandPanelLayout);
        brandPanelLayout.setHorizontalGroup(
            brandPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(brandTableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 742, Short.MAX_VALUE)
        );
        brandPanelLayout.setVerticalGroup(
            brandPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(brandTableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
        );

        tabbedPaneContainer.addTab("Marcas", brandPanel);

        modelTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Automático", "Combustão", "Marca"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        modelTableScrollPane.setViewportView(modelTable);

        javax.swing.GroupLayout modelPanelLayout = new javax.swing.GroupLayout(modelPanel);
        modelPanel.setLayout(modelPanelLayout);
        modelPanelLayout.setHorizontalGroup(
            modelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(modelTableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 742, Short.MAX_VALUE)
        );
        modelPanelLayout.setVerticalGroup(
            modelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(modelTableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
        );

        tabbedPaneContainer.addTab("Modelos", modelPanel);

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabbedPaneContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 742, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnNovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                    .addComponent(btnSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(tabbedPaneContainer)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        switch (this.tabbedPaneContainer.getSelectedIndex()) {
            case 0:
                CreateVehicle createVehicle = new CreateVehicle(this, true);
                createVehicle.setVisible(true);
                List<Vehicle> vehicles = VehicleDao.getVehicles();
                DefaultTableModel vehicleTblModel = (DefaultTableModel) vehicleTable.getModel();
                vehicleTblModel.setRowCount(0);
                vehicles.forEach(vehicle -> {
                    vehicleTblModel.addRow(new Object[]{
                        vehicle.getId(), vehicle.getColor(), vehicle.getPrice(),
                        vehicle.getModel().getName(), vehicle.getBrand().getName()});
                });
                vehicleTable.setModel(vehicleTblModel);
                break;
            case 1:
                CreateBrand createBrand = new CreateBrand(this, true);
                createBrand.setVisible(true);
                List<Brand> brands = BrandDao.getBrands();
                DefaultTableModel brandTblModel = (DefaultTableModel) brandTable.getModel();
                brandTblModel.setRowCount(0);
                brands.forEach(brand -> {
                    brandTblModel.addRow(new Object[]{brand.getId(), brand.getName()});
                });
                brandTable.setModel(brandTblModel);
                break;
            case 2:
                CreateModel createModel = new CreateModel(this, true);
                createModel.setVisible(true);
                List<Model> models = ModelDao.getModels();
                DefaultTableModel modelTblModel = (DefaultTableModel) modelTable.getModel();
                modelTblModel.setRowCount(0);
                models.forEach(model -> {
                    modelTblModel.addRow(new Object[]{model.getId(), model.getName(),
                        model.isAutomatic(), model.isCombustion(),
                        model.getBrand().getName()});
                });
                modelTable.setModel(modelTblModel);
                break;
        }
    }//GEN-LAST:event_btnNovoActionPerformed

    private void tabbedPaneContainerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tabbedPaneContainerStateChanged
        final JTabbedPane pane = (JTabbedPane) evt.getSource();
        switch (pane.getSelectedIndex()) {
            case 0:
                List<Vehicle> vehicles = VehicleDao.getVehicles();
                DefaultTableModel vehicleTblModel = (DefaultTableModel) vehicleTable.getModel();
                vehicleTblModel.setRowCount(0);
                vehicles.forEach(vehicle -> {
                    vehicleTblModel.addRow(new Object[]{
                        vehicle.getId(), vehicle.getColor(), vehicle.getPrice(),
                        vehicle.getModel().getName(), vehicle.getBrand().getName()});
                });
                vehicleTable.setModel(vehicleTblModel);
                break;
            case 1:
                List<Brand> brands = BrandDao.getBrands();
                DefaultTableModel brandTblModel = (DefaultTableModel) brandTable.getModel();
                brandTblModel.setRowCount(0);
                brands.forEach(brand -> {
                    brandTblModel.addRow(new Object[]{brand.getId(), brand.getName()});
                });
                brandTable.setModel(brandTblModel);
                break;
            case 2:
                List<Model> models = ModelDao.getModels();
                DefaultTableModel modelTblModel = (DefaultTableModel) modelTable.getModel();
                modelTblModel.setRowCount(0);
                models.forEach(model -> {
                    modelTblModel.addRow(new Object[]{model.getId(), model.getName(),
                        model.isAutomatic(), model.isCombustion(),
                        model.getBrand().getName()});
                });
                modelTable.setModel(modelTblModel);
                break;
        }
    }//GEN-LAST:event_tabbedPaneContainerStateChanged

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        switch (this.tabbedPaneContainer.getSelectedIndex()) {
            case 0:
                int selectedVehicle = vehicleTable.getSelectedRow();
                long vehicleId = (long) vehicleTable.getValueAt(selectedVehicle, 0);
                EditVehicle editVehicle = new EditVehicle(this, true, vehicleId);
                editVehicle.setVisible(true);
                List<Vehicle> vehicles = VehicleDao.getVehicles();
                DefaultTableModel vehicleTblModel = (DefaultTableModel) vehicleTable.getModel();
                vehicleTblModel.setRowCount(0);
                vehicles.forEach(vehicle -> {
                    vehicleTblModel.addRow(new Object[]{
                        vehicle.getId(), vehicle.getColor(), vehicle.getPrice(),
                        vehicle.getModel().getName(), vehicle.getBrand().getName()});
                });
                vehicleTable.setModel(vehicleTblModel);
                vehicleTable.setRowSelectionInterval(selectedVehicle, selectedVehicle);
                break;
            case 1:
                int selectedBrand = brandTable.getSelectedRow();
                long brandId = (long) brandTable.getValueAt(selectedBrand, 0);
                EditBrand editBrand = new EditBrand(this, true, brandId);
                editBrand.setVisible(true);
                List<Brand> brands = BrandDao.getBrands();
                DefaultTableModel brandTblModel = (DefaultTableModel) brandTable.getModel();
                brandTblModel.setRowCount(0);
                brands.forEach(brand -> {
                    brandTblModel.addRow(new Object[]{brand.getId(), brand.getName()});
                });
                brandTable.setModel(brandTblModel);
                brandTable.setRowSelectionInterval(selectedBrand, selectedBrand);
                break;
            case 2:
                int selectedModel = modelTable.getSelectedRow();
                long modelId = (long) modelTable.getValueAt(selectedModel, 0);
                EditModel editModel = new EditModel(this, true, modelId);
                editModel.setVisible(true);
                List<Model> models = ModelDao.getModels();
                DefaultTableModel modelTblModel = (DefaultTableModel) modelTable.getModel();
                modelTblModel.setRowCount(0);
                models.forEach(model -> {
                    modelTblModel.addRow(new Object[]{model.getId(), model.getName(),
                        model.isAutomatic(), model.isCombustion(),
                        model.getBrand().getName()});
                });
                modelTable.setModel(modelTblModel);
                modelTable.setRowSelectionInterval(selectedModel, selectedModel);
                break;
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        switch (this.tabbedPaneContainer.getSelectedIndex()) {
            case 0:
                int selectedVehicle = vehicleTable.getSelectedRow();
                long vehicleId = (long) vehicleTable.getValueAt(selectedVehicle, 0);
                VehicleDao.deleteVehicle(vehicleId);
                List<Vehicle> vehicles = VehicleDao.getVehicles();
                DefaultTableModel vehicleTblModel = (DefaultTableModel) vehicleTable.getModel();
                vehicleTblModel.setRowCount(0);
                vehicles.forEach(vehicle -> {
                    vehicleTblModel.addRow(new Object[]{
                        vehicle.getId(), vehicle.getColor(), vehicle.getPrice(),
                        vehicle.getModel().getName(), vehicle.getBrand().getName()});
                });
                vehicleTable.setModel(vehicleTblModel);
                
                if (selectedVehicle - 1 < 0) {
                    selectedVehicle = 1;
                }
                
                vehicleTable.setRowSelectionInterval(selectedVehicle - 1, selectedVehicle - 1);
                break;
            case 1:
                int selectedBrand = brandTable.getSelectedRow();
                long brandId = (long) brandTable.getValueAt(selectedBrand, 0);
                BrandDao.deleteBrand(brandId);
                List<Brand> brands = BrandDao.getBrands();
                DefaultTableModel brandTblModel = (DefaultTableModel) brandTable.getModel();
                brandTblModel.setRowCount(0);
                brands.forEach(brand -> {
                    brandTblModel.addRow(new Object[]{brand.getId(), brand.getName()});
                });
                brandTable.setModel(brandTblModel);
                
                if (selectedBrand - 1 < 0) {
                    selectedBrand = 1;
                }
                
                brandTable.setRowSelectionInterval(selectedBrand - 1, selectedBrand - 1);
                break;
            case 2:
                int selectedModel = modelTable.getSelectedRow();
                long modelId = (long) modelTable.getValueAt(selectedModel, 0);
                ModelDao.deleteModel(modelId);
                List<Model> models = ModelDao.getModels();
                DefaultTableModel modelTblModel = (DefaultTableModel) modelTable.getModel();
                modelTblModel.setRowCount(0);
                models.forEach(model -> {
                    modelTblModel.addRow(new Object[]{model.getId(), model.getName(),
                        model.isAutomatic(), model.isCombustion(),
                        model.getBrand().getName()});
                });
                modelTable.setModel(modelTblModel);
                
                if (selectedModel - 1 < 0) {
                    selectedModel = 1;
                }               
                
                modelTable.setRowSelectionInterval(selectedModel - 1, selectedModel - 1);
                break;
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSairActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel brandPanel;
    private javax.swing.JTable brandTable;
    private javax.swing.JScrollPane brandTableScrollPane;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSair;
    private javax.swing.JPanel modelPanel;
    private javax.swing.JTable modelTable;
    private javax.swing.JScrollPane modelTableScrollPane;
    private javax.swing.JTabbedPane tabbedPaneContainer;
    private javax.swing.JPanel vehiclePanel;
    private javax.swing.JTable vehicleTable;
    private javax.swing.JScrollPane vehicleTableScrollPane;
    // End of variables declaration//GEN-END:variables
}
