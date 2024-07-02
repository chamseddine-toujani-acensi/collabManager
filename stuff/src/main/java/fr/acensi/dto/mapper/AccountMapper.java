package fr.acensi.dto.mapper;

import fr.acensi.account.*;
import fr.acensi.dto.AccountDto;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccountMapper {

    public Optional<AccountDto> mapAccount(Optional<Account> account) {
        return account.map(value -> AccountDto.builder()
                .id(value.getId())
                .login(value.getLogin())
                .password(value.getPassword())
                .status(value.getStatus().getName().name())
                .role(value.getRoles().stream().map(role -> role.getName().name()).collect(Collectors.toList()))
                .build());
    }

    public Account mapAccountDto(AccountDto accountDto) {
        return Account.builder()
                .id(accountDto.getId())
                .login(accountDto.getLogin())
                .password(accountDto.getPassword())
                .status(Status.builder().name(EStatus.valueOf(accountDto.getStatus())).build())
                .roles(accountDto.getRole().stream().map(role -> Role.builder().name(ERole.valueOf(role)).build()).collect(Collectors.toSet()))
                .build();
    }
}
