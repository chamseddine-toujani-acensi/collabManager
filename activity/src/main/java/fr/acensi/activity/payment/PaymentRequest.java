package fr.acensi.activity.payment;

import fr.acensi.activity.activity.ActivityResponse;
import fr.acensi.activity.collaborator.CollaboratorResponse;
import fr.acensi.activity.customer.CustomerResponse;
import fr.acensi.activity.employee.EmployeeResponse;
import fr.acensi.activity.mission.MissionResponse;

import java.math.BigDecimal;

public record PaymentRequest(
        BigDecimal amount,
        String paymentMethod,
        ActivityResponse activity,
        CustomerResponse customer,
        MissionResponse mission,
        CollaboratorResponse collaborator,
        EmployeeResponse employee
) {
}
