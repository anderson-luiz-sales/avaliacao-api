package br.com.cast.avaliacao.facades;

import br.com.cast.avaliacao.dtos.requests.CourseRequestDTO;
import br.com.cast.avaliacao.dtos.responses.CourseResponseDTO;

import java.util.List;

public interface CourseFacade {

    CourseResponseDTO save(CourseRequestDTO courseRequestDTO);
    List<CourseResponseDTO> getCourses();
    CourseResponseDTO findById(String id);
    CourseResponseDTO update(CourseRequestDTO courseRequestDTO);
    void deleteById(String id);
}
