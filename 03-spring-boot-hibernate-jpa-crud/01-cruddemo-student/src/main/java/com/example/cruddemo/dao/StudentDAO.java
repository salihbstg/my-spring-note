package com.example.cruddemo.dao;

import com.example.cruddemo.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDAO {
    void save(Student theStudent);
    Student findByID(long id);

    List<Student> findAll();
    List<Student> findByEmail(String mail);
    void update(Student theStudent);
    void updateAllRowsOnceCol(Student theStudent);

    void deleteStudent(int id);
    int deleteAll();
}
