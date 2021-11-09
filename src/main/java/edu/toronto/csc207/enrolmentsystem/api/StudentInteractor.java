package edu.toronto.csc207.enrolmentsystem.api;

import edu.toronto.csc207.enrolmentsystem.Student;
import edu.toronto.csc207.enrolmentsystem.api.errors.*;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * This is a use case class that controls what users are permitted to do with the Student entity.
 * It is closely linked to the repository. We have to register this class with Spring Boot so it can be injected into the controller
 * - so we can tag it with @Configuration.
 */
@Configuration
public class StudentInteractor {
    private final StudentRepository repository;

    /**
     * Defines a repository for this use case. The repository will be "injected" by Spring Boot when this class is
     * instantiated as the web server starts up.
     */
    public StudentInteractor(StudentRepository repository) {
        this.repository = repository;
    }

    /**
     * Returns all Students in the database.
     */
    public List<Student> getAllStudents(){
        return repository.findAll();

    }

    /**
     * Creates a student and saves it to the database.
     */
    public Student createStudent(List<String> info){
        Student student = new Student(info);
        return repository.save(student);
    }


    public Student getStudentById(long id) throws StudentNotFound{
        return repository.findById(id).orElseThrow(StudentNotFound::new);
    }


    public Student updateCourses(Student student, List<String> newCourses) {
        student.setCourses(newCourses);
        return repository.save(student);
    }


    /**
     * Accepts a Student object and extracts all permissible information from it, updating the corresponding student
     * in the database.
     * @param id The ID of the student to update
     * @param student the new student object, from which to extract data from
     * @return the updated student object.
     * @throws StudentNotFound  if the id does not match any student
     */
    public Student updatePermittedFields(long id, Student student) throws StudentNotFound{
        Student existingStudent = this.getStudentById(id);

    //    Only permitted to update courses - we ignore any other changes to the student passed in
        return updateCourses(existingStudent, student.getCourses());
    }
}
