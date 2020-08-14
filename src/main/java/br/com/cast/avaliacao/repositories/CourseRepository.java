package br.com.cast.avaliacao.repositories;

import br.com.cast.avaliacao.entities.Course;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CourseRepository extends MongoRepository<Course, String> {

    Course findByid(String id);
}
