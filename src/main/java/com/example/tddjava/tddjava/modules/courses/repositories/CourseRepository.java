package com.example.tddjava.tddjava.modules.courses.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tddjava.tddjava.modules.courses.entities.Course;

@Service
public class CourseRepository implements ICourseRepository{

    @Autowired
    CourseJpaRepository courseJpaRepository;

    @Override
    public Course findByName(String name) {
        return this.courseJpaRepository.findByName(name);
    }

    @Override
    public Course save(Course course) {
        return this.courseJpaRepository.save(course);
    }
    
    
}
