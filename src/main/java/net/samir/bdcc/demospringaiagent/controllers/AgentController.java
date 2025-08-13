package net.samir.bdcc.demospringaiagent.controllers;

import net.samir.bdcc.demospringaiagent.agents.AIAgent;
import net.samir.bdcc.demospringaiagent.rag.DocumentIndexor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Flux;

import java.io.IOException;


@RestController
@CrossOrigin("*")
public class AgentController {

    private AIAgent agent;


    public AgentController(AIAgent agent ) {
        this.agent = agent;
    }

    @GetMapping(value = "/askAgent", produces = MediaType.TEXT_PLAIN_VALUE)
    public Flux<String> askAgent(@RequestParam(defaultValue = "Hello") String query) {
        return agent.onQuery(query);
    }

}