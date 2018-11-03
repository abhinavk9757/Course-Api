package com.abhinav.courseapi.course;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class course_service {

    @Autowired
    private course_repository courserepository;

    public List<course_model> getAllCourse(){
        List<course_model> courseList = new ArrayList<>();
       courserepository.findAll()
               .forEach(courseList::add);

       return  courseList;
    }

    public void addCourse(List<course_model> c){
        c.stream().forEach(courserepository::save);
}

    public void updateCourse(List<course_model> c){
        c.stream().forEach(courserepository::save);
    }

    public Optional<course_model> findById(String id){
        return courserepository.findById(id);
    }
    public void deleteCourse(String Id){
        courserepository.deleteById(Id);
    }

}
