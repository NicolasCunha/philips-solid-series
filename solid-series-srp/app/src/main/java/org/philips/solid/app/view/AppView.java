package org.philips.solid.app.view;

import javax.swing.JTabbedPane;
import org.philips.solid.app.controller.ui.BrandUiController;
import org.philips.solid.app.controller.ui.ModelUiController;
import org.philips.solid.app.controller.ui.UiController;
import org.philips.solid.app.controller.ui.VehicleUiController;

public class AppView extends javax.swing.JFrame {

    private UiController vehicleUiController;
    private UiController brandUiController;
    private UiController modelUiController;
    
    public AppView() {
        initComponents();
        this.createUiControllers();
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
                this.vehicleUiController.create();
                this.vehicleUiController.refreshData();
                break;
            case 1:
                this.brandUiController.create();
                this.brandUiController.refreshData();
                break;
            case 2:
                this.modelUiController.create();
                this.modelUiController.refreshData();
                break;
        }
    }//GEN-LAST:event_btnNovoActionPerformed

    private void tabbedPaneContainerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tabbedPaneContainerStateChanged
        if (!areControllerCreated()) {
            createUiControllers();
        }
        
        final JTabbedPane pane = (JTabbedPane) evt.getSource();
        switch (pane.getSelectedIndex()) {
            case 0:
                this.vehicleUiController.refreshData();
                break;
            case 1:
                this.brandUiController.refreshData();
                break;
            case 2:
                this.modelUiController.refreshData();
                break;
        }
    }//GEN-LAST:event_tabbedPaneContainerStateChanged

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        switch (this.tabbedPaneContainer.getSelectedIndex()) {
            case 0:
                this.vehicleUiController.update();
                break;
            case 1:
                this.brandUiController.update();                
                break;
            case 2:
                this.modelUiController.update();                
                break;
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        switch (this.tabbedPaneContainer.getSelectedIndex()) {
            case 0:
                this.vehicleUiController.delete();                
                break;
            case 1:
                this.brandUiController.delete();                
                break;
            case 2:
                this.modelUiController.delete();
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

    private void createUiControllers() {
        this.vehicleUiController = new VehicleUiController(this, vehicleTable);
        this.brandUiController = new BrandUiController(this, brandTable);
        this.modelUiController = new ModelUiController(this, modelTable);
    }
    
    private boolean areControllerCreated() {
        return vehicleUiController != null
                && brandUiController != null
                && modelUiController != null;
    }
}
