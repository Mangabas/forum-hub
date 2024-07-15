package com.example.forum_hub.repository;

import com.example.forum_hub.model.classes.Profiles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface ProfileRepository extends JpaRepository<Profiles, Long> {
    UserDetails findByLogin(String login);
}
