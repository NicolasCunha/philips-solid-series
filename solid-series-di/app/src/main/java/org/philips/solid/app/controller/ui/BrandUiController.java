package org.philips.solid.app.controller.ui;

import java.util.List;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.philips.solid.app.controller.dao.BrandDao;
import org.philips.solid.app.model.Brand;
import org.philips.solid.app.view.CreateBrand;
import org.philips.solid.app.view.EditBrand;

public class BrandUiController extends UiController {

    @Override
    public void create(final JFrame parent) {
        CreateBrand createBrand = new CreateBrand(parent, true);
        createBrand.setVisible(true);
    }

    @Override
    public void update(final JFrame parent, final JTable table) {
        int selectedBrand = table.getSelectedRow();
        long brandId = (long) table.getValueAt(selectedBrand, 0);
        EditBrand editBrand = new EditBrand(parent, true, brandId);
        editBrand.setVisible(true);
        this.refreshData(table);
        this.selectRow(table, selectedBrand);
    }

    @Override
    public void delete(final JTable table) {
        int selectedBrand = table.getSelectedRow();
        long brandId = (long) table.getValueAt(selectedBrand, 0);
        BrandDao.deleteBrand(brandId);
        this.refreshData(table);
        
        if (selectedBrand - 1 < 0) {
            selectedBrand = 1;
        }

        this.selectRow(table, selectedBrand - 1);
    }

    @Override
    public void refreshData(final JTable table) {
        List<Brand> brands = BrandDao.getBrands();
        DefaultTableModel brandTblModel = (DefaultTableModel) table.getModel();
        brandTblModel.setRowCount(0);
        brands.forEach(brand -> {
            brandTblModel.addRow(new Object[]{brand.getId(), brand.getName()});
        });
        table.setModel(brandTblModel);
    }

}
