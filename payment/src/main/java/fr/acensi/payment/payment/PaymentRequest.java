package fr.acensi.payment.payment;


import java.math.BigDecimal;

public record PaymentRequest(
        Integer id,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer activityId,
        Integer customerId,
        Integer missionId,
        Integer collaboratorId,
        Integer employeeId
) {
}
