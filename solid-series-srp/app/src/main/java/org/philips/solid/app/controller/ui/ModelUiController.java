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

    public ModelUiController(JFrame parent, JTable table) {
        super(parent, table);
    }

    @Override
    public void create() {
        CreateModel createModel = new CreateModel(this.getParent(), true);
        createModel.setVisible(true);
    }

    @Override
    public void update() {
        int selectedModel = this.getTable().getSelectedRow();
        long modelId = (long) this.getTable().getValueAt(selectedModel, 0);
        EditModel editModel = new EditModel(this.getParent(), true, modelId);
        editModel.setVisible(true);
        this.refreshData();
        this.selectRow(selectedModel);
    }

    @Override
    public void delete() {
        int selectedModel = this.getTable().getSelectedRow();
        long modelId = (long) this.getTable().getValueAt(selectedModel, 0);
        ModelDao.deleteModel(modelId);
        this.refreshData();

        if (selectedModel - 1 < 0) {
            selectedModel = 1;
        }

        this.selectRow(selectedModel - 1);
    }

    @Override
    public void refreshData() {
        List<Model> models = ModelDao.getModels();
        DefaultTableModel modelTblModel = (DefaultTableModel) this.getTable().getModel();
        modelTblModel.setRowCount(0);
        models.forEach(model -> {
            modelTblModel.addRow(new Object[]{model.getId(), model.getName(),
                model.isAutomatic(), model.isCombustion(),
                model.getBrand().getName()});
        });
        this.getTable().setModel(modelTblModel);
    }

}
