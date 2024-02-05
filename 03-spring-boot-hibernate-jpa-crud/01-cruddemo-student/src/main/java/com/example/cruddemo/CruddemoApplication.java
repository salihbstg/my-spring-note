package com.example.cruddemo;

import com.example.cruddemo.dao.StudentDAO;
import com.example.cruddemo.entity.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(@Qualifier("studentDAOImpl") StudentDAO studentDAO) {
        return runner -> {
            //Create
            createStudent(studentDAO);

            //Read
            //readStudent(5,studentDAO);
            //readAllStudents(studentDAO);
            //readStudentByMail(studentDAO, "salihbstg01@gmail.com");

            //update
            //updateStudent(studentDAO,7);
            //updateAllRows(studentDAO);

            //delete
            //removeStudent(studentDAO,9);
            //removeAllStudent(studentDAO);
        };
    }

    private void removeAllStudent(StudentDAO studentDAO) {
        System.out.println(studentDAO.deleteAll());
    }

    private void removeStudent(StudentDAO studentDAO, int i) {
        studentDAO.deleteStudent(i);
    }


    private void updateAllRows(StudentDAO studentDAO) {
        List<Student> updatedStudentAll = readAllStudents(studentDAO);
        for (Student temp : updatedStudentAll) {
            temp.setLastName("Tester");
            studentDAO.updateAllRowsOnceCol(temp);
        }
    }

    private void updateStudent(StudentDAO studentDAO, int id) {
        Student tempStudent = readStudent(id, studentDAO);
        tempStudent.setLastName("Kutru");
        tempStudent.setFirstName("Elvin Ada");
        tempStudent.setEmail("elvinimto@gmail.com");
        studentDAO.update(tempStudent);
    }

    private void readStudentByMail(StudentDAO studentDAO, String mail) {

        //get a list of students
        List<Student> tempList = studentDAO.findByEmail(mail);

        //display a list of students
        for (Student tempStudent : tempList) {
            System.out.println(tempStudent);
        }

    }

    private List<Student> readAllStudents(StudentDAO studentDAO) {

        //get a list of students
        List<Student> theStudents = studentDAO.findAll();

        //display list of students
        for (Student temp : theStudents) {
            System.out.println(temp);
        }
        return theStudents;
    }

    private Student readStudent(int i, StudentDAO studentDAO) {

        //get a student by id
        Student tempStudent = studentDAO.findByID(i);

        //display a student by id
        System.out.println(tempStudent);
        return tempStudent;
    }

    private void createStudent(StudentDAO studentDAO) {

        // create the new student object
        System.out.println("Creating the new student object");
        Student tempStudent = new Student("Tuce", "Cetin", "tucemnur@111gmail.com");

        //save student object
        System.out.println("Saving the new student object");
        studentDAO.save(tempStudent);

        //display student id
        System.out.println("Created object id:" + tempStudent.getId());

    }


}
