package fr.acensi.hrmanager.service;

import fr.acensi.hrmanager.model.Account;

import java.io.Serializable;


public interface AccountService extends Serializable {
    Account register(Account account);
    String getInfo(Long id);
}
