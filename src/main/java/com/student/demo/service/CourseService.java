package com.student.demo.service;

import java.util.List;
import java.util.Optional;

import com.student.demo.model.Course;

public interface CourseService {

    Course addCourse(Course course);
    List<Course> getAllCourse();
    Optional<Course> getCourseById(Long id);
    void deleteCourse(Long id);
    Course updatedCourse( Long id, Course updatedCourse);

}