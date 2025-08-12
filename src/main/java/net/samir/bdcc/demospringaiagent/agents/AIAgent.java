package net.samir.bdcc.demospringaiagent.agents;


import net.samir.bdcc.demospringaiagent.tools.AgentTools;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.client.advisor.vectorstore.QuestionAnswerAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.logging.Logger;

@Service
public class AIAgent {
    private final VectorStore vectorStore;
    private ChatClient chatClient;

    public AIAgent(ChatClient.Builder chatClient , ChatMemory chatMemory, AgentTools agentTools, VectorStore vectorStore) {
        this.chatClient = chatClient
                .defaultAdvisors(MessageChatMemoryAdvisor.builder(chatMemory).build())
                .defaultAdvisors(new SimpleLoggerAdvisor())
                .defaultAdvisors(new QuestionAnswerAdvisor(vectorStore))
                .defaultTools(agentTools)
                .build();
        this.vectorStore = vectorStore;
    }
  public Flux<String> onQuery(String query) {
        return chatClient.prompt()
                .user(query)
                .stream()
                .content();
  }
}
