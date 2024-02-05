package com.scbcompany.demo.rest;

import com.scbcompany.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    List<Student> studentList;

    @PostConstruct
    public void loadData() {
        studentList = new ArrayList<>();
        studentList.add(new Student("Salihcan", "Bastug", true, (short) 25));
        studentList.add(new Student("Gizem", "Bastug", true, (short) 25));
        studentList.add(new Student("Sezin", "Bastug", true, (short) 25));
        studentList.add(new Student("Gorkem", "Bastug", true, (short) 25));
        studentList.add(new Student("Selin", "Bastug", true, (short) 25));
        studentList.add(new Student("Figen", "Bastug", true, (short) 25));
        studentList.add(new Student("Kemal", "Bastug", true, (short) 25));
        studentList.add(new Student("Elvin Ada", "Kutru", true, (short) 24));
        studentList.add(new Student("Tucemnur", "Cetinn", true, (short) 24));
        studentList.add(new Student("Tugcenur", "Cetin", true, (short) 24));
        studentList.add(new Student("Tugcenur", "Cetin", true, (short) 24));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentList;
    }

    @GetMapping("/student/{studentId}")
    public Student getStudentById(@PathVariable int studentId) {
        //check the studentId again list size
        if ((studentId >= studentList.size()) || studentId < 0) {
            throw new StudentNotFoundException("Student is not foundd -" + studentId);
        }
        return studentList.get(studentId);
    }


}
