package com.ateam.lacys.model;

/**
 * Created by Gary on 3/19/2015.
 */
public class ProductModel {

    private int id;
    private String brand;
    private String category_id;
    private String desc;
    private double price;
    private int inStock;
    private byte[] img;

    public ProductModel(){

    }

    public ProductModel(int id,String brand,String category_id,String desc,double price,int inStock,byte[] img){
        this.id = id;
        this.brand = brand;
        this.category_id = category_id;
        this.desc = desc;
        this.price = price;
        this.inStock = inStock;
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getInStock() {
        return inStock;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }
}
