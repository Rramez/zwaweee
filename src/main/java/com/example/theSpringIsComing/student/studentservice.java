package com.example.theSpringIsComing.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

import static com.sun.tools.javac.jvm.ByteCodes.illegal;

@Service
public class studentservice {
    private  final   StudentRepository studentRepository;
    @Autowired
    public studentservice(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<student> getStudents(){
        return studentRepository.findAll();
    }

    public void addNewStudent(student student) {
        Optional<student> studentByEmail = studentRepository.findstudentByEmail(student.getEmail());
        if (studentByEmail.isPresent()){
            throw new IllegalStateException("email taken");
        }
        studentRepository.save(student);
        System.out.println(student);

    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if (!exists){
            throw new IllegalStateException("student with id"+ studentId + "does not exists");
        }
        studentRepository.deleteById(studentId);
    }
}
