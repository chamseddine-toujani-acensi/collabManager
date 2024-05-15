package fr.acensi.hrmanager.service.impl;

import fr.acensi.hrmanager.model.Account;
import fr.acensi.hrmanager.repository.AccountRepository;
import fr.acensi.hrmanager.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    public Account register(Account account) {
        return accountRepository.save(account);
    }

    public String getInfo(Long id) {
        return accountRepository.findById(id).toString();
    }
}
