package com.brunomilitzer.student.dal;

import com.brunomilitzer.student.dal.entities.*;
import com.brunomilitzer.student.dal.repository.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudentdalApplicationTests {

    @Autowired
    private StudentRepository repository;

    @Test
    void testCreateStudent() {

        Student student = new Student();
        student.setName("Vanessa");
        student.setCourse("Photoshop");
        student.setFee(20D);

        repository.save(student);
    }

    @Test
    void testFindStudentById() {

        Student student = repository.findById(1L).get();

        System.out.println(student);
    }

    @Test
    void testUpdateStudent() {
        Student student = repository.findById(1L).get();
        student.setFee(30d);

        repository.save(student);
    }

    @Test
    void testDeleteStudent() {
        Student student = repository.findById(1L).get();

        repository.delete(student);
    }
}
