package client;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import javax.xml.ws.Response;
import java.util.Arrays;


//@SpringBootApplication
public class Application
{

    private static final String GET_MESSAGE = "http://localhost:8080/greeting";
    private static RestTemplate restTemplate = new RestTemplate();

    public static void main(String args[])
    {
        //SpringApplication.run(Application.class);

        Application app = new Application();

        app.getMessage();

    }

    @Bean
    private void getMessage()
    {
        Message result = restTemplate.getForObject(GET_MESSAGE, Message.class);

        System.out.println(result.toString());
    }

    /*@Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder)
    {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception
    {
        return args -> {
          Message message = restTemplate.getForObject("http://localhost:8080/greeting", Message.class);
          log.info(message.toString());
        };
    }*/
}
