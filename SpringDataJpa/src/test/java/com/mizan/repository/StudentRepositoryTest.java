package com.mizan.repository;

import com.mizan.entity.Guardian;
import com.mizan.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DataJpaTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("mizan@gmail.com")
                .firstName("MR")
                .lastName("Mizan")
//                .guardianName("Mr. Guardian")
//                .guardianEmail("guardian@gmail.com")
//                .guardianMobile("99999993333")
                .build();
        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {
        Guardian guardian = Guardian.builder()
                .email("guardian@gmail.com")
                .name("Mr. Guardian")
                .mobile("94839849")
                .build();
        Student student = Student.builder()
                .firstName("saifull")
                .emailId("saifull@gmail.com")
                .lastName("imran")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }

    @Test
    public void printAllStudent() {
        List<Student> studentList = studentRepository.findAll();
        System.out.println("Student list : " + studentList);
    }

    @Test
    public void printStudentByFirstName() {
        List<Student> student = studentRepository.findByFirstName("arafat");
        System.out.println("Student : " + student);
    }

    @Test
    public void printStudentByFirstNameContaining() {
        List<Student> student = studentRepository.findByFirstNameContaining("sh");
        System.out.println("Student : " + student);
    }

    @Test
    public void printStudentBasedOnGuardianName() {
        Student students = studentRepository.findByGuardianName("mizan");
        System.out.println("Student : " + students);
    }

    @Test
    public void printStudentBasedOnFirstNameAndLastName() {
        List<Student> students = studentRepository.findByFirstNameAndLastName("M R", "mizan");
        System.out.println("Student : " + students);
    }

    @Test
    public void printStudentByEmailAddress() {
        Student student = studentRepository.getStudentByEmailAddress("mizan@gmail.com");
        System.out.println("Student : " + student);
    }

    @Test
    public void printStudentFirstNameByEmailAddress() {
        String student = studentRepository.getStudentFirstNameByEmailAddress("mizan@gmail.com");
        System.out.println("Student : " + student);
    }

    @Test
    public void printStudentByEmailAddressNative() {
        Student student = studentRepository.getStudentByEmailAddressNative("mizan@gmail.com");
        System.out.println("Student : " + student);
    }

    @Test
    public void printStudentByEmailAddressNativeParam() {
        Student student = studentRepository.getStudentByEmailAddressNativeNamedParam("mizan@gmail.com");
        System.out.println("Student : " + student);
    }

    @Test
    public void updateStudentFirstNameByEmailId() {
        studentRepository.updateStudentNameByEmailId("Mizan2", "mizan@gmail.com");
    }

    @Test
    public void deleteStudentByEmailId() {
        studentRepository.deleteStudentByEmailId("shivan@gmail.com");
    }
}