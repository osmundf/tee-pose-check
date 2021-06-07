package com.github.osmundf.tpc.application;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class GreetingController {

    private final JsonNodeFactory factory = new JsonNodeFactory(true);

    @PostMapping("/greeting")
    public HttpEntity<JsonNode> postGreeting(@RequestBody JsonNode body) {
        final var response = factory.objectNode();
        response.put("message", String.format("Hello %s!", body.get("name").asText()));
        return ResponseEntity.ok(response);
    }
}
