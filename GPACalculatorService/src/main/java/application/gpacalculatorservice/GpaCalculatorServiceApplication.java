package application.gpacalculatorservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class GpaCalculatorServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(GpaCalculatorServiceApplication.class, args);
    }
}
