package server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Main class of the server application. Includes main method.
 */

@EnableJpaRepositories
@SpringBootApplication
public class
Application {

    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }

}

