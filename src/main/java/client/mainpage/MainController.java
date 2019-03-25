package client.mainpage;

import client.Url;
import client.UserToken;
import client.services.ApiService;
import client.services.UserService;
import com.jfoenix.controls.JFXSlider;
import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import org.springframework.web.client.RestTemplate;
import server.model.BikeRide;
import server.model.EmissionFriend;
import server.model.EmissionsClient;
import server.model.JwtUser;
import server.model.LocalProduce;
import server.model.Meal;
import server.model.PublicTransportation;
import server.model.SolarPanels;
import server.security.JwtValidator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * This is the main controller for the application
 * once the user logs into the application.
 */
@SuppressWarnings("Duplicates")
public class MainController {

    @FXML
    private Pane mainWindow;

    @FXML
    private Label usernameDisplayMainText;

    @FXML
    private Label totalCO2SavedLabel;

    @FXML
    private Pane emissionsWindow;

    @FXML
    private Label addEmissionsText;

    @FXML
    private ImageView foodIcon;

    @FXML
    private ImageView transportationIcon;

    @FXML
    private Button rideABikeButton;

    @FXML
    private TextField numberOfMilesText;

    @FXML
    private TextField carMileageText;

    @FXML
    private TextField fuelTypeText;

    @FXML
    private Button addTransportationButton;

    @FXML
    private Label transportationStatus;

    @FXML
    private Button backToTransportationTypePageButton;

    @FXML
    private ImageView bikeIcon;

    @FXML
    private ImageView tempIcon;

    @FXML
    private ImageView energyIcon;

    @FXML
    private ImageView vegetarianIcon;

    @FXML
    private Button mealButton;

    @FXML
    private Button vegetarianMealButton;

    @FXML
    private Button backToEmissionPageButton;

    @FXML
    private Label vegetarianMealStatus;

    @FXML
    private TextField dairyText;

    @FXML
    private TextField cerealText;

    @FXML
    private TextField fruitsAndVegetablesText;

    @FXML
    private TextField otherVegetarianMealText;

    @FXML
    private Button addMealButton;

    @FXML
    private Button backToMealTypePageButton;

    @FXML
    private Button transportationButton;

    @FXML
    private Button temperatureButton;

    @FXML
    private Button renewableEnergyButton;

    @FXML
    private Pane progressWindow;

    @FXML
    private Pane profileWindow;

    @FXML
    private ScrollPane aboutUsWindow;

    @FXML
    private Pane settingsWindow;

    /** ID activation for the public transport ride button. **/

    @FXML
    private Button rideABusButton;

    @FXML
    private ImageView busIcon;

    @FXML
    private Button addPublicTransportationButton;

    @FXML
    private TextField numberOfMilesTextPublic;

    @FXML
    private TextField carMileageTextPublic;

    @FXML
    private TextField fuelTypeTextPublic;

    /** ID activation for the local produce button. **/

    @FXML
    private Button localProduceButton;

    @FXML
    private ImageView localProduceIcon;

    @FXML
    private Label localProduceStatus;

    @FXML
    private Label percentFoodProductionLabel;

    @FXML
    private Label percentPackagedLabel;

    @FXML
    private JFXSlider percentFoodProductionSlider;

    @FXML
    private JFXSlider percentPackagedSlider;

    @FXML
    private Button addProduceButton;

    @FXML
    private Button backToMealTypePageButtonProduce;

    /** ID activation for the solar panel button. **/

    @FXML
    private TextField systemSizeText;

    @FXML
    private TextField annualSolarEnergyText;

    @FXML
    private Button addSolarPanelButton;

    @FXML
    private Label solarPanelStatus;

    @FXML
    private Button backToEmissionPageButtonSolar;

    @FXML
    private TextField numberSolarPanels;

    private RestTemplate restTemplate = new RestTemplate();
    private ApiService apiService = new ApiService();
    private UserService userService = new UserService();
    private JwtValidator jwtValidator = new JwtValidator();

    private String userTokenString;

    /**---------------------------- MAIN PAGE -----------------------------------------**/

    /**
     * Renders the main page.
     * @param event - once a user clicks the button linked to
     *              this method, it starts to execute.
     *
     */
    public void mainPage(ActionEvent event) {
        this.userTokenString = UserToken.getUserToken();
        mainWindow.setVisible(true);
        mainWindow.toFront();
        JwtUser jwtUser = jwtValidator.validate(userTokenString);
        animatePane(mainWindow);
        displayUsernameOnMain("username: " + jwtUser.getUserName());
        EmissionFriend emissionFriend = userService.getEmissionsOfUser(
                restTemplate, Url.GET_EMISSION_USER.getUrl(), jwtUser.getId(), userTokenString);
        String number = String.format("%.5f", emissionFriend.getCarbonEmission());
        totalCO2SavedLabel.setText(number + " tons");
        totalCO2SavedLabel.setStyle("-fx-font: 16 arial;");
    }

    /**
     * Takes the username and displays it on the main page.
     * @param username the username of the user
     */
    public void displayUsernameOnMain(String username) {
        usernameDisplayMainText.setText(username);
    }

    /**---------------------------- EMISSION PAGE -----------------------------------------**/

    /**
     * Renders the emissions page.
     * @param event - once a user clicks the button linked to
     *              this method, it starts to execute.
     */
    public void emissionsPage(ActionEvent event) {
        emissionsWindow.setVisible(true);
        emissionsWindow.toFront();
        emissionsPageShow();
        animatePane(emissionsWindow);
    }

    /**
     * Shows the main page of the emissions page.
     */
    public void emissionsPageShow() {
        foodIcon.setVisible(true);
        mealButton.setVisible(true);
        transportationIcon.setVisible(true);
        transportationButton.setVisible(true);
        tempIcon.setVisible(true);
        temperatureButton.setVisible(true);
        renewableEnergyButton.setVisible(true);
        energyIcon.setVisible(true);
        vegetarianIcon.setVisible(false);
        vegetarianMealButton.setVisible(false);
        dairyText.setVisible(false);
        cerealText.setVisible(false);
        fruitsAndVegetablesText.setVisible(false);
        otherVegetarianMealText.setVisible(false);
        addEmissionsText.setText("Choose Your Emission Type");
        addMealButton.setVisible(false);
        rideABikeButton.setVisible(false);
        bikeIcon.setVisible(false);
        numberOfMilesText.setVisible(false);
        carMileageText.setVisible(false);
        fuelTypeText.setVisible(false);
        addTransportationButton.setVisible(false);
        backToEmissionPageButton.setVisible(false);
        backToMealTypePageButton.setVisible(false);
        backToTransportationTypePageButton.setVisible(false);
        vegetarianMealStatus.setVisible(false);
        transportationStatus.setVisible(false);

        /** Emissionspage initial visibility - ride bus button view **/
        rideABusButton.setVisible(false);
        busIcon.setVisible(false);
        addPublicTransportationButton.setVisible(false);
        numberOfMilesTextPublic.setVisible(false);
        carMileageTextPublic.setVisible(false);
        fuelTypeTextPublic.setVisible(false);

        /** Emissionspage initial visibility - local produce button view **/
        localProduceButton.setVisible(false);
        localProduceIcon.setVisible(false);
        localProduceStatus.setVisible(false);
        percentFoodProductionLabel.setVisible(false);
        percentPackagedLabel.setVisible(false);
        percentFoodProductionSlider.setVisible(false);
        percentPackagedSlider.setVisible(false);
        addProduceButton.setVisible(false);
        backToMealTypePageButtonProduce.setVisible(false);

        /** Emissionspage initial visibility - solar panel button view **/
        systemSizeText.setVisible(false);
        annualSolarEnergyText.setVisible(false);
        addSolarPanelButton.setVisible(false);
        solarPanelStatus.setVisible(false);
        backToEmissionPageButtonSolar.setVisible(false);
        numberSolarPanels.setVisible(false);
    }

    /**
     * Hide the main emission page.
     */
    public void emissionsPageHide() {
        foodIcon.setVisible(false);
        mealButton.setVisible(false);
        transportationIcon.setVisible(false);
        transportationButton.setVisible(false);
        tempIcon.setVisible(false);
        temperatureButton.setVisible(false);
        renewableEnergyButton.setVisible(false);
        energyIcon.setVisible(false);
    }

    /**
     * Functionality when the user click the meal button.
     * @param event mouse click.
     */
    public void mealButtonOnClick(ActionEvent event) {
        emissionsPageHide();
        vegetarianMealButton.setVisible(true);
        localProduceButton.setVisible(true);
        addEmissionsText.setText("    Choose Your Meal Type");
        vegetarianIcon.setVisible(true);
        localProduceIcon.setVisible(true);
        backToEmissionPageButton.setVisible(true);
    }

    /**
     * Functionality of the back button to the main emissions page.
     * @param event mouse click
     */
    public void backToEmissionPageButtonOnClick(ActionEvent event) {
        emissionsPageShow();
    }

    /**
     * Functionality of the back button to the main emissions page from the solar panel tab.
     * @param event mouse click
     */
    public void backToEmissionPageButtonOnClickSolar(ActionEvent event) {
        emissionsPageShow();
    }

    /**
     * Functionality when the user click the vegetarian meal button.
     * @param event mouse click.
     */
    public void vegetarianMealButtonOnClick(ActionEvent event) {
        vegetarianMealButton.setVisible(false);
        localProduceButton.setVisible(false);
        dairyText.setVisible(true);
        cerealText.setVisible(true);
        fruitsAndVegetablesText.setVisible(true);
        otherVegetarianMealText.setVisible(true);
        addMealButton.setVisible(true);
        vegetarianIcon.setVisible(false);
        localProduceIcon.setVisible(false);
        backToMealTypePageButton.setVisible(true);
        vegetarianMealStatus.setVisible(true);
    }

    /**
     * Functionality when the user clicks the local produce button.
     * @param event mouse click.
     */
    public void localProduceButtonOnClick(ActionEvent event) {
        vegetarianMealButton.setVisible(false);
        localProduceButton.setVisible(false);
        vegetarianIcon.setVisible(false);
        localProduceIcon.setVisible(false);

        localProduceStatus.setVisible(true);
        percentFoodProductionLabel.setVisible(true);
        percentPackagedLabel.setVisible(true);
        percentFoodProductionSlider.setVisible(true);
        percentPackagedSlider.setVisible(true);
        addProduceButton.setVisible(true);
        backToMealTypePageButtonProduce.setVisible(true);
    }


    /**
     * Functionality of the back button to the meal type page.
     * @param event mouse click
     */
    public void backToMealTypeButtonOnClick(ActionEvent event) {
        vegetarianMealButton.setVisible(true);
        localProduceButton.setVisible(true);
        dairyText.setVisible(false);
        cerealText.setVisible(false);
        fruitsAndVegetablesText.setVisible(false);
        otherVegetarianMealText.setVisible(false);
        addMealButton.setVisible(false);
        vegetarianIcon.setVisible(true);
        localProduceIcon.setVisible(true);
        backToMealTypePageButton.setVisible(false);
        vegetarianMealStatus.setVisible(false);
    }

    /**
     * Functionality of the back button to the meal type page for local produce.
     * @param event mouse click
     */
    public void backToMealTypeButtonOnClickProduce(ActionEvent event) {
        vegetarianMealButton.setVisible(true);
        localProduceButton.setVisible(true);
        vegetarianIcon.setVisible(true);
        localProduceIcon.setVisible(true);

        localProduceStatus.setVisible(false);
        percentFoodProductionLabel.setVisible(false);
        percentPackagedLabel.setVisible(false);
        percentFoodProductionSlider.setVisible(false);
        percentPackagedSlider.setVisible(false);
        addProduceButton.setVisible(false);
        backToMealTypePageButtonProduce.setVisible(false);
    }

    /**
     * Functionality when the user clicks the renewable energy button.
     * @param event mouse click.
     */
    public void solarPanelButtonOnClick(ActionEvent event) {
        emissionsPageHide();

        systemSizeText.setVisible(true);
        annualSolarEnergyText.setVisible(true);
        addSolarPanelButton.setVisible(true);
        solarPanelStatus.setVisible(true);
        backToEmissionPageButtonSolar.setVisible(true);
        numberSolarPanels.setVisible(true);
    }

    /**
     * Functionality when the user clicks the vegetarian meal button.
     * @param event mouse click.
     */
    public void transportationButtonOnClick(ActionEvent event) {
        emissionsPageHide();
        rideABikeButton.setVisible(true);
        bikeIcon.setVisible(true);

        //ride bus button visible
        rideABusButton.setVisible(true);
        busIcon.setVisible(true);

        backToEmissionPageButton.setVisible(true);
    }

    /**
     * Functionality when the user clicks the ride a bike button.
     * @param event mouse click.
     */
    public void rideABikeButtonOnClick(ActionEvent event) {
        numberOfMilesText.setVisible(true);
        carMileageText.setVisible(true);
        fuelTypeText.setVisible(true);

        rideABikeButton.setVisible(false);
        bikeIcon.setVisible(false);
        addTransportationButton.setVisible(true);
        backToEmissionPageButton.setVisible(false);
        backToTransportationTypePageButton.setVisible(true);
        transportationStatus.setVisible(true);

        //ride bus button visible off
        rideABusButton.setVisible(false);
        busIcon.setVisible(false);
    }

    /**
     * Functionality when the user clicks the ride a car button.
     * @param event mouse click.
     */
    public void rideABusButtonOnClick(ActionEvent event) {
        rideABikeButton.setVisible(false);
        bikeIcon.setVisible(false);

        addPublicTransportationButton.setVisible(true);
        backToEmissionPageButton.setVisible(false);
        backToTransportationTypePageButton.setVisible(true);
        transportationStatus.setVisible(true);

        //ride bus button visible off
        rideABusButton.setVisible(false);
        busIcon.setVisible(false);
        numberOfMilesTextPublic.setVisible(true);
        carMileageTextPublic.setVisible(true);
        fuelTypeTextPublic.setVisible(true);
    }

    /**
     * Functionality of the back button to the transportation page.
     * @param event mouse click
     */
    public void backToTransportationTypeButtonOnClick(ActionEvent event) {
        numberOfMilesText.setVisible(false);
        carMileageText.setVisible(false);
        fuelTypeText.setVisible(false);

        bikeIcon.setVisible(true);
        busIcon.setVisible(true);
        addTransportationButton.setVisible(false);
        addPublicTransportationButton.setVisible(false);
        backToEmissionPageButton.setVisible(true);
        backToTransportationTypePageButton.setVisible(false);
        rideABikeButton.setVisible(true);
        transportationStatus.setVisible(false);

        //ride bus button visible
        rideABusButton.setVisible(true);
        busIcon.setVisible(true);
        numberOfMilesTextPublic.setVisible(false);
        carMileageTextPublic.setVisible(false);
        fuelTypeTextPublic.setVisible(false);
    }

    /**
     * This methods adds a meal in to the user's database.
     */
    public void addEmissionsForAVegetarianMeal() {
        final String token = UserToken.getUserToken();

        if (!emptyVegetarianMealBoxes()) {
            Meal meal = new Meal(Float.parseFloat(dairyText.getText()),
                    Float.parseFloat(otherVegetarianMealText.getText()),
                    Float.parseFloat(fruitsAndVegetablesText.getText()),
                    Float.parseFloat(cerealText.getText()));
            JwtUser jwtUser = jwtValidator.validate(token);
            float carbonEmission = apiService.getVegetarianMealEmissions(meal);
            String number = String.format("%.5f", carbonEmission);
            vegetarianMealStatus.setText("You have saved: " + number + " tons of CO2");
            DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
            Date today = Calendar.getInstance().getTime();
            EmissionsClient emissionsClient = new EmissionsClient("1", carbonEmission, today);
            String response = userService.addEmissionOfUser(restTemplate, Url.ADD_EMISSION.getUrl(),
                    jwtUser.getId(), emissionsClient, token);
            System.out.println(response);
        }
    }

    /**
     * This methods adds local produce in to the user's database.
     */
    public void addEmissionsForLocalProduce() {
        final String token = UserToken.getUserToken();

        Double sliderFoodProduction = percentFoodProductionSlider.getValue();
        Double sliderPackage = percentPackagedSlider.getValue();
        LocalProduce localProduce = localProduceEmission(sliderFoodProduction, sliderPackage);

        JwtUser jwtUser = jwtValidator.validate(token);
        Double carbonEmissionDouble = localProduce.getFoodProducedLocally()
                + localProduce.getPackagedFood();
        float carbonEmission = carbonEmissionDouble.floatValue();
        String number = String.format("%.5f", carbonEmission);
        localProduceStatus.setText("You have saved: " + number + " tons of CO2");
        DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
        Date today = Calendar.getInstance().getTime();
        EmissionsClient emissionsClient = new EmissionsClient("1", carbonEmission, today);
        String response = userService.addEmissionOfUser(restTemplate, Url.ADD_EMISSION.getUrl(),
                jwtUser.getId(), emissionsClient, token);
        System.out.println(response);
    }

    /**
     * Determines the total C02 emission depending on the sliders value.
     * @param sliderFoodProduction slider for food production
     * @param sliderPackage slider for food packaging
     * @return
     */
    public LocalProduce localProduceEmission(Double sliderFoodProduction, Double sliderPackage) {
        double foodProductionEmission;

        if (sliderFoodProduction <= 25) {
            foodProductionEmission = 0.1;
        } else if (sliderFoodProduction > 25 && sliderFoodProduction <= 50) {
            foodProductionEmission = 0.2;
        } else if (sliderFoodProduction > 50 && sliderFoodProduction <= 75) {
            foodProductionEmission = 0.3;
        } else {
            foodProductionEmission = 0.4;
        }

        double foodPackagingEmission;

        if (sliderPackage <= 25) {
            foodPackagingEmission = 0.1;
        } else if (sliderPackage > 25 && sliderPackage <= 50) {
            foodPackagingEmission = 0.2;
        } else if (sliderPackage > 50 && sliderPackage <= 75) {
            foodPackagingEmission = 0.3;
        } else {
            foodPackagingEmission = 0.4;
        }

        return new LocalProduce(foodProductionEmission, foodPackagingEmission);
    }


    /**
     * This methods adds riding a bike in to the user's database.
     */
    public void addEmissionsForRidingABike() {
        final String token = UserToken.getUserToken();

        if (!emptyRideABikeBoxes()) {
            Float numberOfKilometers = Float.parseFloat(numberOfMilesText.getText());
            Float numberOfMiles = numberOfKilometers * 1.6f;
            int fuelType = Integer.parseInt(fuelTypeText.getText());
            BikeRide ride = new BikeRide(numberOfMiles,
                    Float.parseFloat(carMileageText.getText()),
                    fuelType);
            JwtUser jwtUser = jwtValidator.validate(token);
            float carbonEmission = apiService.getRideBikeEmissions(ride);
            String number = String.format("%.5f", carbonEmission);
            transportationStatus.setText("You have saved: " + number + " tons of CO2");
            DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
            Date today = Calendar.getInstance().getTime();
            EmissionsClient emissionsClient = new EmissionsClient("2", carbonEmission, today);
            String response = userService.addEmissionOfUser(restTemplate, Url.ADD_EMISSION.getUrl(),
                    jwtUser.getId(), emissionsClient, token);
            System.out.println(response);
        }
    }

    /**
     * This methods adds using public transportation in to the user's database.
     */
    public void addEmissionsForRidingAPublicTransport() {
        final String token = UserToken.getUserToken();

        if (!emptyRideABusBoxes()) {
            Float numberOfKilometers = Float.parseFloat(numberOfMilesTextPublic.getText());
            Float numberOfMiles = numberOfKilometers * 1.6f;
            int fuelType = Integer.parseInt(fuelTypeTextPublic.getText());
            PublicTransportation bus = new PublicTransportation(
                    Float.parseFloat(carMileageTextPublic.getText()),
                    numberOfMiles, fuelType);
            JwtUser jwtUser = jwtValidator.validate(token);
            float carbonEmission = apiService.getPublicTransportationEmissions(bus);
            String number = String.format("%.5f", carbonEmission);
            transportationStatus.setText("You have saved: " + number + " tons of CO2");
            DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
            Date today = Calendar.getInstance().getTime();
            EmissionsClient emissionsClient = new EmissionsClient("2", carbonEmission, today);
            String response = userService.addEmissionOfUser(restTemplate, Url.ADD_EMISSION.getUrl(),
                    jwtUser.getId(), emissionsClient, token);
            System.out.println(response);
        }
    }

    /**
     * This methods adds solar panels in to the user's database.
     */
    public void addEmissionsForSolarPanel() {
        final String token = UserToken.getUserToken();

        if (!emptySolarPanelBoxes()) {
            float factorOfCO2Avoidance = Float.parseFloat(systemSizeText.getText());
            float annualSolarEnergyProduction = Float.parseFloat(annualSolarEnergyText.getText());
            int numberOfSolarPanels = Integer.parseInt(numberSolarPanels.getText());

            SolarPanels solarPanel = new SolarPanels(factorOfCO2Avoidance,
                    annualSolarEnergyProduction, numberOfSolarPanels);
            JwtUser jwtUser = jwtValidator.validate(token);
            //Turning kg into tonnes by dividing it by a 1000
            float carbonEmission = (annualSolarEnergyProduction
                    * factorOfCO2Avoidance
                    * numberOfSolarPanels) / 1000f ;
            String number = String.format("%.5f", carbonEmission);
            solarPanelStatus.setText("You have saved: " + number + " tons of CO2");
            DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
            Date today = Calendar.getInstance().getTime();
            EmissionsClient emissionsClient = new EmissionsClient("4", carbonEmission, today);
            String response = userService.addEmissionOfUser(restTemplate, Url.ADD_EMISSION.getUrl(),
                    jwtUser.getId(), emissionsClient, token);
            System.out.println(response);
        }
    }

    /**
     * This methods adds c02 for house temperature in to the user's database.
     */
    public void addEmissionsForHouseTemperature() {
        final String token = UserToken.getUserToken();

//        if (!emptySolarPanelBoxes()) {
            float factorOfCO2Avoidance = Float.parseFloat(systemSizeText.getText());
            float annualSolarEnergyProduction = Float.parseFloat(annualSolarEnergyText.getText());
            int numberOfSolarPanels = Integer.parseInt(numberSolarPanels.getText());

            SolarPanels solarPanel = new SolarPanels(factorOfCO2Avoidance,
                    annualSolarEnergyProduction, numberOfSolarPanels);
            JwtUser jwtUser = jwtValidator.validate(token);
            //Turning kg into tonnes by dividing it by a 1000
            float carbonEmission = (annualSolarEnergyProduction
                    * factorOfCO2Avoidance
                    * numberOfSolarPanels) / 1000f ;
            String number = String.format("%.5f", carbonEmission);
            solarPanelStatus.setText("You have saved: " + number + " tons of CO2");
            DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
            Date today = Calendar.getInstance().getTime();
            EmissionsClient emissionsClient = new EmissionsClient("4", carbonEmission, today);
            String response = userService.addEmissionOfUser(restTemplate, Url.ADD_EMISSION.getUrl(),
                    jwtUser.getId(), emissionsClient, token);
            System.out.
                    println(response);
//        }
    }

    /**
     * This method handles the functionality of giving an error when
     * any of the fields in the adding a vegetarian meal is empty.
     * @return boolean - returns true if the field is null or empty and false if not.
     * */
    private boolean emptyVegetarianMealBoxes() {
        if (checkEmptyOrNullBox(
                dairyText, cerealText, fruitsAndVegetablesText, otherVegetarianMealText)) {
            emptyTextBoxPopup();
            return true;
        } else {
            return false;
        }
    }

    private boolean emptyRideABikeBoxes() {
        if (checkEmptyOrNullBox(
                carMileageText, fuelTypeText, numberOfMilesText)) {
            emptyTextBoxPopup();
            return true;
        } else {
            return false;
        }
    }

    private boolean emptyRideABusBoxes() {
        if (checkEmptyOrNullBox(
                carMileageTextPublic, fuelTypeTextPublic, numberOfMilesTextPublic)) {
            emptyTextBoxPopup();
            return true;
        } else {
            return false;
        }
    }

    private boolean emptySolarPanelBoxes() {
        if (checkEmptyOrNullBox(
                systemSizeText, annualSolarEnergyText, numberSolarPanels)) {
            emptyTextBoxPopup();
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method handles the functionality of checking whether a
     * box is null or empty.
     * @param textFields - any box in the login page.
     * @return boolean - returns true if the field is null or empty and false if not.
     */

    private boolean checkEmptyOrNullBox(TextField... textFields) {
        for (TextField textField : textFields) {
            if (textField.getText() == null || textField.getText().equals("")) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method handles the functionality of giving an error
     * either the username or password box is empty.
     * */
    private void emptyTextBoxPopup() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("Either of your boxes is empty!"
                + "\nPlease try again.");
        alert.showAndWait();
    }

    /**---------------------------- PROGRESS PAGE -----------------------------------------**/

    /**
     * Renders the progress page.
     * @param event - once a user clicks the button linked to
     *              this method, it starts to execute.
     */
    public void progressPage(ActionEvent event) {
        progressWindow.setVisible(true);
        progressWindow.toFront();
        animatePane(progressWindow);
        progressWindow.setStyle("-fx-background-color: #000000");
    }

    /**---------------------------- PROFILE PAGE -----------------------------------------**/

    /**
     * Renders the profile page.
     * @param event - once a user clicks the button linked to
     *              this method, it starts to execute.
     */
    public void profileWindow(ActionEvent event) {
        profileWindow.setVisible(true);
        profileWindow.toFront();
        animatePane(profileWindow);
        profileWindow.setStyle("-fx-background-color: white");
    }

    /**---------------------------- ABOUT US PAGE -----------------------------------------**/

    /**
     * Renders the about us page.
     * @param event - once a user clicks the button linked to
     *              this method, it starts to execute.
     */
    public void aboutUsWindow(ActionEvent event) {
        aboutUsWindow.setVisible(true);
        aboutUsWindow.toFront();
        animateScrollPane(aboutUsWindow);
        aboutUsWindow.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
    }

    /**---------------------------- SETTINGS PAGE -----------------------------------------**/

    /**
     * Renders the settings page.
     * @param event - once a user clicks the button linked to
     *              this method, it starts to execute.
     */
    public void settingsWindow(ActionEvent event) {
        settingsWindow.setVisible(true);
        settingsWindow.toFront();
        animatePane(settingsWindow);
        settingsWindow.setStyle("-fx-background-color: orange");
    }

    /**---------------------------- LOGOUT -----------------------------------------**/

    /**
     * Renders the login page once user logs out.
     * @param event - once a user clicks the button linked to
     *              this method, it starts to execute.
     */
    public void logoutWindow(ActionEvent event) {
        LogoutController logoutController = new LogoutController();
        logoutController.logout();
    }

    /**---------------------------- ANIMATIONS -----------------------------------------**/

    /**
     * Animates a pane.
     * @param pane - takes a pane as the parameter.
     */
    public void animatePane(Pane pane) {
        CustomAnimation rht = new CustomAnimation(Duration.millis(500), pane,
                pane.getMinHeight());
        FadeTransition ft = new FadeTransition(Duration.millis(500), pane);
        ft.setFromValue(0);
        ft.setToValue(1);
        SequentialTransition pt = new SequentialTransition(rht, ft);
        pt.play();
    }

    /**
     * Animates a Scroll Pane.
     * @param pane - takes a scroll pane as the parameter.
     */
    public void animateScrollPane(ScrollPane pane) {
        CustomAnimation rht = new CustomAnimation(Duration.millis(500), pane,
                pane.getMinHeight());
        FadeTransition ft = new FadeTransition(Duration.millis(500), pane);
        ft.setFromValue(0);
        ft.setToValue(1);
        SequentialTransition pt = new SequentialTransition(rht, ft);
        pt.play();
    }
}