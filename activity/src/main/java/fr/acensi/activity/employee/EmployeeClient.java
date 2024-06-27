package fr.acensi.activity.employee;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(
        name = "employee-service",
        url = "${application.config.employee-url}"
)
public interface EmployeeClient {

    @GetMapping("/employee-id")
    Optional<EmployeeResponse> findEmployeeById(@PathVariable("employee-id") String employeeId);
}
