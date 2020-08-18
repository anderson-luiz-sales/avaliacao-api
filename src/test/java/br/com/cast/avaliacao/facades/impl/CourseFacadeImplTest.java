package br.com.cast.avaliacao.facades.impl;

import br.com.cast.avaliacao.dtos.requests.CategoryRequestDTO;
import br.com.cast.avaliacao.dtos.requests.CourseRequestDTO;
import br.com.cast.avaliacao.dtos.responses.CourseResponseDTO;
import br.com.cast.avaliacao.entities.Category;
import br.com.cast.avaliacao.entities.Course;
import br.com.cast.avaliacao.facades.Impl.CourseFacadeImpl;
import br.com.cast.avaliacao.services.CourseService;
import br.com.cast.avaliacao.services.impl.CourseServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


@SpringBootTest
@RunWith(SpringRunner.class)
public class CourseFacadeImplTest {

    @InjectMocks
    private CourseFacadeImpl courseFacade;

    @Mock
    private CourseServiceImpl courseService;

    @Mock
    private ModelMapper modelMapper;

    private static final String ID = "01";
    private static final String SUBJECT_DESCRIPTION = "curso informática";
    private static final Integer STUDENT_QUANTITY = 4;
    private static final String CATEGORY_ID = "1";
    private static final String DESCRIPTION = "ADS";
    Date START_DATE = new Date();
    Date END_DATE = new Date();

    @Test void saveSuccessTest() {
        Course course = createCourse();
        CourseRequestDTO courseRequestDTO = createCourseRequestDTO();

        when(courseService.save(course)).thenReturn(course);
        CourseResponseDTO courseResponseDTO = courseFacade.save(courseRequestDTO);
        assertEquals(convertToDTO(course), courseResponseDTO);
    }

    @Test
    public void getCourseSuccessTest() {
        List<Course> courses = createListCourse();

        when(courseService.getCourse()).thenReturn(courses);
        List<CourseResponseDTO> list = courseFacade.getCourses();

        List<CourseResponseDTO> collect = courses.stream().map(course -> convertToDTO(course)).collect(Collectors.toList());
        assertEquals(collect, list);
    }

    @Test
    public void findByIdSuccessTest() {
        Course course = createCourse();

        when(courseService.findById(ID)).thenReturn(course);
        CourseResponseDTO byId = courseFacade.findById(ID);

        assertEquals(convertToDTO(course), byId);
    }

    @Test
    public void updateSuccessTest() {
        Course course = createCourse();
        CourseRequestDTO courseRequestDTO = createCourseRequestDTO();

        when(courseService.save(course)).thenReturn(course);
        CourseResponseDTO update = courseFacade.update(courseRequestDTO);

        assertEquals(convertToDTO(course), update);
    }

    @Test
    public void deleteByIdSuccessTest() {
        CourseService courseService = mock(CourseServiceImpl.class);

        ArgumentCaptor valCapture = ArgumentCaptor.forClass(String.class);

        doNothing().when(courseService).deleteById((String) valCapture.capture());
        courseService.deleteById("ID");
        courseFacade.deleteById(ID);

        assertEquals("ID", valCapture.getValue());
    }

    private Course createCourse() {
        Course course = new Course();

        course.setId(ID);
        course.setSubjectDescription(SUBJECT_DESCRIPTION);
        course.setStartDate(START_DATE);
        course.setEndDate(END_DATE);
        course.setStudentQuantity(STUDENT_QUANTITY);
        course.setCategory(createListCategory());

        return course;
    }

    private Category createCategory() {
        Category category = new Category();

        category.setId(CATEGORY_ID);
        category.setDescription(DESCRIPTION);

        return category;
    }

    private CategoryRequestDTO createCategoryResquestDTO() {
        CategoryRequestDTO categoryRequestDTO = new CategoryRequestDTO();

        categoryRequestDTO.setId(CATEGORY_ID);
        categoryRequestDTO.setDescription(DESCRIPTION);

        return categoryRequestDTO;
    }

    private List<Course> createListCourse() {
        Course course = createCourse();

        List<Course> courseList = new ArrayList<>();
        courseList.add(course);

        return courseList;
    }

    private Category createListCategory() {
        Category category = createCategory();

        category.setId(CATEGORY_ID);
        category.setDescription(DESCRIPTION);

        return category;
    }

    private CategoryRequestDTO createListCategoryRequestDTO() {
        CategoryRequestDTO categoryRequestDTO = createCategoryResquestDTO();

        categoryRequestDTO.setId(CATEGORY_ID);
        categoryRequestDTO.setDescription(DESCRIPTION);

        return categoryRequestDTO;
    }

    private CourseRequestDTO createCourseRequestDTO() {
        CourseRequestDTO courseRequestDTO = new CourseRequestDTO();

        courseRequestDTO.setId(ID);
        courseRequestDTO.setSubjectDescription(SUBJECT_DESCRIPTION);
        courseRequestDTO.setStartDate(START_DATE);
        courseRequestDTO.setEndDate(END_DATE);
        courseRequestDTO.setStudentQuantity(STUDENT_QUANTITY);
        courseRequestDTO.setCategory(createListCategoryRequestDTO());

        return courseRequestDTO;
    }

    private CourseResponseDTO convertToDTO(Course course) {
        return modelMapper.map(course, CourseResponseDTO.class);
    }
}
