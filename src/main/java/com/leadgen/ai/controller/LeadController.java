package com.leadgen.ai.controller;

import com.leadgen.ai.service.LeadAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")   // ✅ ADD THIS LINE
public class LeadController {

    @Autowired
    private LeadAnalysisService service;

    @GetMapping("/test")
    public String test() {
        return "Backend working 🚀";
    }

    @PostMapping("/generate")
    public String generate(@RequestBody Map<String, String> request) {
        return service.process(request.get("message"));
    }
}