package fr.acensi.hrmanager.util.loging;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LoginLogger {

    private LoginLogger() {
    }

    private static LoginLogger instance;

    private static File logFile;

    public static LoginLogger getInstance(String filePah) {
        if (instance == null) {
            synchronized (LoginLogger.class) {
                if (instance == null) {
                    instance = new LoginLogger();
                    try {
                        logFile = new File(filePah);
                        if (logFile.createNewFile()) {
                            System.out.println("File created: " + logFile.getName());
                        } else {
                            System.out.println("File already exists.");
                        }
                    } catch (IOException e) {
                        System.out.println("An error occurred.");
                    }
                }
            }
        }
        return instance;
    }

    public void log(String message) {
        try {
            FileWriter myWriter = new FileWriter(logFile.getAbsolutePath());
            myWriter.write(message);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }
}
