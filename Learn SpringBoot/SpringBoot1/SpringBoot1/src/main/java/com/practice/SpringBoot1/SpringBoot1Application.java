package com.practice.SpringBoot1;

import com.practice.SpringBoot1.model.Student;
import com.practice.SpringBoot1.repository.StudentRepo;
import com.practice.SpringBoot1.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBoot1Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBoot1Application.class, args);

//        Student student = context.getBean(Student.class);
//        StudentRepo repo = context.getBean(StudentRepo.class);
//        student.setName("Cory");
//        student.setMarks(90);
//        student.setRollNo(101);

//        StudentService service = context.getBean(StudentService.class);
//        service.saveStudent(student);

//        repo.save(student);
	}

}
