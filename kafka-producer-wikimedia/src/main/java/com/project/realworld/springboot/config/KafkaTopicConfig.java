package com.project.realworld.springboot.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

   // private @Value("${wikimedia.topic.name}") String topicName;

    @Bean
    public NewTopic topic() {
        return TopicBuilder.name("wikimedia_recentchange").build();
    }
}