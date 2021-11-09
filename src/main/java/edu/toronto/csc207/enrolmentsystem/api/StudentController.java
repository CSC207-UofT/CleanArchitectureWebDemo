package edu.toronto.csc207.enrolmentsystem.api;

import edu.toronto.csc207.enrolmentsystem.Student;
import edu.toronto.csc207.enrolmentsystem.api.errors.StudentNotFound;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This Controller will define mappings from endpoints and HTTP verbs to actions to perform using our StudentInteractor use case class.
 */
@RestController
public class StudentController {

    private final StudentInteractor interactor;

    public StudentController(StudentInteractor interactor) {
        this.interactor = interactor;
    }

    @GetMapping("/students")
    List<Student> all() {
        return interactor.getAllStudents();
    }

    @GetMapping("/students/{id}")
    Student one(@PathVariable Long id) throws StudentNotFound {
        return interactor.getStudentById(id);
    }

    @PostMapping("/students")
    Student newStudent(@RequestBody Student newStudent) {
        return interactor.createStudent(newStudent.getStudentInfo());
    }

    @PutMapping("/students/{id}")
    Student updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent) throws StudentNotFound {
        return interactor.updatePermittedFields(id, updatedStudent);

    }
}
