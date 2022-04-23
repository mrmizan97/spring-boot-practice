package com.main.service;

import com.main.entity.Student;

import java.util.List;

public interface StudentService {

    Student store(Student student);
    List<Student> fetchAllStudents();
}
