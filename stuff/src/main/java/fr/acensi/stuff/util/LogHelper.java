package fr.acensi.stuff.util;

import fr.acensi.stuff.util.loging.LoginLogger;
import fr.acensi.stuff.account.Account;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LogHelper {

    @Value("${log.login.file.path}")
    private String loginFilePath;


    public void logLogin(Account account) {
        LoginLogger loginLogger = LoginLogger.getInstance(loginFilePath);
        loginLogger.log(account.getLogin()+" at " + LocalDateTime.now());
    }
}
