package iuh.fit.nguyenngochongminh_tuan04_bai3.model;

import java.io.Serializable;

public class Product implements Serializable {
    private int id;
    private String model;
    private String description;
    private Integer quantity;
    private double price;

    public Product() {
    }

    public Product(int id, String model, String description, Integer quantity, double price) {
        this.id = id;
        this.model = model;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
