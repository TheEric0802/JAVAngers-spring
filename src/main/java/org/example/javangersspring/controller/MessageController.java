package org.example.javangersspring.controller;

import org.example.javangersspring.model.Message;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    private List<Message> messages = new ArrayList<>();

    @GetMapping
    public String getMessages() {
        StringBuilder result = new StringBuilder("There are following messages:\n");
        for (Message message : messages) {
            result.append(message.getId()).append(": ").append(message.getName()).append(": ").append(message.getMessage()).append("\n");
        }
        return result.toString();
    }

    @PostMapping
    public String postMessage(@RequestBody Message message) {
        messages.add(message);
        return "Message " + message.getId() + " posted";
    }

    @DeleteMapping("/{id}")
    public String deleteMessage(@PathVariable String id) {
        messages.removeIf(message -> message.getId().equals(id));
        return "Message " + id + " deleted";
    }
}
