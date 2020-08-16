package br.com.cast.avaliacao.services.impl;

import br.com.cast.avaliacao.entities.Course;
import br.com.cast.avaliacao.exceptions.NotFoundException;
import br.com.cast.avaliacao.repositories.CourseRepository;
import br.com.cast.avaliacao.services.CourseService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor(onConstructor = @_(@Autowired))
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Override
    public Course save(Course course) {
        log.info("[CourseServiceImpl.save] - course: {}", course);
        return courseRepository.save(course);
    }

    @Override
    public List<Course> getCourse() {
        log.info("[CourseServiceImpl.findAll]");
        return courseRepository.findAll();
    }

    @Override
    public Course findById(String id) {
        log.info("[CourseServiceImpl.findById] - id: {}");

        if(courseRepository.findByid(id) == null) {
            throw new NotFoundException("Not found for id:" + id);
        }
        return courseRepository.findByid(id);
    }

    @Override
    public void deleteById(String id) {
        log.info("CourseServiceImpl.deleteById - id: {}", id);
        courseRepository.deleteById(id);
    }
}
