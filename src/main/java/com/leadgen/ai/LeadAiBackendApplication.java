package com.leadgen.ai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class LeadAiBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeadAiBackendApplication.class, args);
	}
}

// 🔥 ADD THIS BELOW (VERY IMPORTANT)
@RestController
class TestController {

	@GetMapping("/ping")
	public String ping() {
		return "pong";
	}
}