package com.pcbuilder.models;

/**
 * Abstract base class cho tất cả các linh kiện máy tính
 * Áp dụng nguyên tắc OOP: Abstraction và Encapsulation
 */
public abstract class Component {
    protected int id;
    protected String name;
    protected String manufacturer;
    protected double price;
    protected String specifications;

    public Component(int id, String name, String manufacturer, double price, String specifications) {
        this.id = id;
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
        this.specifications = specifications;
    }

    // Getters and Setters
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

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    // Abstract method để hiển thị thông tin chi tiết
    public abstract String getDetails();

    @Override
    public String toString() {
        return name + " - " + manufacturer + " (" + String.format("%,.0f", price) + " VNĐ)";
    }
}
