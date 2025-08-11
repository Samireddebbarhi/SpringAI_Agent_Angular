package net.samir.bdcc.demospringaiagent.controllers;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;


@RestController
@CrossOrigin("*")
public class AgentController {
    private ChatClient chatClient;


    public AgentController(ChatClient.Builder chatClient) {
        this.chatClient = chatClient.build();
    }
    @GetMapping(value="/askAgent",produces = MediaType.TEXT_PLAIN_VALUE)
    public Flux<String> askAgent(@RequestParam(defaultValue = "Hello") String query) {
        return chatClient.prompt()
                .user(query)
                .stream()
                .content();
    }
}
