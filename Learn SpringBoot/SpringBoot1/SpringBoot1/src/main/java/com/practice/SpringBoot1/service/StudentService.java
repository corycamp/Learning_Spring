package com.practice.SpringBoot1.service;

import com.practice.SpringBoot1.model.Student;
import com.practice.SpringBoot1.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private Student student;
    private StudentRepo repo;

    public StudentRepo getRepo() {
        return repo;
    }

    @Autowired
    public void setRepo(StudentRepo repo) {
        this.repo = repo;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void saveStudent(Student student){
        repo.save(student);
    }
}
