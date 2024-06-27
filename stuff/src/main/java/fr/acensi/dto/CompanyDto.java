package fr.acensi.dto;

import fr.acensi.company.Company;
import lombok.*;

import java.io.Serializable;

/**
 * DTO for {@link Company}
 */
@Value
@Data
@Builder
@AllArgsConstructor
public class CompanyDto implements Serializable {
    Long id;
    String name;
    String address;
    String phone;
    String email;
}