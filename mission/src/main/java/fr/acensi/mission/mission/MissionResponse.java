package fr.acensi.mission.mission;

import fr.acensi.mission.category.Category;

import java.math.BigDecimal;
import java.time.LocalDate;

public record MissionResponse(
        Integer id,
        String title,
        String description,
        String startDate,
        String endDate,
        Status status,
        String category,
        BigDecimal tjm,
        String address,
        String phone,
        String email
) {
}
