package com.gc.vertex.spring.ai.embedding.controller;

import com.gc.vertex.spring.ai.embedding.service.GcVertexSpringAIEmbeddingService;
import org.springframework.ai.embedding.EmbeddingResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/embeddings")
public class GcVertexSpringAIEmbeddingController {

    private final GcVertexSpringAIEmbeddingService gcVertexSpringAIEmbeddingService;

    public GcVertexSpringAIEmbeddingController(GcVertexSpringAIEmbeddingService gcVertexSpringAIEmbeddingService) {
        this.gcVertexSpringAIEmbeddingService = gcVertexSpringAIEmbeddingService;
    }

    @GetMapping("/texts")
    public Map<String, EmbeddingResponse> embed(@RequestParam String message) {
        return gcVertexSpringAIEmbeddingService.embed(message);
    }
}
