package fr.acensi.notification.kafka.activity;

import fr.acensi.notification.kafka.payment.PaymentMethod;

import java.math.BigDecimal;
import java.util.List;

public record ActivityConfirmation(
    String activityReference,
    BigDecimal amount,
    PaymentMethod paymentMethod,
    Customer customer,
    Mission mission
) {
}
