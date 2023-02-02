package org.philips.solid.app.controller.ui;

import javax.swing.JFrame;
import javax.swing.JTable;

public abstract class UiController {

    private final JFrame parent;
    private final JTable table;

    public UiController(JFrame parent, JTable table) {
        this.parent = parent;
        this.table = table;
    }

    public abstract void create();

    public abstract void update();

    public abstract void delete();

    public abstract void refreshData();

    public void selectRow(int row) {
        if (this.getTable().getRowCount() == 0) {
            return;
        }

        if (this.getTable().getRowCount() < row) {
            return;
        }
        
        this.getTable().setRowSelectionInterval(row, row);
    }

    public JFrame getParent() {
        return parent;
    }

    public JTable getTable() {
        return table;
    }

}
