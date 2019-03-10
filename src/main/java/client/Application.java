package client;

import client.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.scene.control.Label;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import server.model.ApiRequestResponse;
import server.model.AuthenticateUser;
import server.model.EmissionReductions;
import server.model.Users;

import javax.xml.bind.JAXB;
import java.io.IOException;
import java.io.StringReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


//@SpringBootApplication
class Application {

    private static final RestTemplate restTemplate = new RestTemplate();

    private static final String ADD_USER = Url.ADD_USER.getUrl();
    private static final String GET_USER_FRIENDS = Url.GET_USER_FRIENDS.getUrl();
    private static final String GET_USER = Url.GET_USER.getUrl();
    private static final String AUTH_USER = Url.AUTH_USER.getUrl();
    private static final String GET_ALL_USERS = Url.GET_ALL_USERS.getUrl();


    public static void main(final String[] args) {

       /* UserService userService = new UserService();

        String pattern = "dd-MM-yyyy";
        DateFormat dateFormat = new SimpleDateFormat(pattern);

        try {

            Date dob = dateFormat.parse("20-12-1999");
            Users user = new Users(null, "demo",
                    "123", "TestName", "LastName",
                    "RO", "123@gmail.com", dob, "user");

            userService.addUser(restTemplate, ADD_USER,user);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        userService.getUser(restTemplate, GET_USER, 15L);

        userService.getUserFriends(restTemplate, GET_USER_FRIENDS, 0L);

        userService.authUser(restTemplate,
                AUTH_USER, new AuthenticateUser("test15",
                        "123"));*/
        final String url = "https://apis.berkeley.edu/coolclimate/footprint";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        httpHeaders.set("app_id", "17371d04");
        httpHeaders.set("app_key", "d55f1d19083da3a63cbd2be60da2361b");

        HttpEntity<?> entity = new HttpEntity<>(httpHeaders);

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("input_location_mode", 1)
                .queryParam("input_location", "23231")
                .queryParam("input_income", 1)
                .queryParam("input_size", 0)
                .queryParam("input_footprint_household_adults", 2)
                .queryParam("input_footprint_household_children", 0)
                .queryParam("internal_state_abbreviation", "MI")
                .queryParam("input_changed", 0)

                .queryParam("input_footprint_transportation_num_vehicles", 1)
                .queryParam("input_footprint_transportation_mpg1", 30)
                .queryParam("input_footprint_transportation_fuel1", 0)
                .queryParam("input_footprint_transportation_miles1", 10000)
                .queryParam("input_footprint_transportation_miles2", 0)
                .queryParam("input_footprint_transportation_miles3", 0)
                .queryParam("input_footprint_transportation_miles4", 0)
                .queryParam("input_footprint_transportation_miles5", 0)
                .queryParam("input_footprint_transportation_miles6", 0)
                .queryParam("input_footprint_transportation_miles7", 0)
                .queryParam("input_footprint_transportation_miles8", 0)
                .queryParam("input_footprint_transportation_miles9", 0)
                .queryParam("input_footprint_transportation_miles10", 0)
                .queryParam("input_footprint_transportation_mpg2", 0)
                .queryParam("input_footprint_transportation_mpg3", 0)
                .queryParam("input_footprint_transportation_mpg4", 0)
                .queryParam("input_footprint_transportation_mpg5", 0)
                .queryParam("input_footprint_transportation_mpg6", 0)
                .queryParam("input_footprint_transportation_mpg7", 0)
                .queryParam("input_footprint_transportation_mpg8", 0)
                .queryParam("input_footprint_transportation_mpg9", 0)
                .queryParam("input_footprint_transportation_mpg10", 0)

                .queryParam("input_footprint_transportation_groundtype",0)
                .queryParam("input_footprint_transportation_publictrans", 300)

                .queryParam("input_footprint_transportation_airtype", 0)
                .queryParam("input_footprint_transportation_airtotal", 10000)

                .queryParam("input_footprint_housing_electricity_type", 1)
                .queryParam("input_footprint_housing_electricity_dollars", 300)
                .queryParam("input_footprint_housing_electricity_kwh", 350)
                .queryParam("input_footprint_housing_gco2_per_kwh", 0)
                .queryParam("input_footprint_housing_cleanpercent", 0)
                .queryParam("input_footprint_housing_naturalgas_type", 2)
                .queryParam("input_footprint_housing_naturalgas_cuft", 500)
                .queryParam("input_footprint_housing_heatingoil_type", 1)
                .queryParam("input_footprint_housing_heatingoil_gallons", 200)
                .queryParam("input_footprint_housing_heatingoil_dollars_per_gallon", 15)
                .queryParam("input_footprint_housing_watersewage", 1)
                .queryParam("input_footprint_housing_squarefeet", 45)
                .queryParam("input_footprint_housing_hdd", 0)
                .queryParam("input_footprint_housing_cdd", 0)

                .queryParam("input_footprint_shopping_food_meattype", 1)
                .queryParam("input_footprint_shopping_food_meat_beefpork", 0)
                .queryParam("input_footprint_shopping_food_meat_poultry", 0)
                .queryParam("input_footprint_shopping_food_meat_fish", 0)
                .queryParam("input_footprint_shopping_food_meat_other", 0)
                .queryParam("input_footprint_shopping_food_dairy", 3)
                .queryParam("input_footprint_shopping_food_otherfood", 2)
                .queryParam("input_footprint_shopping_food_fruitvegetables", 2)
                .queryParam("input_footprint_shopping_food_cereals", 3)

                .queryParam("input_footprint_shopping_goods_type", 0)
                .queryParam("input_footprint_shopping_goods_default_furnitureappliances", 0)
                .queryParam("input_footprint_shopping_goods_default_clothing", 0)
                .queryParam("input_footprint_shopping_goods_default_other_entertainment", 0)
                .queryParam("input_footprint_shopping_goods_default_other_office", 0)
                .queryParam("input_footprint_shopping_goods_default_other_personalcare", 0)
                .queryParam("input_footprint_shopping_goods_default_other_autoparts", 0)
                .queryParam("input_footprint_shopping_goods_default_other_medical", 0)
                .queryParam("input_footprint_shopping_goods_total", 0)
                .queryParam("input_footprint_shopping_services_type", 0)
                .queryParam("input_footprint_shopping_services_total", 0);

        HttpEntity<String> response = restTemplate.exchange(uriComponentsBuilder.build().toUri(),
                HttpMethod.GET, entity, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(response.getBody());
        ApiRequestResponse responseObject = JAXB.unmarshal(new StringReader(response.getBody()), ApiRequestResponse.class);
        System.out.println(responseObject);

        try {
            EmissionReductions emissionReductions = objectMapper.readValue(responseObject.toString(), EmissionReductions.class);
            System.out.println(emissionReductions);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
