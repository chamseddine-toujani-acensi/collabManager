package fr.acensi.hrmanager.controller;

import fr.acensi.hrmanager.model.Account;
import fr.acensi.hrmanager.service.AccountService;
import fr.acensi.hrmanager.util.LogHelper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
@AllArgsConstructor
@Slf4j
public class AccountController {

    private AccountService accountService;

    private LogHelper logHelper;

    @GetMapping("/info/{id}")
    public String getAccountInfo(@PathVariable Long id){
        return accountService.getInfo(id);
    }

    @PostMapping("/register")
    public Account register(@RequestBody Account account){
        return accountService.register(account);
    }

    @PostMapping("/login")
    public String login(@RequestBody Account account){
        logHelper.logLogin(account);
        return "OK";
    }
}
