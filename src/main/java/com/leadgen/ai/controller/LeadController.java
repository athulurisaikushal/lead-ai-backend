package com.leadgen.ai.controller;

import com.leadgen.ai.service.LeadAnalysisService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class LeadController {

    private final LeadAnalysisService service;

    // ✅ constructor injection
    public LeadController(LeadAnalysisService service) {
        this.service = service;
    }

    @GetMapping("/test")
    public String test() {
        return "Backend working 🚀";
    }

    @PostMapping("/generate")
    public String generate(@RequestBody Map<String, String> request) {
        return service.process(request.get("message"));
    }
}