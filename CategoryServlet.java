package com.zretc.servlet;

import com.zretc.pojo.Category;
import com.zretc.service.CategoryService;
import com.zretc.service.impl.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/category")
public class CategoryServlet extends HttpServlet {
    private CategoryService categoryService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "list":
                listCategories(req, resp);
                break;
            case "edit":
                showEditForm(req, resp);
                break;
            case "delete":
                deleteCategory(req, resp);
                break;
            default:
                listCategories(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "insert":
                insertCategory(req, resp);
                break;
            case "update":
                updateCategory(req, resp);
                break;
            default:
                listCategories(req, resp);
                break;
        }
    }

    private void listCategories(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> list = categoryService.getAllCategories();
        req.setAttribute("listCategories", list);
        req.getRequestDispatcher("category-list.jsp").forward(req, resp);
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Category existingCategory = categoryService.getCategory(id);
        req.setAttribute("category", existingCategory);
        req.getRequestDispatcher("category-form.jsp").forward(req, resp);
    }

    private void insertCategory(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");

        Category newCategory = new Category();
        newCategory.setName(name);

        categoryService.addCategory(newCategory);
        resp.sendRedirect("category?action=list");
    }

    private void updateCategory(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");

        Category category = new Category();
        category.setId(id);
        category.setName(name);

        categoryService.updateCategory(category);
        resp.sendRedirect("category?action=list");
    }

    private void deleteCategory(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        categoryService.deleteCategory(id);
        resp.sendRedirect("category?action=list");
    }
}