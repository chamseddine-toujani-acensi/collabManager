package fr.acensi.hrmanager.service.impl;

import fr.acensi.hrmanager.dto.CompanyDto;
import fr.acensi.hrmanager.model.Company;
import fr.acensi.hrmanager.repository.CompanyRepository;
import fr.acensi.hrmanager.service.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository;

    /**
     * @param companyDto
     * @return
     */
    @Override
    public Company save(CompanyDto companyDto) {
        Company company = Company.builder()
                .name(companyDto.getName())
                .phone(companyDto.getPhone())
                .email(companyDto.getEmail())
                .address(companyDto.getAddress())
                .status(companyDto.getStatus())
                .build();
        return companyRepository.save(company);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Company findById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }
}
