package com.example.forum_hub.controller;

import com.example.forum_hub.service.TokenService;
import com.example.forum_hub.model.dto.LoginDTO;
import com.example.forum_hub.model.classes.Profiles;
import com.example.forum_hub.model.dto.TokenDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid LoginDTO login){
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(login.login(), login.password());
        Authentication auth = manager.authenticate(token);
        String tokenJWT = tokenService.genToken((Profiles) auth.getPrincipal());

        return ResponseEntity.ok(new TokenDto(tokenJWT));
    }
}
