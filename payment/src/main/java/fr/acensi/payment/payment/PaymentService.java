package fr.acensi.payment.payment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final paymentRepository repository;
    private final paymentMapper mapper;
    private final PaymentProducer producer;

    public Integer createPayment(PaymentRequest request) {
        var payment = repository.save(mapper.toPayment(request));

        producer.sendPaymentNotification(new PaymentNotificationRequest(
                request.activityId().toString(),
                request.amount(),
                request.paymentMethod(),
                request.customerId().toString(),
                request.collaboratorId().toString(),
                request.customerId().toString(),
                request.collaboratorId().toString()
        ));

        return payment.getId();
    }
}
