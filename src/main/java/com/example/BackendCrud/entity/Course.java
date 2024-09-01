package com.example.BackendCrud.entity;


import jakarta.persistence.*;
import org.hibernate.annotations.Proxy;

@Entity(name ="Course" )
@Table(name = "course_dtls")
//@Proxy(lazy = false)
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "seq_id")
    @Column(name = "cid", unique = true,
            nullable = false)
    private Integer cid;
    private String name;
    private double price;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

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
}
