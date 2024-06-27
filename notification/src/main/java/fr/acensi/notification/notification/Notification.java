package fr.acensi.notification.notification;

import fr.acensi.notification.kafka.activity.ActivityConfirmation;
import fr.acensi.notification.kafka.payment.PaymentConfirmation;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Document
public class Notification {

    @Id
    private String id;
    private NotificationType type;
    private LocalDateTime notificationDate;
    private ActivityConfirmation activityConfirmation;
    private PaymentConfirmation paymentConfirmation;
}
