package fr.acensi.stuff.account;

import fr.acensi.stuff.dto.request.AuthenticationRequest;
import fr.acensi.stuff.dto.request.RegisterRequest;
import fr.acensi.stuff.dto.response.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public AuthenticationResponse register(RegisterRequest request) {

        return null;
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        return null;
    }
}
