package com.example.forum_hub.repository;

import com.example.forum_hub.model.Topics;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Range;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TopicRepository extends JpaRepository<Topics, Long> {
    Page<Topics> findAllByStatusTrue(Pageable pageable);



}
