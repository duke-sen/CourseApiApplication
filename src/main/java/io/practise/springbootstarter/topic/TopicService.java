package io.practise.springbootstarter.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    /*private List<Topic> topics = new ArrayList<>(
            Arrays.asList(
            new Topic("Spring", "Spring Framework", "Spring Framework Detection"),
            new Topic("Java", "Core Java", "Core Java Description"),
            new Topic("Javascript", "Javascript", "Javascript Description")
    ));*/

    public List<Topic> getAllTopics(){
        //return topics;
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll()
                .forEach(topics::add);
        return topics;
    }

    public Topic getTopic(String id){
        /*return
            topics.stream()
                    .filter(topic -> topic.getId().equals(id))
                    .findFirst()
                    .orElse(null);*/

        return topicRepository.findById(id).isPresent() ? topicRepository.findById(id).get() : null;
    }

    public void addTopic(Topic topic) {
        //topics.add(topic);
        topicRepository.save(topic);
    }

    public void updateTopic(String id, Topic topic) {
        /*for (int i = 0; i < topics.size(); i++) {
            Topic tempTopic = topics.get(i);
            if (tempTopic.getId().equals(id)){
                topics.set(i, topic);
                return;
            }
        }*/
        // save() can do both save and update *_*
        topicRepository.save(topic);
    }

    public void deleteTopic(String id){
        //topics.removeIf(topic -> topic.getId().equals(id));
        topicRepository.deleteById(id);
    }
}
