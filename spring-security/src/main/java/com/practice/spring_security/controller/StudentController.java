package com.practice.spring_security.controller;

import com.practice.spring_security.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    List<Student> students = new ArrayList<>(List.of(
            new Student(1,"Test1","Java"),
            new Student(2,"Test2","Python")
    ));

    @GetMapping("csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @GetMapping("/")
    public List<Student> getStudents(){
        return  students;
    }

    @PostMapping("addStudent")
    public String addStudent(@RequestBody Student student) {
        students.add(student);
        return "Success";
    }
}
