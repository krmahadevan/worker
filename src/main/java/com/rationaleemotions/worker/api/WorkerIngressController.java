package com.rationaleemotions.worker.api;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/worker")
public class WorkerIngressController {

    @GetMapping(path = "/greet", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Greeting> greeting() {
        return ResponseEntity.ok(new Greeting(UUID.randomUUID().toString()));
    }

    public record Greeting(String message) {
    }
}
