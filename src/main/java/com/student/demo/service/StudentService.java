package com.student.demo.service;

import java.util.List;
import java.util.Optional;

import com.student.demo.model.Course;
import com.student.demo.model.Student;

public interface StudentService {

    Student addStudent(Student student);
    List<Student> getAllStudents();
    Optional<Student> getById( Long id);
    void deleteById(Long id);
    Student updateById(Long id, Student updatedStudent);
    Student enroll(Long id, Course course);
    Student drop(Long id, Course course);
    
}