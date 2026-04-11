package com.leadgen.ai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.leadgen.ai")   // ✅ IMPORTANT FIX
public class LeadAiBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeadAiBackendApplication.class, args);
	}
}