package fr.acensi.payment.payment;

import java.math.BigDecimal;

public record PaymentNotificationRequest(
        String activityReference,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        String firstName,
        String lastName,
        String email,
        String address
) {
}
