package application.gpacalculatorservice.mysqldb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MySqlDatabase {
    private final CourseRepository courseRepository;
    @Autowired
    public MySqlDatabase(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
    public void saveCourse(Course course) {
        courseRepository.save(course);
    }
    public void saveCourses(List<Course> courseList) {
        courseRepository.saveAll(courseList);
    }
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
    public void deleteAll() {
        courseRepository.deleteAll();
    }
}
