package fr.acensi.hrmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
public class HrManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(HrManagerApplication.class, args);
    }

}
