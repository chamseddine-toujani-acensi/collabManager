package fr.acensi.dto.mapper;

import fr.acensi.account.Account;
import fr.acensi.account.Status;
import fr.acensi.dto.AccountDto;
import fr.acensi.account.Role;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountMapper {

    public Optional<AccountDto> mapAccount(Optional<Account> account) {
        return account.map(value -> AccountDto.builder()
                .id(value.getId())
                .login(value.getLogin())
                .password(value.getPassword())
                .status(value.getStatus().name())
                .role(value.getRole().name())
                .build());
    }

    public Account mapAccountDto(AccountDto accountDto) {
        return Account.builder()
                .id(accountDto.getId())
                .login(accountDto.getLogin())
                .password(accountDto.getPassword())
                .status(Status.valueOf(accountDto.getStatus()))
                .role(Role.valueOf(accountDto.getRole()))
                .build();
    }
}
