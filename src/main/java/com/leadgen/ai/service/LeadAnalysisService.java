package com.leadgen.ai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeadAnalysisService {

    @Autowired
    private AIService aiService;

    public String process(String message) {
        return aiService.generateReply(message);
    }
}