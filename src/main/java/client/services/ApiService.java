package client.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import server.model.ApiRequestResponse;
import server.model.EmissionReductions;
import server.model.Meal;

import javax.xml.bind.JAXB;
import java.io.IOException;
import java.io.StringReader;

public class ApiService {

    private final String url = "https://apis.berkeley.edu/coolclimate/footprint";

    private RestTemplate restTemplate  = new RestTemplate();

    public ApiService() {


    }

    public float getVegetarianMealEmissions(Meal meal) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("app_id", "17371d04");
        httpHeaders.set("app_key", "d55f1d19083da3a63cbd2be60da2361b");

        HttpEntity<?> httpEntity = new HttpEntity<>(httpHeaders);

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(url)

                .queryParam("input_changed", 1)
                .queryParam("input_location_mode", "1")
                .queryParam("input_location", "95843")
                .queryParam("input_income", "1")
                .queryParam("input_size", 3)
                .queryParam("internal_state_abbreviation", "CA")
                .queryParam("internal_vehiclemiles", 500)
                .queryParam("input_footprint_household_adults", "2")
                .queryParam("input_footprint_household_children", "0")
                .queryParam("input_footprint_transportation_airtotal", 10000)
                .queryParam("input_footprint_transportation_publictrans", 300)
                .queryParam("input_footprint_transportation_num_vehicles", 1)
                .queryParam("input_footprint_transportation_miles1", 10000)
                .queryParam("input_footprint_transportation_mpg1", 30)
                .queryParam("input_footprint_transportation_fuel1", 0)
                .queryParam("input_footprint_transportation_miles2", 0)
                .queryParam("input_footprint_transportation_mpg2", 35)
                .queryParam("input_footprint_transportation_fuel2", 1)
                .queryParam("input_footprint_transportation_miles3", 0)
                .queryParam("input_footprint_transportation_mpg3", 22)
                .queryParam("input_footprint_transportation_fuel3", 1)
                .queryParam("input_footprint_transportation_miles4", 0)
                .queryParam("input_footprint_transportation_mpg4", 22)
                .queryParam("input_footprint_transportation_fuel4", 1)
                .queryParam("input_footprint_transportation_miles5", 0)
                .queryParam("input_footprint_transportation_mpg5", 22)
                .queryParam("input_footprint_transportation_fuel5", 1)
                .queryParam("input_footprint_transportation_miles6", 0)
                .queryParam("input_footprint_transportation_mpg6", 22)
                .queryParam("input_footprint_transportation_fuel6", 1)
                .queryParam("input_footprint_transportation_miles7", 0)
                .queryParam("input_footprint_transportation_mpg7", 22)
                .queryParam("input_footprint_transportation_fuel7", 1)
                .queryParam("input_footprint_transportation_miles8", 0)
                .queryParam("input_footprint_transportation_mpg8", 22)
                .queryParam("input_footprint_transportation_fuel8", 1)
                .queryParam("input_footprint_transportation_miles9", 0)
                .queryParam("input_footprint_transportation_mpg9", 22)
                .queryParam("input_footprint_transportation_fuel9", 1)
                .queryParam("input_footprint_transportation_miles10", 0)
                .queryParam("input_footprint_transportation_mpg10", 22)
                .queryParam("input_footprint_transportation_fuel10", 1)
                .queryParam("input_footprint_transportation_groundtype",0)
                .queryParam("input_footprint_transportation_airtype", 0)
                .queryParam("input_footprint_housing_hdd", 150)
                .queryParam("input_footprint_housing_cdd", 200)
                .queryParam("input_footprint_housing_electricity_type", 1)
                .queryParam("input_footprint_housing_cleanpercent", 0)
                .queryParam("input_footprint_housing_naturalgas_type", 2)
                .queryParam("input_footprint_housing_heatingoil_type", 1)
                .queryParam("input_footprint_housing_heatingoil_dollars_per_gallon", 5)
                .queryParam("input_footprint_housing_squarefeet", 45)
                .queryParam("input_footprint_housing_watersewage", 300)
                .queryParam("input_footprint_housing_gco2_per_kwh", 215)
                .queryParam("input_footprint_housing_electricity_dollars",300)
                .queryParam("input_footprint_housing_electricity_kwh", 350)
                .queryParam("input_footprint_housing_naturalgas_cuft", 500)
                .queryParam("input_footprint_housing_heatingoil_gallons", 200)
                .queryParam("input_footprint_shopping_food_meat_beefpork", 0)
                .queryParam("input_footprint_shopping_food_meat_poultry", 0)
                .queryParam("input_footprint_shopping_food_meat_fish", 0)
                .queryParam("input_footprint_shopping_food_meat_other", 0)
                .queryParam("input_footprint_shopping_food_dairy", meal.getDairyCalories())
                .queryParam("input_footprint_shopping_food_otherfood", meal.getOtherfoodCalories())
                .queryParam("input_footprint_shopping_food_fruitvegetables", meal.getFruitVegetablesCalories())
                .queryParam("input_footprint_shopping_food_cereals", meal.getCerealCalories())
                .queryParam("input_footprint_shopping_food_meattype", 1)
                .queryParam("input_footprint_shopping_goods_type", 0)
                .queryParam("input_footprint_shopping_goods_other_type", 0)
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
                HttpMethod.GET, httpEntity, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(response.getBody());
        ApiRequestResponse responseObject = JAXB.unmarshal(
                new StringReader(response.getBody()), ApiRequestResponse.class);

        float carbonEmission = -1;

        try {
            EmissionReductions emissionReductions =
                    objectMapper.readValue(responseObject.toString(), EmissionReductions.class);
            carbonEmission = emissionReductions.getVegetarianMealEmission() / 365;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return carbonEmission;
    }

    /*public float getRideBikeEmissions() {
        HttpEntity<String> response = restTemplate.exchange(uriComponentsBuilder.build().toUri(),
                HttpMethod.GET, httpEntity, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(response.getBody());
        ApiRequestResponse responseObject = JAXB.unmarshal(
                new StringReader(response.getBody()), ApiRequestResponse.class);

        float carbonEmission = -1;

        try {
            EmissionReductions emissionReductions =
                    objectMapper.readValue(responseObject.toString(), EmissionReductions.class);
            carbonEmission = emissionReductions.getRideBikeEmission();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return carbonEmission;
    }

    public float getPublicTransportationEmissions() {
        HttpEntity<String> response = restTemplate.exchange(uriComponentsBuilder.build().toUri(),
                HttpMethod.GET, httpEntity, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(response.getBody());
        ApiRequestResponse responseObject = JAXB.unmarshal(
                new StringReader(response.getBody()), ApiRequestResponse.class);

        float carbonEmission = -1;

        try {
            EmissionReductions emissionReductions =
                    objectMapper.readValue(responseObject.toString(), EmissionReductions.class);
            carbonEmission = emissionReductions.getPublicTransportationEmission();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return carbonEmission;
    }
*/
}
