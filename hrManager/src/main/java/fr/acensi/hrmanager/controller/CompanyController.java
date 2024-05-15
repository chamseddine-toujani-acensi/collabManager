package fr.acensi.hrmanager.controller;

import fr.acensi.hrmanager.dto.CompanyDto;
import fr.acensi.hrmanager.model.Company;
import fr.acensi.hrmanager.service.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/company")
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class CompanyController {

    private final CompanyService companyService;

    // Create a new company
    @PostMapping("/")
    public CompanyDto createCompany(@RequestBody CompanyDto companyDto) {
        companyService.save(companyDto);
        return companyDto;
    }

    // Get a company by ID
    @GetMapping("/{id}")
    public CompanyDto getCompany(@PathVariable Long id) {
        Company company = companyService.findById(id);
        return CompanyDo.builder().build();
    }

    // Update a company
    @PutMapping("/{id}")
    public CompanyDto updateCompany(@PathVariable Long id, @RequestBody CompanyDto companyDto) {
        // Update company details based on DTO
        // Example: Company existingCompany = companyService.findById(id);
        // existingCompany.setName(companyDto.getName());
        // companyService.save(existingCompany);
        return companyDto;
    }

    // Delete a company
    @DeleteMapping("/{id}")
    public void deleteCompany(@PathVariable Long id) {
        // Delete company by ID
        // Example: companyService.deleteById(id);
    }
}
