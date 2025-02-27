package com.zretc.service;

import com.zretc.pojo.Supplier;

import java.util.List;

public interface SupplierService {
    void addSupplier(Supplier supplier);
    Supplier getSupplier(int id);
    List<Supplier> getAllSuppliers();
    void updateSupplier(Supplier supplier);
    void deleteSupplier(int id);
}