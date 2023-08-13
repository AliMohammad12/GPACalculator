package application.mysqldatabaseservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DatabaseController {
    private final CourseService courseService;
    @Autowired
    public DatabaseController(CourseService courseService) {
        this.courseService = courseService;
    }
    @PostMapping("/mysqlDB/store")
    public ResponseEntity<String> saveCourses(@RequestBody StoreCoursesRequest storeCoursesRequest) {
        List<String> coursesNames = storeCoursesRequest.getCourseName();
        List<String> coursesGrades = storeCoursesRequest.getCourseGrade();
        for (int i = 0; i < coursesNames.size(); i++) {
            Course course = new Course(coursesNames.get(i), coursesGrades.get(i));
            courseService.saveCourse(course);
        }
        return ResponseEntity.ok("Data Saved Successfully!");
    }
    @RequestMapping("/mysqlDB-read")
    public List<Course> readCourses() {
        List<Course> courses = courseService.getAllCourses();
        return courses;
    }
}
