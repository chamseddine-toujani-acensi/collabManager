package fr.acensi.activity.activity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;

public record ActivityRequest(
        int id,

        @NotNull(message = "Reference is required")
        String reference,

        @NotEmpty(message = "Description is required")
        @NotBlank(message = "Description is required")
        @Length(max = 250,message = "Description length is wrong")
        String description,

        @NotEmpty(message = "Payment method is required")
        @NotBlank(message = "Payment method is required")
        String paymentMethod,

        @Positive(message = "Payment amount is required")
        @NotNull(message = "Payment amount is required")
        BigDecimal amount,

        @NotNull(message = "Customer is required")
        String customerId,

        @NotNull(message = "Mission is required")
        String missionId,

        @NotNull(message = "Collaborator is required")
        String collaboratorId,

        @NotNull(message = "Employee is required")
        String employeeId
) {
}
