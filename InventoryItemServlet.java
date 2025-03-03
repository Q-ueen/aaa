package com.zretc.servlet;

import com.zretc.pojo.InventoryItem;
import com.zretc.service.InventoryItemService;
import com.zretc.service.impl.InventoryItemServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/inventory")
public class InventoryItemServlet extends HttpServlet {
    private InventoryItemService inventoryItemService = new InventoryItemServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        System.out.println("dshdjahsdhashda--------doGet");
        String action = req.getParameter("action");
        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "list":
                listInventoryItems(req, resp);
                break;
            case "edit":
                showEditForm(req, resp);
                break;
            case "delete":
                deleteInventoryItem(req, resp);
                break;
            default:
                listInventoryItems(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "insert":
                insertInventoryItem(req, resp);
                break;
            case "update":
                updateInventoryItem(req, resp);
                break;
            default:
                listInventoryItems(req, resp);
                break;
        }
    }

    private void listInventoryItems(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<InventoryItem> list = inventoryItemService.getAllInventoryItems();
        System.out.println("listInventoryItems---------" + list);
        req.setAttribute("listInventoryItems", list);
        req.getRequestDispatcher("inventory-list.jsp").forward(req, resp);
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        InventoryItem existingItem = inventoryItemService.getInventoryItem(id);
        req.setAttribute("inventoryItem", existingItem);
        req.getRequestDispatcher("inventory-form.jsp").forward(req, resp);
    }

    private void insertInventoryItem(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        double price = Double.parseDouble(req.getParameter("price"));
        int category_id = Integer.parseInt(req.getParameter("category_id"));
        int supplier_id = Integer.parseInt(req.getParameter("supplier_id"));

        InventoryItem newItem = new InventoryItem();
        newItem.setName(name);
        newItem.setQuantity(quantity);
        newItem.setPrice(price);
        newItem.setCategory_id(category_id);
        newItem.setSupplier_id(supplier_id);

        inventoryItemService.addInventoryItem(newItem);
        resp.sendRedirect("inventory?action=list");
    }

    private void updateInventoryItem(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        double price = Double.parseDouble(req.getParameter("price"));
        int category_id = Integer.parseInt(req.getParameter("category_id"));
        int supplier_id = Integer.parseInt(req.getParameter("supplier_id"));

        InventoryItem item = new InventoryItem();
        item.setId(id);
        item.setName(name);
        item.setQuantity(quantity);
        item.setPrice(price);
        item.setCategory_id(category_id);
        item.setSupplier_id(supplier_id);

        inventoryItemService.updateInventoryItem(item);
        resp.sendRedirect("inventory?action=list");
    }

    private void deleteInventoryItem(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        inventoryItemService.deleteInventoryItem(id);
        resp.sendRedirect("inventory?action=list");
    }
}