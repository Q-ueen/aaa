package com.zretc.dao;

import com.zretc.pojo.Category;

import java.util.List;

public interface CategoryDAO {
    void addCategory(Category category);
    Category getCategory(int id);
    List<Category> getAllCategories();
    void updateCategory(Category category);
    void deleteCategory(int id);
}