package fr.acensi.hrmanager.loging;

import fr.acensi.hrmanager.util.loging.LoginLogger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class LoginLoggerTest {
    @BeforeEach
    void setUp() throws IOException {

    }


    @AfterEach
    void tearDown() throws IOException {

    }

    @Test
    void getInstance() {
        String filePath = "test";
        LoginLogger loginLogger1 = LoginLogger.getInstance(filePath);
        LoginLogger loginLogger2 = LoginLogger.getInstance(filePath);

        assertEquals(loginLogger1, loginLogger2);
    }

    @Test
    void log() {
        String filePath = "login.log";
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource(filePath)).getFile());
        String absolutePath = file.getAbsolutePath();

        String message = "test";
        LoginLogger loginLogger = LoginLogger.getInstance(absolutePath);
        loginLogger.log(message);
    }
}