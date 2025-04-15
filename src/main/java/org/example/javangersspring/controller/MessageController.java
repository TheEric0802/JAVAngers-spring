package org.example.javangersspring.controller;

import org.example.javangersspring.model.Message;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    private List<Message> messages = new ArrayList<>();

    @GetMapping
    public String getMessages() {
        JSONObject jsonObject = new JSONObject();
        for (Message message : messages) {
            jsonObject.put("id", message.getId());
            jsonObject.put("name", message.getName());
            jsonObject.put("message", message.getMessage());
        }
        return jsonObject.toString();
    }

    @PostMapping
    public String postMessage(@RequestBody Message message) {
        messages.add(message);
        return "Message " + message.getId() + " posted";
    }

    @DeleteMapping("/{id}")
    public String deleteMessage(@PathVariable String id) {
        if (messages.removeIf(message -> message.getId().equals(id))) {
            return "Message " + id + " deleted";
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ID " + id + " not found");
    }
}
