package fr.acensi.hrmanager.service;

import fr.acensi.hrmanager.dto.CompanyDto;
import fr.acensi.hrmanager.model.Company;

import java.io.Serializable;

public interface CompanyService extends Serializable {
    Company save(CompanyDto companyDto);

    Company findById(Long id);
}
