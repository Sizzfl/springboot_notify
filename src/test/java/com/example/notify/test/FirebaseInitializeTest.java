package com.example.notify.test;

import com.example.notify.config.FirebaseInitializer;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.io.InputStream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FirebaseInitializeTest
{
    @Autowired
    private FirebaseApp firebaseApp;

    @Test
    public void print()
    {
        System.out.println((firebaseApp != null) ? firebaseApp.toString() : "fb app is null");
    }
}
