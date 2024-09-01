package com.example.BackendCrud.repo;

import com.example.BackendCrud.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseDetailsRepo  extends JpaRepository<Course,Integer> {
}
