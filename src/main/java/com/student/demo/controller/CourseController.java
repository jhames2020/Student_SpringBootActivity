package com.student.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.demo.model.Course;
import com.student.demo.repository.CourseRepository;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseRepository courseRepository;

    public CourseController(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }
    
    @PostMapping("/addCourse")
    public Course addCourse(@RequestBody Course course){
        return courseRepository.save(course);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id){
        courseRepository.deleteById(id);
    }

    @GetMapping("/displayCourses")
    public List<Course> getAllCourse(){
        return courseRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Course> getCourseById(@PathVariable Long id){
        return courseRepository.findById(id);
    }

    @PutMapping("/{id}")
    public Course updatedCourse(@PathVariable Long id, @RequestBody Course updatedCourse){
        Course course = courseRepository.findById(id).orElseThrow();
        course.setName(updatedCourse.getName());
        return courseRepository.save(course);

    }
}
