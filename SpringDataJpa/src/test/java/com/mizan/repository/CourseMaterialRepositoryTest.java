package com.mizan.repository;

import com.mizan.entity.Course;
import com.mizan.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {
    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void testSaveCourseMaterial() {
        Course course = Course.builder()
                .title("Data Structure")
                .credit(3)
                .build();
        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.geeksforgeeks.com")
                .course(course).build();
        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    public void testFetchAllCourseMaterial() {
        List<CourseMaterial> courseMaterials = courseMaterialRepository.findAll();
        System.out.println("course materils: " + courseMaterials);
    }

}