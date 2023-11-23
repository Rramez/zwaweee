package com.example.theSpringIsComing.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
    private final  studentservice studentservice;
    @Autowired
    public StudentController(com.example.theSpringIsComing.student.studentservice studentservice) {
        this.studentservice = studentservice;
    }

    @GetMapping
    public List<student> getStudents(){
        return studentservice.getStudents();
    }
    @PostMapping
    public void registerNewStudent(@RequestBody student student){
        studentservice.addNewStudent(student);

    }
    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId")Long studentId){
        studentservice.deleteStudent(studentId);
    }
}
