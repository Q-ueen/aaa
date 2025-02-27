package com.zretc.servlet;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.zretc.pojo.Supplier;
import com.zretc.service.SupplierService;
import com.zretc.service.impl.SupplierServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/supplier")
public class SupplierServlet extends HttpServlet {
    private SupplierService supplierService = new SupplierServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "list":
                listSuppliers(req, resp);
                break;
            case "edit":
                showEditForm(req, resp);
                break;
            case "delete":
                deleteSupplier(req, resp);
                break;
            default:
                listSuppliers(req, resp);
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
                insertSupplier(req, resp);
                break;
            case "update":
                updateSupplier(req, resp);
                break;
            default:
                listSuppliers(req, resp);
                break;
        }
    }

    private void listSuppliers(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Supplier> list = supplierService.getAllSuppliers();
        req.setAttribute("listSuppliers", list);
        req.getRequestDispatcher("supplier-list.jsp").forward(req, resp);
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Supplier existingSupplier = supplierService.getSupplier(id);
        req.setAttribute("supplier", existingSupplier);
        req.getRequestDispatcher("supplier-form.jsp").forward(req, resp);
    }

    private void insertSupplier(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String contact_info = req.getParameter("contact_info");

        Supplier newSupplier = new Supplier();
        newSupplier.setName(name);
        newSupplier.setContact_info(contact_info);

        supplierService.addSupplier(newSupplier);
        resp.sendRedirect("supplier?action=list");
    }

    private void updateSupplier(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String contact_info = req.getParameter("contact_info");

        Supplier supplier = new Supplier();
        supplier.setId(id);
        supplier.setName(name);
        supplier.setContact_info(contact_info);

        supplierService.updateSupplier(supplier);
        resp.sendRedirect("supplier?action=list");
    }

    private void deleteSupplier(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        supplierService.deleteSupplier(id);
        resp.sendRedirect("supplier?action=list");
    }
}