package org.example.nova.message.controller;

import org.example.nova.message.dto.MessageCreateRequest;
import org.example.nova.message.dto.MessageResponse;
import org.example.nova.message.service.MessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/messages")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<MessageResponse> getMessage(@PathVariable Long id) {
        MessageResponse messageResponse = messageService.getMessage(id);
        return ResponseEntity.ok(messageResponse);
    }

    @PostMapping
    public ResponseEntity<Void> createMessage(@RequestBody
                                              MessageCreateRequest messageCreateRequest, UriComponentsBuilder uriBuilder) {
        Long messageId = messageService.createMessage(messageCreateRequest);
        return ResponseEntity.created(uriBuilder.path("/messages/" + messageId)
                        .build()
                        .toUri()
                ).build();
    }
}
