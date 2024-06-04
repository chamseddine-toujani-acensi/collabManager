package fr.acensi.mission.mission;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record MissionRequest(
        Integer id,
        @NotNull(message = "Mission should have a valid title")
        String title,
        @NotNull(message = "Mission should have a valid description")
        String description,
        String startDate,
        String endDate,
        @NotNull(message = "Mission should have a valid status")
        String status,
        @NotNull(message = "Mission should have a valid category")
        Integer categoryId,
        @Positive(message = "Mission should have a valid tgm")
        BigDecimal tgm,
        String address,
        String phone,
        String email
) {
}
