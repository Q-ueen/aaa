package com.zretc.dao;

import com.zretc.pojo.Supplier;

import java.util.List;

public interface SupplierDAO {
    void addSupplier(Supplier supplier);
    Supplier getSupplier(int id);
    List<Supplier> getAllSuppliers();
    void updateSupplier(Supplier supplier);
    void deleteSupplier(int id);
}