package edu.toronto.csc207.enrolmentsystem.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * This class is a configuration class used by Spring Boot.
 * Here, we disable a "CORS" securit policy, just for the purpose of this demo.-
 */
@Configuration
public class EnrolmentSystemConfiguration {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:63342"); // Allows access through the browser, when files are served by IntelliJ.
            }
        };
    }

}
