package com.camel.HelmKubernetesTest;

//import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Configuration
@SpringBootApplication
public class HelmKubernetesTestApplication {

	@Value("${myapp.message}")
	private String message;

	public static void main(String[] args) {
		SpringApplication.run(HelmKubernetesTestApplication.class, args);
	}

//	@PostConstruct
//	private void init() throws InterruptedException {
//		while(true){
//			LocalDateTime now = LocalDateTime.now();
//			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//			String formattedNow=now.format(formatter);
//			System.out.println(formattedNow + " - " + message);
//			Thread.sleep(1000);
//		}
//	}

}
