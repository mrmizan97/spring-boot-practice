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

    @GetMapping("{id}")
    public Student findById(@PathVariable("id") Long id) {
        return studentService.findById(id);
    }

    @GetMapping("{name}")
    public Student findByName(@PathVariable("name") String name) {
        return studentService.findByName(name);
    }

    @PutMapping("update/{id}")
    public Student update(@PathVariable("id") Long id, @RequestBody Student student) {
        return studentService.update(student, id);
    }

    @DeleteMapping("{id}")
    public String deletById(@PathVariable("id") Long id) {
        studentService.deleteById(id);
        return "Student whose id=" + id + " deleted.";
    }
}
