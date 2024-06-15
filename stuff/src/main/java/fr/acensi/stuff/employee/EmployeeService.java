package fr.acensi.stuff.employee;

import fr.acensi.stuff.exception.EmployeeNotFoundException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository repository;
    private final EmployeeMapper mapper;

    public Integer createEmployee(EmployeeRequest request) {
        var employee = repository.save(mapper.toEntity(request));
        return employee.getId();
    }

    public void updateEmployee(EmployeeRequest request) {
        var employee = repository.findById(request.id())
                .orElseThrow(()-> new EmployeeNotFoundException(format("Can not update employee with id : %s", request.id())));
        mergeEmployee(employee,request);
        repository.save(employee);
    }

    private void mergeEmployee(Employee employee, EmployeeRequest request) {
        if(StringUtils.isNotBlank(request.firstName()))
            employee.setFirstName(request.firstName());
        if(StringUtils.isNotBlank(request.lastName()))
            employee.setFirstName(request.lastName());
        if(StringUtils.isNotBlank(request.email()))
            employee.setEmail(request.email());
        if(Objects.nonNull(request.address()))
            employee.setAddress(request.address());
    }

    public List<EmployeeResponse> findAllEmployees() {
        return repository.findAll()
                .stream()
                .map(mapper::fromEmployee)
                .collect(Collectors.toList());
    }

    public Boolean existsById(Integer employeeId) {
        return repository.findById(employeeId).isPresent();
    }

    public EmployeeResponse findById(Integer employeeId) {
        return repository.findById(employeeId)
                .map(mapper::fromEmployee)
                .orElseThrow(() -> new EmployeeNotFoundException(format("No employee found with provided id: %s", employeeId)));

    }

    public void deleteEmployee(Integer employeeId) {
        repository.deleteById(employeeId);
    }
}
