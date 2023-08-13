package application.calculationservice;

import application.calculationservice.readcourses.Course;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculateService {
    public double calculate(List<Course> courseList) {
        Double totalGradePoints = 0.0;
        for (Course course : courseList) {
            totalGradePoints += 3.0 * getValue(course.getGrade());
        }
        int numberOfCourses = courseList.size();
        double GPA = totalGradePoints / 3.0 * numberOfCourses;
        return GPA;
    }
    public double getValue(String grade) {
        switch (grade) {
            case "A":
                return 4.00;
            case "A-":
                return 3.75;
            case "B+":
                return 3.50;
            case "B":
                return 3.25;
            case "B-":
                return 3.00;
            case "C+":
                return 2.75;
            case "C":
                return 2.50;
            case "C-":
                return 2.25;
            case "D+":
                return 2.00;
            case "D":
                return 1.75;
            case "D-":
                return 1.50;
            case "F":
                return 0.50;
            default:
                throw new IllegalArgumentException("Invalid grade: " + grade);
        }
    }
}
