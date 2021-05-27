package com.brunomilitzer.student.dal.repository;

import com.brunomilitzer.student.dal.entities.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
