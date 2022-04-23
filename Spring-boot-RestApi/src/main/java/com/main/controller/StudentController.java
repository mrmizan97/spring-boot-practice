package com.main.controller;

import com.main.entity.Student;
import com.main.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students/")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("index")
    public List<Student> index() {
        return studentService.fetchAllStudents();
    }

    @PostMapping("store")
    public Student store(@RequestBody Student student) {
        return studentService.store(student);
    }
}
