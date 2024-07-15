package com.example.forum_hub.repository;

import com.example.forum_hub.model.classes.Topics;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topics, Long> {
    Page<Topics> findAllByStatusTrue(Pageable pageable);



}
