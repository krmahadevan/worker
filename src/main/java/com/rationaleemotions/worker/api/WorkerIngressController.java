package com.rationaleemotions.worker.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/worker")
@Slf4j
public class WorkerIngressController {

    @CrossOrigin("*")
    @GetMapping(path = "/greet", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Greeting> greeting(@RequestHeader Map<String, String> headers) {
        HttpHeaders outgoingHeaders = new HttpHeaders();
        outgoingHeaders.set("X-Worker-Id", UUID.randomUUID().toString());
        headers.forEach(outgoingHeaders::set);
        ResponseEntity<Greeting> reply = ResponseEntity.ok()
                .headers(outgoingHeaders)
                .body(new Greeting("Greetings from worker " + UUID.randomUUID()));
        log.info("Reply: {}", reply);
        return reply;
    }

    public record Greeting(String message) {
    }
}
