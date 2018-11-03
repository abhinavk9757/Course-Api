package com.abhinav.courseapi.topic;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface topic_repository extends CrudRepository<topic_model,String> {
    public List<topic_model> findByCourseId(String courseId);
}
