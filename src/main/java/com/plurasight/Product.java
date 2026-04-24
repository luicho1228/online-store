package com.plurasight;

public class Product {
    private int id;
    private String name;
    private double price;
    private String department;

    public Product(int id,String name,double price,String department){
        this.id = id;
        this.name = name;
        this.price = price;
        this.department = department;
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

    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return id + "|" + name + "|" + price + "|" +department;
    }
}
