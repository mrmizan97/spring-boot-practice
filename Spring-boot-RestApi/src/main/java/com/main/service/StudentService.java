package com.main.service;

import com.main.entity.Student;

import java.util.List;

public interface StudentService {

    Student store(Student student);

    List<Student> fetchAllStudents();

    Student findById(Long id);

    void deleteById(Long id);

    Student update(Student student, Long id);

    Student findByName(String name);
}
