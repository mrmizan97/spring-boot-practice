package com.mizan.repository;

import com.mizan.entity.Course;
import com.mizan.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void testSaveTeacher() {
        Course course = Course.builder()
                .title("DBMS")
                .credit(3)
                .build();
        Course course2 = Course.builder()
                .title("OOP")
                .credit(3)
                .build();
        Teacher teacher = Teacher.builder()
                .firstName("Mr.")
                .lastName("Teacher")
//                .courses(List.of(course, course2))
                .build();
        teacherRepository.save(teacher);
    }
}