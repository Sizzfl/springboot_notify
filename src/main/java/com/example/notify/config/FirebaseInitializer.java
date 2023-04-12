package com.example.notify.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;

@Configuration
public class FirebaseInitializer
{
    @Value("${app.firebase-adminsdk-key-file}")
    private String firebaseAdminSDKPath;

    @Bean
    public FirebaseApp firebaseApp() throws IOException
    {
        try
        {
            InputStream serviceAccount = new ClassPathResource(firebaseAdminSDKPath).getInputStream();
            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();

            return FirebaseApp.initializeApp(options);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
