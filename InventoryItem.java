package com.zretc.pojo;

public class InventoryItem {
    private int id;
    private String name;
    private int quantity;
    private double price;
    private int category_id;
    private int supplier_id;

    public InventoryItem() {}

    public InventoryItem(int id, String name, int quantity, double price, int category_id, int supplier_id) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.category_id = category_id;
        this.supplier_id = supplier_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(int supplier_id) {
        this.supplier_id = supplier_id;
    }
}