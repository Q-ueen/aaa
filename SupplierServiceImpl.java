package com.zretc.service.impl;

import com.zretc.dao.SupplierDAO;
import com.zretc.dao.impl.SupplierDAOImpl;
import com.zretc.pojo.Supplier;
import com.zretc.service.SupplierService;

import java.util.List;

public class SupplierServiceImpl implements SupplierService {
    private SupplierDAO supplierDAO = new SupplierDAOImpl();

    @Override
    public void addSupplier(Supplier supplier) {
        supplierDAO.addSupplier(supplier);
    }

    @Override
    public Supplier getSupplier(int id) {
        return supplierDAO.getSupplier(id);
    }

    @Override
    public List<Supplier> getAllSuppliers() {
        return supplierDAO.getAllSuppliers();
    }

    @Override
    public void updateSupplier(Supplier supplier) {
        supplierDAO.updateSupplier(supplier);
    }

    @Override
    public void deleteSupplier(int id) {
        supplierDAO.deleteSupplier(id);
    }
}
