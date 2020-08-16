package br.com.cast.avaliacao.service.impl;

import br.com.cast.avaliacao.entities.Category;
import br.com.cast.avaliacao.entities.Course;
import br.com.cast.avaliacao.repositories.CourseRepository;
import br.com.cast.avaliacao.services.impl.CourseServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CourseServiceImplTest {

    @InjectMocks
    private CourseServiceImpl courseService;

    @Mock
    private CourseRepository courseRepository;

    private static final String ID = "01";
    private static final String SUBJECT_DESCRIPTION = "curso informática";
    private static final Integer STUDENT_QUANTITY = 4;
    private static final String CATEGORY_ID = "1";
    private static final String DESCRIPTION = "ADS";
    private static final Category CATEGORY = new Category();
    Date START_DATE = new Date();
    Date END_DATE = new Date();

    @Test
    public void saveSuccessTest() {
        Course course = createCourse();

        when(courseRepository.save(course)).thenReturn(course);
        Course save = courseService.save(course);

        assertEquals(course, save);
    }

    @Test
    public void getCourseSuccessTest() {
        List<Course> courses = createListCourse();

        when(courseRepository.findAll()).thenReturn(courses);
        List<Course> courseList = courseService.getCourse();

        assertEquals(courses, courseList);
    }

    @Test
    public void findByIdSuccessTest() {
        Course course = createCourse();

        when(courseRepository.findByid(ID)).thenReturn(course);
        Course byId = courseService.findById(ID);

        assertEquals(course, byId);
    }

    @Test
    public void deleteByIdSuccessTes() {
        CourseRepository courseRepository = mock(CourseRepository.class);

        ArgumentCaptor valCapture = ArgumentCaptor.forClass(String.class);

        doNothing().when(courseRepository).deleteById((String) valCapture.capture());
        courseRepository.deleteById("ID");
        courseService.deleteById(ID);

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

    private List<Course> createListCourse() {
        Course course = createCourse();

        List<Course> courseList = new ArrayList<>();
        courseList.add(course);

        return courseList;
    }

    private List<Category> createListCategory() {
        Category category = createCategory();

        List<Category> categoryList = new ArrayList<>();
        categoryList.add(category);

        return categoryList;
    }
}
