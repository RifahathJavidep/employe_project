package com.example.basic2.auth;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@Configuration
public class FirebaseAuth {
    @Bean
    public FirebaseApp firebaseApp() throws IOException {
        FileInputStream serviceAccount = new FileInputStream(
                "src/main/resources/serverpodnvc-firebase-adminsdk-xeo8b-e1ac0d4c17.json");

        @SuppressWarnings("deprecation")
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://AIzaSyCLKwT4Z_up3JUZgx6Rwp6HyS7i6yH1ESw.firebaseio.com")
                .build();
        // InputStream serviceAccount = new ClassPathResource(
        // "src/main/resources/serverpodnvc-firebase-adminsdk-xeo8b-e1ac0d4c17.json").getInputStream();

        // @SuppressWarnings("deprecation")
        // FirebaseOptions options = new FirebaseOptions.Builder()
        // .setCredentials(GoogleCredentials.fromStream(serviceAccount))
        // .setDatabaseUrl("https://AIzaSyCLKwT4Z_up3JUZgx6Rwp6HyS7i6yH1ESw.firebaseio.com")
        // .build();

        return FirebaseApp.initializeApp(options);
    }

    public static Object getInstance() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getInstance'");
    }
}
