package fr.acensi.stuff.employee;

public record EmployeeResponse(
        Integer id,
        String firstName,
        String lastName,
        String email
) {
}
