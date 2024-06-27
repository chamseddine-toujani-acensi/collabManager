package fr.acensi.payment.payment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface paymentRepository extends JpaRepository<Payment,Integer> {
}
