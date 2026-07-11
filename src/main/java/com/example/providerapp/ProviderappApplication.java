package com.example.providerapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.StringJoiner;

import static com.example.providerapp.util.Constants.ARGS_DELIMITER;
import static com.example.providerapp.util.Extensions.isNotNullOrBlank;

@Slf4j
@SpringBootApplication
public class ProviderappApplication {
    public static void main(String[] args) {
        log.info("Starting {}", ProviderappApplication.class.getSimpleName());
        logArgs(args);
        SpringApplication.run(ProviderappApplication.class, args);
    }

    private static void logArgs(String[] args) {
        StringJoiner argsJoiner = new StringJoiner(ARGS_DELIMITER);

        if (args != null) {
            for (String arg : args) {
                if (isNotNullOrBlank(arg)) {
                    argsJoiner.add(arg);
                }
            }
        }

        log.info("Arguments: {}", (argsJoiner.length() > 0) ? argsJoiner : "None");
    }
}
