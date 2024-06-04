package fr.acensi.stuff.controller;

import fr.acensi.stuff.account.AccountService;
import fr.acensi.stuff.dto.request.AuthenticationRequest;
import fr.acensi.stuff.dto.request.RegisterRequest;
import fr.acensi.stuff.dto.response.AuthenticationResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/account")
@AllArgsConstructor
@Slf4j
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(accountService.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
        return ResponseEntity.ok(accountService.authenticate(request));
    }
}
