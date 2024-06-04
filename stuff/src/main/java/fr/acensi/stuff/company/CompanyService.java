package fr.acensi.stuff.company;

import fr.acensi.stuff.dto.CompanyDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CompanyService {

    private CompanyRepository companyRepository;

    public Company save(CompanyDto companyDto) {
        Company company = Company.builder()
                .name(companyDto.getName())
                .phone(companyDto.getPhone())
                .email(companyDto.getEmail())
                .address(companyDto.getAddress())
                .build();
        return companyRepository.save(company);
    }

    public Company findById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }
}
