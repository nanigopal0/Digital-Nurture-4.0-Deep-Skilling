package com.cognizant.spring_learn.controller;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.*;

@RestController
public class AuthenticationController {

    private static final Logger log = LoggerFactory.getLogger(AuthenticationController.class);

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
        log.debug("Start");
        Map<String, String> map = new HashMap<>();
        log.debug("authHeader : {}", authHeader);
        String user = getUser(authHeader);
        log.debug("user : {}", user);
        Optional<? extends GrantedAuthority> role = SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream().findFirst();
        String token = generateJwt(user,role.get().getAuthority());
        map.put("token", token);
        log.debug("End");
        return map;
    }

    private String getUser(String authHeader) {
        String enccred = authHeader.substring(6);
        byte[] decode = Base64.getDecoder().decode(enccred);
        String cred = new String(decode);
        return cred.substring(0, cred.indexOf(':'));
    }

    private String generateJwt(String user,String role) {
        JwtBuilder builder = Jwts.builder();
        builder.setSubject(user);

        // Set the token issue time as current time
        builder.setIssuedAt(new Date());
        builder.claim("role",role);
        // Set the token expiry as 20 minutes from now
        builder.setExpiration(new Date((new Date()).getTime() + 1200000));
        builder.signWith(SignatureAlgorithm.HS256, Keys.hmacShaKeyFor("most secret key for jwt: abc123xyz123".getBytes(StandardCharsets.UTF_8)));

        String token = builder.compact();

        return token;

    }
}
