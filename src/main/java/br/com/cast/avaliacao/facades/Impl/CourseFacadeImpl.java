package br.com.cast.avaliacao.facades.Impl;

import br.com.cast.avaliacao.dtos.requests.CourseRequestDTO;
import br.com.cast.avaliacao.dtos.responses.CourseResponseDTO;
import br.com.cast.avaliacao.entities.Course;
import br.com.cast.avaliacao.facades.CourseFacade;
import br.com.cast.avaliacao.services.CourseService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor(onConstructor = @_(@Autowired))
public class CourseFacadeImpl implements CourseFacade {

    private final CourseService courseService;

    private final ModelMapper modelMapper;

    @Override
    public CourseResponseDTO save(CourseRequestDTO courseRequestDTO) {
        return converteToDTO(courseService.save(convertToEntity(courseRequestDTO)));
    }

    @Override
    public List<CourseResponseDTO> getCourses() {
        List<CourseResponseDTO> courseList = new ArrayList<>();

        for (Course course : courseService.getCourse()) {
            courseList.add(converteToDTO(course));
        }
        return courseList;
    }

    @Override
    public CourseResponseDTO findById(String id) {
        return converteToDTO(courseService.findById(id));
    }

    @Override
    public CourseResponseDTO update(CourseRequestDTO courseRequestDTO) {
        return converteToDTO(courseService.save(convertToEntity(courseRequestDTO)));
    }

    @Override
    public void deleteById(String id) {
        courseService.deleteById(id);
    }

    private Course convertToEntity(CourseRequestDTO courseResponseDTO) {
        return modelMapper.map(courseResponseDTO, Course.class);
    }

    private CourseResponseDTO converteToDTO(Course course) {
        return modelMapper.map(course, CourseResponseDTO.class);
    }
}
