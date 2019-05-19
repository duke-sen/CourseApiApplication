package io.practise.springbootstarter.course;

import io.practise.springbootstarter.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    /*private List<Topic> topics = new ArrayList<>(
            Arrays.asList(
            new Topic("Spring", "Spring Framework", "Spring Framework Detection"),
            new Topic("Java", "Core Java", "Core Java Description"),
            new Topic("Javascript", "Javascript", "Javascript Description")
    ));*/

    public List<Course> getAllCourses(String topicId){
        //return topics;
        return courseRepository.findByTopicId(topicId);
    }

    public Course getCourse(String id){
        return courseRepository.findById(id).isPresent() ? courseRepository.findById(id).get() : null;
    }

    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    public void updateCourse(Course course) {
        courseRepository.save(course);
    }

    public void deleteCourse(String id){
        //topics.removeIf(topic -> topic.getId().equals(id));
        courseRepository.deleteById(id);
    }

}
