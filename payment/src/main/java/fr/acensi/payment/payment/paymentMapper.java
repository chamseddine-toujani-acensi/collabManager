package fr.acensi.payment.payment;

import org.springframework.stereotype.Service;

@Service
public class paymentMapper {
    public Payment toPayment(PaymentRequest request) {
        return Payment
                .builder()
                .id(request.id())
                .amount(request.amount())
                .paymentMethod(request.paymentMethod())
                .build();
    }
}
