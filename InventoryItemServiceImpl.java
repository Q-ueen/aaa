package com.zretc.service.impl;

import com.zretc.dao.InventoryItemDAO;
import com.zretc.dao.impl.InventoryItemDAOImpl;
import com.zretc.pojo.InventoryItem;
import com.zretc.service.InventoryItemService;

import java.util.List;

public class InventoryItemServiceImpl implements InventoryItemService {
    private InventoryItemDAO inventoryItemDAO = new InventoryItemDAOImpl();

    @Override
    public void addInventoryItem(InventoryItem item) {
        inventoryItemDAO.addInventoryItem(item);
    }

    @Override
    public InventoryItem getInventoryItem(int id) {
        return inventoryItemDAO.getInventoryItem(id);
    }

    @Override
    public List<InventoryItem> getAllInventoryItems() {
        return inventoryItemDAO.getAllInventoryItems();
    }

    @Override
    public void updateInventoryItem(InventoryItem item) {
        inventoryItemDAO.updateInventoryItem(item);
    }

    @Override
    public void deleteInventoryItem(int id) {
        inventoryItemDAO.deleteInventoryItem(id);
    }
}