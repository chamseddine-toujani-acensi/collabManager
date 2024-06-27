package fr.acensi.employee;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/stuff/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private EmployeeService service;


    @PostMapping
    public ResponseEntity<Integer> createEmployee(@RequestBody @Valid EmployeeRequest request) {
        return ResponseEntity.ok(service.createEmployee(request));
    }

    @PutMapping
    public ResponseEntity<Void> updateEmployee(@RequestBody @Valid EmployeeRequest request) {
        service.updateEmployee(request);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public ResponseEntity<List<EmployeeResponse>> findAll() {
        return ResponseEntity.ok(service.findAllEmployees());
    }

    @GetMapping("/exists/{employee-id}")
    public ResponseEntity<Boolean> existsById(@PathVariable("employee-id") Integer employeeId) {
        return ResponseEntity.ok(service.existsById(employeeId));
    }

    @GetMapping("/{employee-id}")
    public ResponseEntity<EmployeeResponse> findById(@PathVariable("employee-id") Integer employeeId) {
        return ResponseEntity.ok(service.findById(employeeId));
    }

    @DeleteMapping("/{employee-id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable("employee-id") Integer employeeId) {
        service.deleteEmployee(employeeId);
        return ResponseEntity.accepted().build();
    }

}
