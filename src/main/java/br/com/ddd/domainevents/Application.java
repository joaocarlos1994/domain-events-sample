package br.com.ddd.domainevents;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This {@code {@link SpringBootApplication}} tells the Spring Boot framework
 * that this is the bootstrap class for the project
 *
 * @author  Joao Batista
 * @version 1.0 11/12/2018
 * */
@SpringBootApplication
public class Application {

    public static void main(final String[] args) {
        //Call to start the entire Spring Boot service
        SpringApplication.run(Application.class, args);
    }

}
