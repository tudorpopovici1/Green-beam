package client;

import client.services.ApiService;
import client.services.UserService;
import org.springframework.web.client.RestTemplate;
import server.model.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//@SpringBootApplication
class Application {

    private static final RestTemplate restTemplate = new RestTemplate();

    public static void main(final String[] args) {

    }
}