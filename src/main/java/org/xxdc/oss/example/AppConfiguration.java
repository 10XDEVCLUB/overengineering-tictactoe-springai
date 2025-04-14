package org.xxdc.oss.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.invoke.MethodHandles;

@Configuration
public class AppConfiguration {

    private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Bean
    public CommandLineRunner runner(ChatClient.Builder builder) {
        return _ -> {
            var chatClient = builder.build();
            String response = chatClient
                    .prompt("Tell me a joke")
                    .call()
                    .content();
            log.info(response);
        };
    }
}
