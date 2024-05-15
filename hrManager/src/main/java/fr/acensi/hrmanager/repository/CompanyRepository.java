package fr.acensi.hrmanager.repository;

import fr.acensi.hrmanager.model.Company;
import org.springframework.data.repository.CrudRepository;

public interface CompanyRepository extends CrudRepository<Company, Long> {
}
