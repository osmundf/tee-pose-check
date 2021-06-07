package com.github.osmundf.tpc.application;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.atomic.AtomicInteger;

@Controller
@RequestMapping("/api")
public class CounterController {

    private final AtomicInteger value = new AtomicInteger(0);

    private final JsonNodeFactory factory = new JsonNodeFactory(true);

    @GetMapping("/reset")
    public HttpEntity<JsonNode> getReset() {
        value.set(0);
        final var base = factory.objectNode();
        base.set("count", factory.numberNode(value.intValue()));
        return ResponseEntity.ok().body(base);
    }

    @PostMapping("/counter")
    public HttpEntity<JsonNode> postEcho(@RequestBody ObjectNode body) {
        final var id = value.incrementAndGet();
        body.put("_id", id);
        return ResponseEntity.ok().body(body);
    }
}
