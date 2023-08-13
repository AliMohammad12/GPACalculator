package application.calculationservice;

import application.calculationservice.readcourses.Course;
import application.calculationservice.storeresult.GpaAnalytics;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class CalculateService {
    public GpaAnalytics getGpaAnalytics(List<Course> courseList) {
        courseList.sort(new GradeComparator());
        Double GPA = calculateGPA(courseList);
        String lowestGrade = courseList.get(0).getGrade();
        String highestGrade = courseList.get(courseList.size() - 1).getGrade();
        return new GpaAnalytics(GPA, highestGrade, lowestGrade);
    }
    public double calculateGPA(List<Course> courseList) {
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

    public class GradeComparator implements Comparator<Course> {
        private static final String[] GRADE_ORDER = {
                "A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "D-", "F"
        };
        @Override
        public int compare(Course course1, Course course2) {
            int index1 = indexOfGrade(course1.getGrade());
            int index2 = indexOfGrade(course2.getGrade());
            return Integer.compare(index2, index1);
        }
        private int indexOfGrade(String grade) {
            for (int i = 0; i < GRADE_ORDER.length; i++) {
                if (GRADE_ORDER[i].equals(grade)) {
                    return i;
                }
            }
            return -1;
        }
    }
}
