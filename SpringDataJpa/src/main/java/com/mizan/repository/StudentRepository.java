package com.mizan.repository;

import com.mizan.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    public List<Student> findByFirstName(String firstName);
    public List<Student> findByFirstNameContaining(String name);
    public List<Student> findByLastNameNotNull();
    Student findByGuardianName(String guardianName);
    public List<Student> findByFirstNameAndLastName(String firstName, String lastName);

    // JPQL
    @Query("select s from Student s where s.emailId=?1")
   Student getStudentByEmailAddress(String emailID);

    // JPQL
    @Query("select s.firstName from Student s where s.emailId=?1")
   String getStudentFirstNameByEmailAddress(String emailID);
    // Native query
    @Query(
            value = "select * from  tbl_student s where s.email_address=?1",
    nativeQuery = true
    )
    Student getStudentByEmailAddressNative(String emailID);

    // Native named param query
    @Query(
            value = "select * from  tbl_student s where s.email_address=:emailId",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNativeNamedParam(@Param("emailId") String emailID);


}
