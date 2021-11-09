package edu.toronto.csc207.enrolmentsystem.api;

import edu.toronto.csc207.enrolmentsystem.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The implementation of this interface, which is handled by Spring Boot, is a "Gateway" to a database.
 */
interface StudentRepository extends JpaRepository<Student, Long> {
//    We could make this a class and do our own work (requires SQL knowledge) to fetch data,
//    but we can let Springboot take care of this for us of now!
}
