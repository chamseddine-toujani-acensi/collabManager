package fr.acensi.employee;

public record EmployeeResponse(
        Integer id,
        String firstName,
        String lastName,
        String email
) {
}
