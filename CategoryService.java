package com.zretc.service;

import com.zretc.pojo.Category;

import java.util.List;

public interface CategoryService {
    void addCategory(Category category);
    Category getCategory(int id);
    List<Category> getAllCategories();
    void updateCategory(Category category);
    void deleteCategory(int id);
}