package br.com.cast.avaliacao.services;

import br.com.cast.avaliacao.entities.Course;

import java.util.List;

public interface CourseService {

    Course save(Course course);
    List<Course> getCourse();
    Course findById(String id);
    void deleteById(String id);
}
