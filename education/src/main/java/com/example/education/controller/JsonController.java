package com.example.education.controller;


import com.example.education.model.MyRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JsonController {

    @PostMapping("/json")
    public ResponseEntity<Object> ProcessJson(@RequestBody MyRequest request) {
        request.getInfo().put("id", 123);
        return ResponseEntity.ok(request);
    }
}
