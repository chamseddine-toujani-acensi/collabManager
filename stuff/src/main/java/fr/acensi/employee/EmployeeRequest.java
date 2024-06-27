package fr.acensi.employee;

public record EmployeeRequest(
        Integer id,
        String firstName,
        String lastName,
        String email,
        String phone,
        String address,
        String city,
        String state,
        String country,
        String zip
) {
}
