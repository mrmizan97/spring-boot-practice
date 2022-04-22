package com.mizan.repository;

import com.mizan.entity.Course;
import com.mizan.entity.Student;
import com.mizan.entity.Teacher;
import org.assertj.core.error.ShouldBeAfterOrEqualTo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void testFetchAllCourses() {
        List<Course> courses = courseRepository.findAll();
        System.out.println("courses: " + courses);
    }

    @Test
    public void testSaveCourseWithTeacher() {
        Teacher teacher = Teacher.builder()
                .firstName("Mr.")
                .lastName("Java Teacher")
                .build();
        Course course = Course.builder()
                .title("JAVA")
                .credit(3)
                .teacher(teacher)
                .build();
        courseRepository.save(course);
    }

    @Test
    public void testFindAllPagination() {
        Pageable firstPageWithThreeRecords =
                PageRequest.of(0, 3);
        Pageable secondPageWithThreeRecords =
                PageRequest.of(1, 2);
        List<Course> courses = courseRepository.findAll(firstPageWithThreeRecords).getContent();
        long totalElements = courseRepository.findAll(firstPageWithThreeRecords).getTotalElements();
        long totalPages = courseRepository.findAll(firstPageWithThreeRecords).getTotalPages();
        System.out.println("totalPages : " + totalPages);
        System.out.println("totalElements : " + totalElements);
        System.out.println("courses : " + courses);
    }

    @Test
    public void testFindAllSorting() {
        Pageable sortByTitle =
                PageRequest.of(0, 2, Sort.by("title"));
        Pageable sortByCreditDesc =
                PageRequest.of(0, 2, Sort.by("credit").descending());
        Pageable sortByTitleCreditDesc =
                PageRequest.of(0, 2, Sort.by("title").descending().and(Sort.by("credit")));
        List<Course> courses = courseRepository.findAll(sortByTitle).getContent();
//        List<Course> courses = courseRepository.findAll(sortByTitle).getContent();
//        List<Course> courses = courseRepository.findAll(sortByTitle).getContent();
        System.out.println("courses : " + courses);
    }

    @Test
    public void testFindByTitleContaining() {
        Pageable firstPageTenRecords = PageRequest.of(0, 2);
        List<Course> courses = courseRepository.findByTitleContaining("j", firstPageTenRecords).getContent();
        System.out.println("courses : "+courses);
    }
    @Test
    public void testSaveCourseWithStudentAndTeacher(){
        Teacher teacher=Teacher.builder()
                .firstName("Mr.")
                .lastName("DotNet Teacher")
                .build();
        Student student=Student.builder()
                .firstName("Mr.")
                .lastName("DotNet Student")
                .emailId("dotnetStudent@gmail.com")
                .build();
        Course course=Course.builder()
                .title("DotNet")
                .credit(3)
                .teacher(teacher)
                .build();
        course.addStudents(student);
        courseRepository.save(course);
    }

}