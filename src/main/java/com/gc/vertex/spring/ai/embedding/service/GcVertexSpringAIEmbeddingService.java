package com.gc.vertex.spring.ai.embedding.service;

import org.springframework.ai.embedding.EmbeddingResponse;
import org.springframework.ai.vertexai.embedding.VertexAiEmbeddingConnectionDetails;
import org.springframework.ai.vertexai.embedding.text.VertexAiTextEmbeddingModel;
import org.springframework.ai.vertexai.embedding.text.VertexAiTextEmbeddingOptions;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GcVertexSpringAIEmbeddingService {

    private final VertexAiEmbeddingConnectionDetails vertexAiEmbeddingConnectionDetails;

    public GcVertexSpringAIEmbeddingService(VertexAiEmbeddingConnectionDetails vertexAiEmbeddingConnectionDetails) {
        this.vertexAiEmbeddingConnectionDetails = vertexAiEmbeddingConnectionDetails;
    }

    public Map<String, EmbeddingResponse> embed(String message) {
        VertexAiTextEmbeddingOptions options = VertexAiTextEmbeddingOptions.builder()
                .model(VertexAiTextEmbeddingOptions.DEFAULT_MODEL_NAME)
                .build();

        var embeddingModel = new VertexAiTextEmbeddingModel(this.vertexAiEmbeddingConnectionDetails, options);

        EmbeddingResponse embeddingResponse = embeddingModel.embedForResponse(List.of(message));
        return Map.of("embedding", embeddingResponse);
    }
}
