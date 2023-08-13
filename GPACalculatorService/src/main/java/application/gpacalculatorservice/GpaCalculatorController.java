package application.gpacalculatorservice;

import application.gpacalculatorservice.authentication.AuthenticationRequest;
import application.gpacalculatorservice.authentication.AuthenticationService;
import application.gpacalculatorservice.calculate.CalculateGpaService;
import application.gpacalculatorservice.showdetails.ShowResultsService;
import application.gpacalculatorservice.storecourses.StoreCoursesRequest;
import application.gpacalculatorservice.storecourses.StoreCoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.sql.SQLDataException;
import java.util.ArrayList;
import java.util.List;

@Controller
class GpaCalculatorController {
    AuthenticationService authenticationService;
    StoreCoursesService storeCoursesService;
    CalculateGpaService calculateGpaService;
    ShowResultsService showResultsService;

    @Autowired
    public GpaCalculatorController(AuthenticationService authenticationService,
                                   StoreCoursesService storeCoursesService,
                                   CalculateGpaService calculateGpaService,
                                   ShowResultsService showResultsService) {
        this.authenticationService = authenticationService;
        this.storeCoursesService = storeCoursesService;
        this.calculateGpaService = calculateGpaService;
        this.showResultsService = showResultsService;
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
    public String saveGrades(@RequestParam("course") List<String> courses,
                             @RequestParam("grade") List<String> grades, RedirectAttributes redirectAttributes) throws SQLDataException {
        StoreCoursesRequest storeCoursesRequest = new StoreCoursesRequest(courses, grades);
        ResponseEntity<String> response = storeCoursesService.storeCourses(storeCoursesRequest);
        if (response.getStatusCode() != HttpStatus.OK) {
            throw new SQLDataException();
        }
        calculateGpaDetails();
        redirectAttributes.addFlashAttribute("isGradeCalculated", true);
        return "redirect:/gpa-calculator";
    }
    public void calculateGpaDetails() {
        calculateGpaService.calculate();
    }
    @GetMapping("/show-gpa-details")
    public RedirectView showCalculatedGrade() {
        return showResultsService.showResults();
    }
}
