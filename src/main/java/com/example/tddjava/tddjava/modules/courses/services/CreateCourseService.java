package com.example.tddjava.tddjava.modules.courses.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tddjava.tddjava.modules.courses.entities.Course;
import com.example.tddjava.tddjava.modules.courses.repositories.ICourseRepository;

@Service
public class CreateCourseService {
    
    // @Autowired
    // private CourseRepository repository; // para funcionar é preciso rodar a aplicacao
    private ICourseRepository repository;

    public CreateCourseService(ICourseRepository repository){
        this.repository = repository;
    }

    public Course execute(Course course){

        // validar se curso existe
        Course existedCourse = repository.findByName(course.getName());
        if(existedCourse != null){
            throw new Error("O curso ja existe no DB!");
        }
        return repository.save(course);
        //se sim retorna erro
        //se nao retorna novo curso
    }
}
