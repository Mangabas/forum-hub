package com.example.forum_hub.services;

import com.example.forum_hub.model.classes.Profiles;
import com.example.forum_hub.model.classes.Topics;
import com.example.forum_hub.model.dto.TopicsDTO;
import com.example.forum_hub.repository.ProfileRepository;
import com.example.forum_hub.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private ProfileRepository profileRepository;

    public Topics saveTopic(TopicsDTO topicsDTO, String loggedUser){
        Topics topic = new Topics(topicsDTO);
        UserDetails user = profileRepository.findByLogin(loggedUser);
        topic.setAuthor((Profiles) user);
        topicRepository.save(topic);

        return topic;
    }

    public Long compareUser(String loggedUser){
        Profiles profiles = (Profiles) profileRepository.findByLogin(loggedUser);
        return profiles.getId();
    }


}
