package com.abhinav.courseapi.topic;

import com.abhinav.courseapi.course.course_model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "topic")
public class topic_model {

    @Id
    @NotNull
    private String Id;
    private  String name;
    private String description;

    @ManyToOne
    private course_model course;

    public topic_model(){}

    public topic_model(@NotNull String id, String name, String description, String courseId) {
        Id = id;
        this.name = name;
        this.description = description;
        this.course = new course_model(courseId,"","");
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public course_model getCourse() {
        return course;
    }

    public void setCourse(course_model course) {
        this.course = course;
    }
}
