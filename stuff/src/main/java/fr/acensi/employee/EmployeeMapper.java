package fr.acensi.employee;


import org.springframework.stereotype.Service;

@Service
public class EmployeeMapper {
    public Employee toEntity(EmployeeRequest request) {
        return Employee.builder()
                .id(request.id())
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .phone(request.phone())
                .address(request.address())
                .city(request.city())
                .state(request.state())
                .country(request.country())
                .zip(request.zip())
                .build();
    }

    public EmployeeResponse fromEmployee(Employee employee) {
        return new EmployeeResponse(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getEmail());
    }
}
