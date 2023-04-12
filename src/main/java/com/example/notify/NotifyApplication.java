package com.example.notify;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import java.util.TimeZone;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class NotifyApplication {
	@PostConstruct
	public void started()
	{
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}
	public static void main(String[] args) {
		SpringApplication.run(NotifyApplication.class, args);
	}
}
