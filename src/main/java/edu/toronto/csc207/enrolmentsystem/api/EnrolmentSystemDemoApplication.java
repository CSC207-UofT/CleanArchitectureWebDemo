package edu.toronto.csc207.enrolmentsystem.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * This main class will run the Spring Boot app.
 * Note the use of the @EntityScan attribute which tells Spring Boot where to look for entities.
 */
@SpringBootApplication
@EntityScan("edu.toronto.csc207.enrolmentsystem")
public class EnrolmentSystemDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(EnrolmentSystemDemoApplication.class, args);
    }

}
