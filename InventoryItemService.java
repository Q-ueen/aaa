package com.zretc.service;

import com.zretc.pojo.InventoryItem;

import java.util.List;

public interface InventoryItemService {
    void addInventoryItem(InventoryItem item);
    InventoryItem getInventoryItem(int id);
    List<InventoryItem> getAllInventoryItems();
    void updateInventoryItem(InventoryItem item);
    void deleteInventoryItem(int id);
}
