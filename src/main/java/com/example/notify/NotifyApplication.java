package com.example.notify;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import java.util.TimeZone;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@Slf4j
public class NotifyApplication {
	@PostConstruct
	public void started()
	{
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}
	public static void main(String[] args)
	{
		SpringApplication.run(NotifyApplication.class, args);

		log.trace("{} log", "TRACE");
		log.debug("{} log", "DEBUG");
		log.info("{} log", "INFO");
		log.warn("{} log", "WARN");
		log.error("{} log", "ERROR");
	}
}
