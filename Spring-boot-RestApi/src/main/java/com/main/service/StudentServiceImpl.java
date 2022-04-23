package com.main.service;

import com.main.entity.Student;
import com.main.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student store(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> fetchAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student update(Student student, Long id) {
        Student studentDB = studentRepository.findById(id).get();
        studentDB.setName(student.getName());
        studentDB.setEmail(student.getEmail());
        studentDB.setCourse(student.getCourse());
        return studentRepository.save(studentDB);

    }

    @Override
    public Student findByName(String name) {
        return studentRepository.findByNameIgnoreCase(name);
    }
}
