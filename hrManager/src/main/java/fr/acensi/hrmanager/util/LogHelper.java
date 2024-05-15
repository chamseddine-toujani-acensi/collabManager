package fr.acensi.hrmanager.util;

import fr.acensi.hrmanager.util.loging.LoginLogger;
import fr.acensi.hrmanager.model.Account;
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
