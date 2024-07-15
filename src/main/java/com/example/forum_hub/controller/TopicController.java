package com.example.forum_hub.controller;

import com.example.forum_hub.model.classes.Topics;
import com.example.forum_hub.model.dto.TopicsDTO;
import com.example.forum_hub.model.dto.TopicsReturnDTO;
import com.example.forum_hub.repository.TopicRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("topics")
public class TopicController {

    @Autowired
    private TopicRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity newTopic(@RequestBody @Valid TopicsDTO post, UriComponentsBuilder uriBuilder){
        Topics topic = new Topics(post);
        repository.save(topic);

        URI uri = uriBuilder.path("/topics/{id}").buildAndExpand(topic.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicsReturnDTO(topic));
    }

    @GetMapping
    public ResponseEntity<Page<TopicsReturnDTO>> listAll(@PageableDefault(size = 10, sort = {"title"})Pageable pageable){
        Page<TopicsReturnDTO> page =repository.findAllByStatusTrue(pageable).map(t -> new TopicsReturnDTO(t));
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity getTopic(@PathVariable Long id){
        Topics topic = repository.getReferenceById(id);

        return ResponseEntity.ok(new TopicsReturnDTO(topic));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity putTopic(@PathVariable Long id,@RequestBody @Valid TopicsDTO post ){
        Optional<Topics> topic = repository.findById(id);
        if (topic.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        topic.get().attTopic(post);

        return ResponseEntity.ok(new TopicsReturnDTO(topic.get()));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteTopic(@PathVariable Long id) {
        Optional<Topics> topic = repository.findById(id);
        if (topic.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        topic.get().inativeTopic();

        return ResponseEntity.noContent().build();
    }
    @PutMapping("/active/{id}")
    @Transactional
    public ResponseEntity activeTopic(@PathVariable Long id){
        Optional<Topics> topic = repository.findById(id);
        if (topic.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        topic.get().activeTopic();

        return ResponseEntity.ok(new TopicsReturnDTO(topic.get()));
    }
}
