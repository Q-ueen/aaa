package com.zretc.dao;

import com.zretc.pojo.InventoryItem;

import java.util.List;

public interface InventoryItemDAO {
    void addInventoryItem(InventoryItem item);
    InventoryItem getInventoryItem(int id);
    List<InventoryItem> getAllInventoryItems();
    void updateInventoryItem(InventoryItem item);
    void deleteInventoryItem(int id);
}