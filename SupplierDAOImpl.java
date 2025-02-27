package com.zretc.dao.impl;

import com.zretc.dao.SupplierDAO;
import com.zretc.pojo.Supplier;
import com.zretc.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// dao 层，数据访问层，增删改查
public class SupplierDAOImpl implements SupplierDAO {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    @Override
    public void addSupplier(Supplier supplier) {
        try {
            conn = DBUtil.getConn();
            ps = conn.prepareStatement("INSERT INTO suppliers (name, contact_info) VALUES (?, ?)");
            ps.setString(1, supplier.getName());
            ps.setString(2, supplier.getContact_info());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.closeAll(rs, ps, conn);
        }
    }

    @Override
    public Supplier getSupplier(int id) {
        try {
            conn = DBUtil.getConn();
            ps = conn.prepareStatement("SELECT * FROM suppliers WHERE id = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Supplier(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("contact_info")
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
    public List<Supplier> getAllSuppliers() {
        List<Supplier> suppliers = new ArrayList<>();
        try {
            conn = DBUtil.getConn();
            ps = conn.prepareStatement("SELECT * FROM suppliers");
            rs = ps.executeQuery();
            while (rs.next()) {
                suppliers.add(new Supplier(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("contact_info")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.closeAll(rs, ps, conn);
        }
        return suppliers;
    }

    @Override
    public void updateSupplier(Supplier supplier) {
        try {
            conn = DBUtil.getConn();
            ps = conn.prepareStatement("UPDATE suppliers SET name = ?, contact_info = ? WHERE id = ?");
            ps.setString(1, supplier.getName());
            ps.setString(2, supplier.getContact_info());
            ps.setInt(3, supplier.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.closeAll(rs, ps, conn);
        }
    }

    @Override
    public void deleteSupplier(int id) {
        try {
            conn = DBUtil.getConn();
            ps = conn.prepareStatement("DELETE FROM suppliers WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.closeAll(rs, ps, conn);
        }
    }
}