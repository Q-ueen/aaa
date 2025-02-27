package com.zretc.service.impl;

import com.zretc.dao.CategoryDAO;
import com.zretc.dao.impl.CategoryDAOImpl;
import com.zretc.pojo.Category;
import com.zretc.service.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    private CategoryDAO categoryDAO = new CategoryDAOImpl();

    @Override
    public void addCategory(Category category) {
        categoryDAO.addCategory(category);
    }

    @Override
    public Category getCategory(int id) {
        return categoryDAO.getCategory(id);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryDAO.getAllCategories();
    }

    @Override
    public void updateCategory(Category category) {
        categoryDAO.updateCategory(category);
    }

    @Override
    public void deleteCategory(int id) {
        categoryDAO.deleteCategory(id);
    }
}