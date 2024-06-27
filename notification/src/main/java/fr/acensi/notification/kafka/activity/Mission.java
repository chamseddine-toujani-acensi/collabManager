package fr.acensi.notification.kafka.activity;

import java.math.BigDecimal;
import java.time.LocalDate;

public record Mission(
        Integer id,
        String title,
        String description,
        LocalDate startDate,
        LocalDate endDate,
        BigDecimal tjm,
        String address,
        String phone,
        String email
) {
}
