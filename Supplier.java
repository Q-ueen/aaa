package com.zretc.pojo;

public class Supplier {
    private int id;
    private String name;
    private String contact_info;

    public Supplier() {}

    public Supplier(int id, String name, String contact_info) {
        this.id = id;
        this.name = name;
        this.contact_info = contact_info;
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

    public String getContact_info() {
        return contact_info;
    }

    public void setContact_info(String contact_info) {
        this.contact_info = contact_info;
    }
}
