package org.philips.solid.app.view;

import org.philips.solid.app.controller.dao.ModelDao;
import org.philips.solid.app.controller.dao.VehicleDao;
import org.philips.solid.app.model.Model;
import org.philips.solid.app.model.Vehicle;
import org.philips.solid.app.util.UserInterfaceUtils;

public class EditVehicle extends javax.swing.JDialog {

    private final long vehicleId;
    
    public EditVehicle(java.awt.Frame parent, boolean modal, long vehicleId) {
        super(parent, modal);
        this.vehicleId = vehicleId;
        this.setTitle("Editar veículo");
        this.setResizable(false);
        this.setLocationRelativeTo(parent);
        initComponents();
        loadModels();
        loadVehicleInformation();
    }
    
    private void loadModels() {
        this.fieldId.setEnabled(false);
        this.fieldBrand.setEnabled(false);
        ModelDao.getModels().forEach(model -> {
            final String modelVal = model.getId() + " - " + model.getName();
            this.comboModel.addItem(modelVal);
        });
    }
    
    private void loadVehicleInformation() {
        final Vehicle vehicle = VehicleDao.getVehicle(vehicleId);
        this.fieldId.setEnabled(false);
        this.fieldId.setText(String.valueOf(vehicle.getId()));
        this.fieldColor.setText(vehicle.getColor());
        this.fieldPrice.setText(String.valueOf(vehicle.getPrice()));
        final String currentModel = vehicle.getModel().getId() + " - " + vehicle.getModel().getName();
        this.comboModel.setSelectedItem(currentModel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelId = new javax.swing.JLabel();
        fieldId = new javax.swing.JTextField();
        labelColor = new javax.swing.JLabel();
        fieldColor = new javax.swing.JTextField();
        labelPrice = new javax.swing.JLabel();
        fieldPrice = new javax.swing.JTextField();
        labelModelBrand = new javax.swing.JLabel();
        fieldBrand = new javax.swing.JTextField();
        comboModel = new javax.swing.JComboBox<>();
        btnCancel = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        labelId.setText("ID:");

        labelColor.setText("Cor:");

        labelPrice.setText("Preço:");

        labelModelBrand.setText("Modelo / Marca:");

        comboModel.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboModelItemStateChanged(evt);
            }
        });

        btnCancel.setText("Cancelar");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnSave.setText("Salvar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelPrice)
                            .addComponent(labelId)
                            .addComponent(labelColor))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fieldColor, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldId, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelModelBrand)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboModel, 0, 130, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelId, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelColor, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelModelBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldBrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnCancel))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboModelItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboModelItemStateChanged
        final long id = UserInterfaceUtils.getValueFromKeyValueComboBox(this.comboModel);
        final Model model = ModelDao.getModel(id);
        this.fieldBrand.setText(model.getBrand().getName());
    }//GEN-LAST:event_comboModelItemStateChanged

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        final String color = this.fieldColor.getText().trim();
        final Double price = Double.valueOf(this.fieldPrice.getText().trim());
        final long modelId = UserInterfaceUtils.getValueFromKeyValueComboBox(this.comboModel);
        VehicleDao.updateVehicle(vehicleId, color, price, modelId);
        this.setVisible(false);
    }//GEN-LAST:event_btnSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> comboModel;
    private javax.swing.JTextField fieldBrand;
    private javax.swing.JTextField fieldColor;
    private javax.swing.JTextField fieldId;
    private javax.swing.JTextField fieldPrice;
    private javax.swing.JLabel labelColor;
    private javax.swing.JLabel labelId;
    private javax.swing.JLabel labelModelBrand;
    private javax.swing.JLabel labelPrice;
    // End of variables declaration//GEN-END:variables
}
