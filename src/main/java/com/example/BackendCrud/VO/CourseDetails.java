package com.example.BackendCrud.VO;

public class CourseDetails {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //private Integer cid;
    private String name;
    private double price;

    public CourseDetails(String name, double price) {
        this.name = name;
        this.price = price;
    }
}
