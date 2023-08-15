package application.gpacalculatorservice;

import application.gpacalculatorservice.authentication.AuthenticationRequest;
import application.gpacalculatorservice.authentication.AuthenticationService;
import application.gpacalculatorservice.calculate.CalculateGpaService;
import application.gpacalculatorservice.showdetails.ShowResultsService;
import application.gpacalculatorservice.storecourses.Course;
import application.gpacalculatorservice.storecourses.MySqlDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.sql.SQLDataException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
class GpaCalculatorController {
    AuthenticationService authenticationService;
    CalculateGpaService calculateGpaService;
    ShowResultsService showResultsService;
    MySqlDatabase mySqlDatabase;
    @Autowired
    public GpaCalculatorController(AuthenticationService authenticationService,
                                   CalculateGpaService calculateGpaService,
                                   ShowResultsService showResultsService,
                                   MySqlDatabase mySqlDatabase) {
        this.authenticationService = authenticationService;
        this.calculateGpaService = calculateGpaService;
        this.showResultsService = showResultsService;
        this.mySqlDatabase = mySqlDatabase;
    }

    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("username", "");
        model.addAttribute("password", "");
        return "login_page";
    }
    @GetMapping("/gpa-calculator")
    public String gpaCalculatorPage() {
        return "gpa_calculator";
    }
    @PostMapping("/auth")
    public String authenticate(String username, String password) {
        AuthenticationRequest authenticationRequest = new AuthenticationRequest(username, password);
        boolean authenticated = authenticationService.authenticate(authenticationRequest);
        if (authenticated) {
            return "redirect:/gpa-calculator";
        }
        return "redirect:/login";
    }
    @PostMapping("/save-grades")
    public String saveGrades(@RequestParam("course") List<String> coursesNames,
                             @RequestParam("grade") List<String> grades,
                             RedirectAttributes redirectAttributes) throws SQLDataException {

        List<Course> courses = IntStream.range(0, coursesNames.size())
                .mapToObj(i -> new Course(coursesNames.get(i), grades.get(i)))
                .collect(Collectors.toList());

        System.out.println(courses.size());
        mySqlDatabase.saveCourses(courses);
        calculateGpaDetails(redirectAttributes);
        return "redirect:/gpa-calculator";
    }
    public void calculateGpaDetails(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("isGradeCalculated", true);
        calculateGpaService.calculate();
    }
    @GetMapping("/show-gpa-details")
    public RedirectView showCalculatedGrade() {
        System.out.println("HEy");
        return showResultsService.showResults();
    }
}
