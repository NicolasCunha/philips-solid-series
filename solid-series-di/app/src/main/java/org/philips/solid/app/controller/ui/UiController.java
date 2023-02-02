package org.philips.solid.app.controller.ui;

import javax.swing.JFrame;
import javax.swing.JTable;

public abstract class UiController {

    public abstract void create(final JFrame parent);

    public abstract void update(final JFrame parent, final JTable table);

    public abstract void delete(final JTable table);

    public abstract void refreshData(final JTable table);

    public void selectRow(final JTable table, int row) {
        if (table.getRowCount() == 0) {
            return;
        }

        if (table.getRowCount() < row) {
            return;
        }
        
        table.setRowSelectionInterval(row, row);
    }

}
