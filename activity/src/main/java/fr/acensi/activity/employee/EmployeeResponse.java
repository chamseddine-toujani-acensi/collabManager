package fr.acensi.activity.employee;

public record EmployeeResponse(
        String id,
        String firstName,
        String lastName,
        String email
) {
}
