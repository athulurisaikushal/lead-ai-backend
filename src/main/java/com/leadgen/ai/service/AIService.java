package com.leadgen.ai.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Map;

@Service
public class AIService {

    @Value("${openai.api.key}")
    private String apiKey;

    private final WebClient webClient = WebClient.create("https://api.openai.com");

    // ✅ Add this
    private final ObjectMapper mapper = new ObjectMapper();

    public String generateReply(String message) {

        Map<String, Object> body = Map.of(
                "model", "gpt-4o-mini",
                "messages", List.of(
                        Map.of("role", "user", "content", message)
                )
        );

        try {
            String response = webClient.post()
                    .uri("/v1/chat/completions")
                    .header("Authorization", "Bearer " + apiKey)
                    .header("Content-Type", "application/json")
                    .bodyValue(body)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            // ✅ Parse JSON
            JsonNode jsonNode = mapper.readTree(response);

            // ✅ Extract only AI text
            return jsonNode
                    .get("choices")
                    .get(0)
                    .get("message")
                    .get("content")
                    .asText();

        } catch (Exception e) {
            e.printStackTrace();
            return "⚠️ AI service error";
        }
    }
}