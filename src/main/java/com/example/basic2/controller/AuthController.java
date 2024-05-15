package com.example.basic2.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @PostMapping("/verifyToken")
    public ResponseEntity<String> verifyToken(@RequestBody String idToken) {
        System.out.println("verifyToken"+idToken);
        System.err.println();
        try {
            FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(idToken);
            return ResponseEntity.ok("UID: " + decodedToken.getUid());
        } catch (FirebaseAuthException e) {
            return ResponseEntity.badRequest().body("Invalid token");
        }
    }
}
