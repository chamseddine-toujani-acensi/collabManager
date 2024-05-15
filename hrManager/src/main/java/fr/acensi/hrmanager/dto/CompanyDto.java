package fr.acensi.hrmanager.dto;

import fr.acensi.hrmanager.model.CompanyStatus;
import lombok.*;

import java.io.Serializable;

/**
 * DTO for {@link fr.acensi.hrmanager.model.Company}
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
    CompanyStatus status;
}