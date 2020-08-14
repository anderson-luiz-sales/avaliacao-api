package br.com.cast.avaliacao.controllers;

import br.com.cast.avaliacao.dtos.requests.CourseRequestDTO;
import br.com.cast.avaliacao.dtos.responses.CourseResponseDTO;
import br.com.cast.avaliacao.facades.CourseFacade;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cast/v1/courses")
@CrossOrigin(origins = "*")
@AllArgsConstructor(onConstructor = @_(@Autowired))
public class CourseController {

    private final CourseFacade courseFacade;

    @ApiOperation(value = "Post Courses v1")
    @PostMapping
    public ResponseEntity<CourseResponseDTO> create(@RequestBody CourseRequestDTO courseRequestDTO) {
        return new ResponseEntity<>(courseFacade.save(courseRequestDTO), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Get Course v1")
    @GetMapping
    public ResponseEntity<List<CourseResponseDTO>> list() {
        return new ResponseEntity<>(courseFacade.getCourses(), HttpStatus.OK);
    }

    @ApiOperation(value = "Get BY Id Course v1")
    @GetMapping("/{id}")
    public ResponseEntity<CourseResponseDTO> getById(@PathVariable String id) {
        return new ResponseEntity<>(courseFacade.findById(id), HttpStatus.OK);
    }

    @ApiOperation(value = "Put Course v1")
    @PutMapping
    public ResponseEntity<CourseResponseDTO> update(@RequestBody CourseRequestDTO courseRequestDTO) {
        return new ResponseEntity<>(courseFacade.update(courseRequestDTO), HttpStatus.OK);
    }

    @ApiOperation(value = "Delete Course v1")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        courseFacade.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}