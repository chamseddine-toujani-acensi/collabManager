package fr.acensi.account;

import fr.acensi.dto.request.LoginRequest;
import fr.acensi.dto.request.RegisterRequest;
import fr.acensi.dto.response.AccountInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountInfoResponse register(RegisterRequest request) {

        return null;
    }

    public AccountInfoResponse authenticate(LoginRequest request) {
        return null;
    }
}
