package com.example.BackendCrud.entity;

import jakarta.persistence.*;

@Entity(name ="FamilyDtls" )
@Table(name = "family_dtls")

public class FamilyDtls {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "seq_id")
    @Column(name = "meb_id", unique = true,
            nullable = false)
    private Integer mebId;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "cid")
    private Course course;

    public Integer getMebId() {
        return mebId;
    }

    public void setMebId(Integer mebId) {
        this.mebId = mebId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "FamilyDtls [mebId=" + mebId + ", name=" + name + ", age=" + age + ", course=" + course + "]";
    }
}

