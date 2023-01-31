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

    public BrandUiController(JFrame parent, JTable table) {
        super(parent, table);
    }

    @Override
    public void create() {
        CreateBrand createBrand = new CreateBrand(this.getParent(), true);
        createBrand.setVisible(true);
    }

    @Override
    public void update() {
        int selectedBrand = this.getTable().getSelectedRow();
        long brandId = (long) this.getTable().getValueAt(selectedBrand, 0);
        EditBrand editBrand = new EditBrand(this.getParent(), true, brandId);
        editBrand.setVisible(true);
        this.refreshData();
        this.selectRow(selectedBrand);
    }

    @Override
    public void delete() {
        int selectedBrand = this.getTable().getSelectedRow();
        long brandId = (long) this.getTable().getValueAt(selectedBrand, 0);
        BrandDao.deleteBrand(brandId);
        this.refreshData();
        
        if (selectedBrand - 1 < 0) {
            selectedBrand = 1;
        }

        this.selectRow(selectedBrand - 1);
    }

    @Override
    public void refreshData() {
        List<Brand> brands = BrandDao.getBrands();
        DefaultTableModel brandTblModel = (DefaultTableModel) this.getTable().getModel();
        brandTblModel.setRowCount(0);
        brands.forEach(brand -> {
            brandTblModel.addRow(new Object[]{brand.getId(), brand.getName()});
        });
        this.getTable().setModel(brandTblModel);
    }

}
