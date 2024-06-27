package fr.acensi.activity.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaActivityTopicConfig {

    @Bean
    public NewTopic activityTopic() {
        return TopicBuilder
                .name("activity-topic")
                .build();
    }
}
