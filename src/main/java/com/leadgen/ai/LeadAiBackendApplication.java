package com.leadgen.ai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
public class LeadAiBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeadAiBackendApplication.class, args);
	}
}

// 🔥 FORCE CONTROLLER HERE (INSIDE SAME FILE)
@RestController
@RequestMapping("/api")
class TestController {

	@GetMapping("/test")
	public String test() {
		return "Backend working 🚀";
	}
}