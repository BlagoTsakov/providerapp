package com.example.providerapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.StringJoiner;

import static com.example.providerapp.util.Constants.ARGS_DELIMITER;
import static com.example.providerapp.util.Extensions.isNotNullOrBlank;

@SpringBootApplication
public class ProviderappApplication {
    private static final Logger log = LoggerFactory.getLogger(ProviderappApplication.class);

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

<<<<<<< HEAD
        if (argsJoiner.length() > 0) {
            log.info("Arguments: {}", argsJoiner);
        } else {
            log.info("No arguments provided");
        }
=======
        log.info("Arguments: {}", (argsJoiner.length() > 0) ? argsJoiner : "None");
>>>>>>> 9026e23 (Initial constants and extension methods implemented. Log current args.)
    }
}
