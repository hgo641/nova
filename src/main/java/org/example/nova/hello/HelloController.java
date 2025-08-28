package org.example.nova.hello;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String getHelloMessage() {
        return "HDC랩스 NOVA 수강생 여러분 안녕하세요!";
    }

    @GetMapping("/hello/json")
    public HelloResponse getJsonHelloMessage() {
        return new HelloResponse("HDC랩스 NOVA 수강생 여러분 안녕하세요! JSON 응답이에요.");
    }

    @GetMapping("/hello/json/response-entity")
    public ResponseEntity<HelloResponse> getJsonHelloMessageWithResponseEntity() {
        HelloResponse helloResponse = new HelloResponse("HDC랩스 NOVA 수강생 여러분 안녕하세요! JSON 응답이에요.");
        return ResponseEntity.ok(helloResponse);
    }
}
