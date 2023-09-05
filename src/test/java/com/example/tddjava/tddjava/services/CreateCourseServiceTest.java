package com.example.tddjava.tddjava.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.example.tddjava.tddjava.modules.courses.entities.Course;
import com.example.tddjava.tddjava.modules.courses.repositories.CourseInMemoryRepository;
import com.example.tddjava.tddjava.modules.courses.services.CreateCourseService;

public class CreateCourseServiceTest {
    
    @Test
    public void should_be_able_to_create_a_new_course(){
        // criar um novo curso
        // criar table curso (entidate)
        // Id, descripition, name, workload
        Course course = new Course();
        course.setDescription("curso_description_test");
        course.setName("Curso_name");
        course.setWorkload(100);
        // criar repository de curso
        CourseInMemoryRepository repository = new CourseInMemoryRepository();
        // criar um novo service
        CreateCourseService createCourseService = new CreateCourseService(repository);
        Course createdCourse = createCourseService.execute(course);
        assertNotNull(createdCourse.getId());

    }

    @Test(expected = Error.class)
    public void should_not_be_able_to_create_a_new_course_if_exists(){
        Course course = new Course();
        course.setDescription("Not_create_course");
        course.setName("Not_create_course");
        course.setWorkload(100);
        CourseInMemoryRepository repository = new CourseInMemoryRepository();
        // criar um novo service
        CreateCourseService createCourseService = new CreateCourseService(repository);
        createCourseService.execute(course);
        createCourseService.execute(course);
    }

}
