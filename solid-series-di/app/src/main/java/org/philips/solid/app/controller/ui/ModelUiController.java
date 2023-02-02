package org.philips.solid.app.controller.ui;

import java.util.List;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.philips.solid.app.controller.dao.ModelDao;
import org.philips.solid.app.model.Model;
import org.philips.solid.app.view.CreateModel;
import org.philips.solid.app.view.EditModel;

public class ModelUiController extends UiController {

    @Override
    public void create(final JFrame parent) {
        CreateModel createModel = new CreateModel(parent, true);
        createModel.setVisible(true);
    }

    @Override
    public void update(final JFrame parent, final JTable table) {
        int selectedModel = table.getSelectedRow();
        long modelId = (long) table.getValueAt(selectedModel, 0);
        EditModel editModel = new EditModel(parent, true, modelId);
        editModel.setVisible(true);
        this.refreshData(table);
        this.selectRow(table, selectedModel);
    }

    @Override
    public void delete(final JTable table) {
        int selectedModel = table.getSelectedRow();
        long modelId = (long) table.getValueAt(selectedModel, 0);
        ModelDao.deleteModel(modelId);
        this.refreshData(table);

        if (selectedModel - 1 < 0) {
            selectedModel = 1;
        }

        selectRow(table, selectedModel - 1);
    }

    @Override
    public void refreshData(final JTable table) {
        List<Model> models = ModelDao.getModels();
        DefaultTableModel modelTblModel = (DefaultTableModel) table.getModel();
        modelTblModel.setRowCount(0);
        models.forEach(model -> {
            modelTblModel.addRow(new Object[]{model.getId(), model.getName(),
                model.isAutomatic(), model.isCombustion(),
                model.getBrand().getName()});
        });
        table.setModel(modelTblModel);
    }

}
