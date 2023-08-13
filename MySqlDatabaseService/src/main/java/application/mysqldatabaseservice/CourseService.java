package application.mysqldatabaseservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    private final CourseRepository courseRepository;
    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
    public void saveCourse(Course course) {
        courseRepository.save(course);
   }
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
}
