package com.tcc.iot_mc_api.service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;

@Service
public class FirebaseConfig {
    
    @PostConstruct
    public void initialize() {
        try {
            FileInputStream serviceAccount = 
                new FileInputStream("iot-mc-api/src/main/resources/api-iot-microcontroller-firebase-adminsdk-fbsvc-7b2892625e.json");
            
            FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://api-iot-microcontroller-default-rtdb.firebaseio.com/")
                .build();
            
            FirebaseApp.initializeApp(options);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}