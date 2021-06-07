package com.github.osmundf.tpc.application;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class EchoController {

    @PostMapping("/echo")
    public HttpEntity<String> postEcho(@RequestBody String body) {
        return ResponseEntity.ok(body);
    }
}
