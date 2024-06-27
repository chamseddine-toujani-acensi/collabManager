package fr.acensi.activity.activity;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ActivityProducer {

    private final KafkaTemplate<String, ActivityConfirmation> kafkaTemplate;

    public void sendActivityConfirmation(ActivityConfirmation activityConfirmation) {
        log.info("Sending activity confirmation{}", activityConfirmation.toString());
        Message<ActivityConfirmation> message = MessageBuilder
                .withPayload(activityConfirmation)
                .setHeader(KafkaHeaders.TOPIC,"activity-topic")
                .build();
        kafkaTemplate.send(message);
    }

}
