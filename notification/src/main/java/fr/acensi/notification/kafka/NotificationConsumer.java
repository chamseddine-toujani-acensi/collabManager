package fr.acensi.notification.kafka;

import fr.acensi.notification.email.EmailService;
import fr.acensi.notification.kafka.activity.ActivityConfirmation;
import fr.acensi.notification.kafka.payment.PaymentConfirmation;
import fr.acensi.notification.notification.Notification;
import fr.acensi.notification.notification.NotificationRepository;
import fr.acensi.notification.notification.NotificationType;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationConsumer {

    private final NotificationRepository repository;
    private final EmailService emailService;

    @KafkaListener(topics = "payment-topic")
    public void consumePaymentConfirmationNotification(PaymentConfirmation paymentConfirmation) throws MessagingException {
        log.info(String.format("Consuming message from payment topic:: %s", paymentConfirmation));
        repository.save(
                Notification.builder()
                        .type(NotificationType.PAYMENT_CONFIRMATION)
                        .notificationDate(LocalDateTime.now())
                        .paymentConfirmation(paymentConfirmation)
                        .build()
        );

        // send email
        var customer = paymentConfirmation.firstName() + " " + paymentConfirmation.lastName();
        emailService.sendPaymentSuccessEmail(
                paymentConfirmation.email(),
                customer,
                paymentConfirmation.amount(),
                paymentConfirmation.activityReference()
        );
    }

    @KafkaListener(topics = "activity-topic")
    public void consumeActivityConfirmationNotification(ActivityConfirmation activityConfirmation) throws MessagingException {
        log.info(String.format("Consuming message from activity topic:: %s", activityConfirmation));
        repository.save(
                Notification.builder()
                        .type(NotificationType.ACTIVITY_CONFIRMATION)
                        .notificationDate(LocalDateTime.now())
                        .activityConfirmation(activityConfirmation)
                        .build()
        );

        // send email
        var customer = activityConfirmation.customer().firstName() + " "
                + activityConfirmation.customer().lastName();
        emailService.sendActivityConfirmationEmail(
                activityConfirmation.customer().email(),
                customer,
                activityConfirmation.amount(),
                activityConfirmation.activityReference()
        );
    }

}
