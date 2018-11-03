package com.abhinav.courseapi.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class course_controller {

    @Autowired
    course_service courseService;

    @GetMapping("/courses")
    public List<course_model> getAllCourses(){
        return courseService.getAllCourse();
    }

    @PutMapping("/courses")
    public void addCourse(@RequestBody List<course_model> course){

        //course_model course = new course_model("spring","Spring Programming","Description of Spring Programming");

        courseService.addCourse(course);
    }

    @GetMapping("/courses/{courseId}")
    public Optional<course_model> getById(@PathVariable(name = "courseId") String courseId){
        return courseService.findById(courseId);
    }

    @DeleteMapping("/courses/{courseId}")
    public void deleteById(@PathVariable(name = "courseId") String Id){
        courseService.deleteCourse(Id);
    }

    @PostMapping("/courses")
    public void updateCourses(@RequestBody List<course_model> courses){
        courseService.updateCourse(courses);
    }

}
