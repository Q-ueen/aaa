package com.zretc.dao.impl;

import com.zretc.dao.InventoryItemDAO;
import com.zretc.pojo.InventoryItem;
import com.zretc.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// dao 层，数据访问层，增删改查
public class InventoryItemDAOImpl implements InventoryItemDAO {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    @Override
    public void addInventoryItem(InventoryItem item) {
        try {
            conn = DBUtil.getConn();
            ps = conn.prepareStatement("INSERT INTO inventory_items (name, quantity, price, category_id, supplier_id) VALUES (?, ?, ?, ?, ?)");
            ps.setString(1, item.getName());
            ps.setInt(2, item.getQuantity());
            ps.setDouble(3, item.getPrice());
            ps.setInt(4, item.getCategory_id());
            ps.setInt(5, item.getSupplier_id());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.closeAll(rs, ps, conn);
        }
    }

    @Override
    public InventoryItem getInventoryItem(int id) {
        try {
            conn = DBUtil.getConn();
            ps = conn.prepareStatement("SELECT * FROM inventory_items WHERE id = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new InventoryItem(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("quantity"),
                        rs.getDouble("price"),
                        rs.getInt("category_id"),
                        rs.getInt("supplier_id")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.closeAll(rs, ps, conn);
        }
        return null;
    }

    @Override
    public List<InventoryItem> getAllInventoryItems() {
        List<InventoryItem> items = new ArrayList<>();
        try {
            conn = DBUtil.getConn();
            ps = conn.prepareStatement("SELECT * FROM inventory_items");
            rs = ps.executeQuery();
            while (rs.next()) {
                items.add(new InventoryItem(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("quantity"),
                        rs.getDouble("price"),
                        rs.getInt("category_id"),
                        rs.getInt("supplier_id")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.closeAll(rs, ps, conn);
        }
        return items;
    }

    @Override
    public void updateInventoryItem(InventoryItem item) {
        try {
            conn = DBUtil.getConn();
            ps = conn.prepareStatement("UPDATE inventory_items SET name = ?, quantity = ?, price = ?, category_id = ?, supplier_id = ? WHERE id = ?");
            ps.setString(1, item.getName());
            ps.setInt(2, item.getQuantity());
            ps.setDouble(3, item.getPrice());
            ps.setInt(4, item.getCategory_id());
            ps.setInt(5, item.getSupplier_id());
            ps.setInt(6, item.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.closeAll(rs, ps, conn);
        }
    }

    @Override
    public void deleteInventoryItem(int id) {
        try {
            conn = DBUtil.getConn();
            ps = conn.prepareStatement("DELETE FROM inventory_items WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.closeAll(rs, ps, conn);
        }
    }
}