package fr.acensi.notification.kafka.payment;

import java.math.BigDecimal;

public record PaymentConfirmation(
        String activityReference,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        String firstName,
        String lastName,
        String email,
        String address
) {
}
