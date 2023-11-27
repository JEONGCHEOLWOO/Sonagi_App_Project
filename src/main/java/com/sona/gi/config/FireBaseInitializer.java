//package com.sona.gi.config;
//
//import com.google.auth.oauth2.GoogleCredentials;
//import com.google.firebase.FirebaseApp;
//import com.google.firebase.FirebaseOptions;
//import java.io.IOException;
//import javax.annotation.PostConstruct;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.stereotype.Service;
//
//
//@Service
//public class FireBaseInitializer {
//// 초기화 코드
//    @Value("${firebase-configuration-file}")
//    private String firebaseConfigPath;
//
//    private static final org.slf4j.Logger log
//            = org.slf4j.LoggerFactory.getLogger(FireBaseInitializer.class);
//
//    @PostConstruct
//    public void initialize() {
//        try {
//            FirebaseOptions options = new FirebaseOptions.Builder().setCredentials(
//                    GoogleCredentials.fromStream(
//                            new ClassPathResource(firebaseConfigPath).getInputStream())).build();
//            if (FirebaseApp.getApps().isEmpty()) {
//                FirebaseApp.initializeApp(options);
//                log.info("Firebase application has been initialized");
//            }
//        } catch (IOException e) {
//            log.error(e.getMessage());
//        }
//
//    }
//}