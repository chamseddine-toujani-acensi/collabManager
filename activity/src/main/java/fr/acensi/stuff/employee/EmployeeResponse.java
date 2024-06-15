package fr.acensi.stuff.employee;

public record EmployeeResponse(
        String id,
        String firstName,
        String lastName,
        String email
) {
}
