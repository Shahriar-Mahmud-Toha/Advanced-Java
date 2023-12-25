package dev.rest;

import dev.domain.Student;
import dev.service.StudentService;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.List;

@RestController
public class StudentRestController {

    private StudentService studentService;

    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/users")
    public List<Student> getStudents() throws SQLException {
        return studentService.getAll();
    }

    @GetMapping("/users/{id}")
    public Student getStudent(@PathVariable("id") Integer id) throws SQLException {
        Student student = studentService.get(id);
        if(student!=null){
            return studentService.get(id);
        }
        else {
            return null;
        }
    }
    @GetMapping("/users/count")
    public String getStudentCount() throws SQLException {
        return String.valueOf((long) studentService.getAll().size());
    }

    @DeleteMapping("/users/{id}")
    public String deleteStudent(@PathVariable("id") int id) throws SQLException {
        if(studentService.delete(id)){
            return "Successful";
        }
        else {
            return "Unsuccessful";
        }
    }

    @PostMapping("/users")
    public String createStudent(@Valid @RequestBody Student student, BindingResult bindingResult) throws SQLException {
        if (bindingResult.hasErrors()) {
            return "Unsuccessful";
        }
        else {
            studentService.create(student);
            return "Successful";
        }
    }

    @PutMapping("/users")
    public String updateStudent(@Valid @RequestBody Student student, BindingResult bindingResult) throws SQLException {
        if (bindingResult.hasErrors()) {
            return "Unsuccessful";
        }
        else {
            studentService.update(student);
            return "Successful";
        }
    }
}
