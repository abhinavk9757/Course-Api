package com.abhinav.courseapi.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class topic_service {
    @Autowired
    private topic_repository topicRepository;

    public List<topic_model> getAllTopics(String courseId){
        List<topic_model> topics = new ArrayList<>();
        topicRepository.findByCourseId(courseId).forEach(topics::add);
        return  topics;
    }

    public  void deleteTopic(String Id){
        topicRepository.deleteById(Id);
    }

    public void addTopics(List<topic_model> topics){
        topics.forEach(topicRepository::save);
    }

    public void updateTopics(List<topic_model> topics){
        topics.forEach(topicRepository::save);
    }

    public Optional<topic_model> findById(String Id){
        return topicRepository.findById(Id);
    }

}
