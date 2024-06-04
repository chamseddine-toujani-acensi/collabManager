package fr.acensi.customer.customer;


import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CustomerMapper {
    public Customer toCustomer(CustomerRequest request) {
        if(Objects.isNull(request))
            return null;
        return Customer.builder()
                .id(request.id())
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .address(request.address())
                .build();
    }

    public CustomerResponse fromCustomer(Customer customer) {
        return new CustomerResponse(customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getAddress());
    }
}
