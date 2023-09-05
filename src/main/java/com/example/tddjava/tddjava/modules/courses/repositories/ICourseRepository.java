package com.example.tddjava.tddjava.modules.courses.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tddjava.tddjava.modules.courses.entities.Course;

public interface ICourseRepository{
    
    public Course findByName(String name);
    public Course save(Course course);
}
