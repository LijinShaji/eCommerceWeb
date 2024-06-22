package com.example.eCommerceWebsite.services;

import com.example.eCommerceWebsite.ECommerceWebsiteApplication;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

@Service
public class FirebaseInitialization {
    @PostConstruct
    public void initialize(){
        FileInputStream serviceAccount =
                null;
        try {
            serviceAccount = new FileInputStream("./eCommerceWebsite/src/main/resources/ServiceAccountKey.json");
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();
            FirebaseApp.initializeApp(options);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
