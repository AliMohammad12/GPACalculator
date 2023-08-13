package application.gpacalculatorservice.storecourses;

import java.util.List;

public class StoreCoursesRequest {
    private List<String> courseName;
    private List<String> courseGrade;

    public StoreCoursesRequest(List<String> courseName, List<String> courseGrade) {
        this.courseName = courseName;
        this.courseGrade = courseGrade;
    }

    public List<String> getCourseName() {
        return courseName;
    }

    public void setCourseName(List<String> courseName) {
        this.courseName = courseName;
    }

    public List<String> getCourseGrade() {
        return courseGrade;
    }

    public void setCourseGrade(List<String> courseGrade) {
        this.courseGrade = courseGrade;
    }
}
