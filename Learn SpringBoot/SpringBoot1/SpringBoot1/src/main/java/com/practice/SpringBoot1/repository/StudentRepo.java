package com.practice.SpringBoot1.repository;

import com.practice.SpringBoot1.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

//@Repository
//public class StudentRepo {
//    private JdbcTemplate jdbc;
//
//    public JdbcTemplate getJdbc() {
//        return jdbc;
//    }
//
//    @Autowired
//    public void setJdbc(JdbcTemplate jdbc) {
//        this.jdbc = jdbc;
//    }
//
//    public void save(Student s){
//        String sql = "insert into student (rollno, name, marks) values (?,?,?)";
//        int rows = jdbc.update(sql,s.getRollNo(),s.getName(),s.getMarks());
//        System.out.println(rows);
//        System.out.println(s);
//    }
//}

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {
}
