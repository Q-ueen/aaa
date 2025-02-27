package com.zretc.dao.impl;

import com.zretc.dao.CategoryDAO;
import com.zretc.pojo.Category;
import com.zretc.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// dao 层，数据访问层，增删改查
public class CategoryDAOImpl implements CategoryDAO {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    @Override
    public void addCategory(Category category) {
        try {
            conn = DBUtil.getConn();
            ps = conn.prepareStatement("INSERT INTO categories (name) VALUES (?)");
            ps.setString(1, category.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.closeAll(rs, ps, conn);
        }
    }

    @Override
    public Category getCategory(int id) {
        try {
            conn = DBUtil.getConn();
            ps = conn.prepareStatement("SELECT * FROM categories WHERE id = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Category(
                        rs.getInt("id"),
                        rs.getString("name")
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
    public List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<>();
        try {
            conn = DBUtil.getConn();
            ps = conn.prepareStatement("SELECT * FROM categories");
            rs = ps.executeQuery();
            while (rs.next()) {
                categories.add(new Category(
                        rs.getInt("id"),
                        rs.getString("name")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.closeAll(rs, ps, conn);
        }
        return categories;
    }

    @Override
    public void updateCategory(Category category) {
        try {
            conn = DBUtil.getConn();
            ps = conn.prepareStatement("UPDATE categories SET name = ? WHERE id = ?");
            ps.setString(1, category.getName());
            ps.setInt(2, category.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.closeAll(rs, ps, conn);
        }
    }

    @Override
    public void deleteCategory(int id) {
        try {
            conn = DBUtil.getConn();
            ps = conn.prepareStatement("DELETE FROM categories WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.closeAll(rs, ps, conn);
        }
    }
}