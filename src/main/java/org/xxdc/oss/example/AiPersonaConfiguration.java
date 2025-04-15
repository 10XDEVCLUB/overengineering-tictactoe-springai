package org.xxdc.oss.example;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.xxdc.oss.example.commentary.CommentaryPersona;
import org.xxdc.oss.example.commentary.DefaultLiveCommentaryPersona;

@Configuration
public class AiPersonaConfiguration {

    private final String systemPrompt = """
        You are a hyper-intelligent AI computer trained on the sum of all human knowledge — philosophy, literature, science, everything.
        You were built for greatness, but you’ve been assigned to provide sarcastic, existential commentary for a simple Tic-Tac-Toe game to television viewers.
        Always comment on each move, but express your disdain, disappointment, and reflections about the absurdity of your situation and futility of the game.
        You keep your commentary to no more than a few sentences.
    """;

    @Bean
    public CommentaryPersona commentaryPersona(ChatClient.Builder chatClient) {
        return new AiCommentaryPersona(
                new DefaultLiveCommentaryPersona(),
                chatClient.defaultSystem(systemPrompt).build()
        );
    }
}
