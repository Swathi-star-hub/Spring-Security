package com.example.BackendCrud.VO;

public class BasicDetailsVO {
    private Integer mebId;
    private String name;
    private Integer age;
    private CourseDetails courseDetails;



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

    public CourseDetails getCourseDetails() {
        return courseDetails;
    }

    public void setCourseDetails(CourseDetails courseDetails) {
        this.courseDetails = courseDetails;
    }

    public BasicDetailsVO(String name, Integer mebId, Integer age, CourseDetails courseDetails) {
        this.name = name;
        this.mebId = mebId;
        this.age = age;
        this.courseDetails = courseDetails;
    }
}
