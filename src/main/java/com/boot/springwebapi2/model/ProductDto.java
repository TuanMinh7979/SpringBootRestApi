package com.boot.springwebapi2.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ProductDto {
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public ProductDto(String name, int price, Date created, int categoryId) {

        this.name = name;
        this.price = price;
        this.created = created;
        this.categoryId = categoryId;
    }

    private int id;
    private String name;
    private int price;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date created;

    private int categoryId;

    public ProductDto() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public String toString() {
        return "ProductInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", created= "+created+
                '}';
    }
}
