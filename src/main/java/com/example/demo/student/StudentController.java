package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService studentService;

    // If your component has multiple constructors then you can use
    // @Autowired on one of them to tell Spring "use this one, not that one".
    // dependency injection: leave creation of objects up to framework
    @Autowired // or @Injection, optional
    public StudentController(
            StudentService studentService // pass this for injection
    ) {
        // create object on heap, and it might be singleton
//        this.studentService = new StudentService();
        this.studentService = studentService; // dependency injection
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        studentService.deleteStudent(studentId);
    }
}
