package com.viettel.vdt2024.service;

import com.viettel.vdt2024.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    Optional<Student> findStudent(Integer id);
    List<Student> findAll();
    Student save(Student student);
    Student update(Student student);
    void delete(Student student);
    void deleteById(Integer id);
}
