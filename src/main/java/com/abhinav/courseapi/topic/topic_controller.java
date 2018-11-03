package com.abhinav.courseapi.topic;

import com.abhinav.courseapi.course.course_model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class topic_controller {
    @Autowired
    private  topic_service topicService;

    @GetMapping("/courses/{courseId}/topics")
    public List<topic_model> getAllTopics(@PathVariable(name = "courseId") String courseId){
    return topicService.getAllTopics(courseId);
    }

    @PutMapping("/courses/{courseId}/topics")
    public void addTopics(@RequestBody List<topic_model> topics,@PathVariable(name = "courseId") String courseId){
        topics.forEach(topic -> topic.setCourse(new course_model(courseId,"","")));
        topicService.addTopics(topics);
    }

    @GetMapping("/courses/{courseId}/topics/{topicId}")
    public Optional<topic_model> getById(@PathVariable(name = "topicId") String topicId){
        return topicService.findById(topicId);
    }

    @DeleteMapping("/courses/topics/{topicId}")
    public void deleteById(@PathVariable(name = "topicId") String Id){
        topicService.deleteTopic(Id);
    }

    @PostMapping("/courses/{courseId}/topics")
    public void updateTopics(@RequestBody List<topic_model> topics,@PathVariable(name = "courseId")String courseId){
        topics.forEach(topic->topic.setCourse(new course_model(courseId,"","")));
        topicService.updateTopics(topics);
    }
}
