package client.mainpage;

import client.Url;
import client.UserToken;
import client.profile_page.ProfileController;
import client.services.ApiService;
import client.services.UserService;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXSlider;
import com.jfoenix.transitions.hamburger.HamburgerNextArrowBasicTransition;
import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import org.springframework.web.client.RestTemplate;
import server.model.*;
import server.security.JwtValidator;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This is the main controller for the application
 * once the user logs into the application.
 */
@SuppressWarnings("Duplicates")
public class MainController {

    /** ID activation for the profile page **/

    @FXML
    private JFXHamburger hamburger;

    @FXML
    private JFXDrawer drawer;

    /** ID activation for the main page **/

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
    private Button renewableEnergyButton;

    @FXML
    private Pane progressWindow;

    @FXML
    private Pane profileWindow;

    @FXML
    private ScrollPane aboutUsWindow;

    @FXML
    private Pane settingsWindow;

    /** ID activation for the public transport ride button **/

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

    /** ID activation for the local produce button **/

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

    /** ID activation for the solar panel button **/

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

    /** ID activation for the temperature button. **/

    @FXML
    private TextField whatTempText;

    @FXML
    private TextField whatTempAfterText;

    @FXML
    private Label temperatureStatus;

    @FXML
    private Button backToEmissionPageButtonTemperature;

    @FXML
    private Button addTemperatureButton;

    @FXML
    private Button temperatureButton;

    @FXML
    private ImageView tempIcon;

    /** ID activation for the household button */

    @FXML
    private ImageView householdIcon;

    @FXML
    private Button householdButton;

    @FXML
    private Button electricityButton;

    @FXML
    private Button naturalGasButton;

    @FXML
    private Button fuelOilButton;

    @FXML
    private TextField electricityText;

    @FXML
    private TextField naturalGasText;

    @FXML
    private TextField emissionFactorNaturalGas;

    @FXML
    private Label naturalGasStatus;

    @FXML
    private Label fuelOilStatus;

    @FXML
    private TextField fuelOilText;

    @FXML
    private TextField emissionFactorFuelOil;

    @FXML
    private Button addElectricityButton;

    @FXML
    private Button addNaturalGasButton;

    @FXML
    private Button addFuelOilButton;

    @FXML
    private Button backToHouseHoldPageButton;

    @FXML
    private Button backToEmissionPageButtonHousehold;

    @FXML
    private Label electricityStatus;

    @FXML
    private TextField emissionFactorElectricity;

            /** ID activation for LPG */
    @FXML
    private Button addLPGButton;

    @FXML
    private TextField lpgText;

    @FXML
    private Button lpgButton;

    @FXML
    private Label LPGStatus;

    @FXML
    private TextField emissionFactorLPG;

            /** ID activation for waste */

    @FXML
    private Button wasteButton;

    @FXML
    private TextField wasteText;

    @FXML
    private TextField emissionFactorWaste;

    @FXML
    private Label wasteStatus;

    @FXML
    private Button addWasteButton;

            /** ID activation for water */

    @FXML
    private Button waterButton;

    @FXML
    private TextField waterText;

    @FXML
    private TextField emissionFactorWater;

    @FXML
    private Label waterStatus;

    @FXML
    private Button addWaterButton;

            /** ID activation for a metro ride */

    @FXML
    private Button rideAMetroButton;

    @FXML
    private ImageView metroIcon;

    @FXML
    private TextField metroText;

    @FXML
    private TextField emissionFactorMetro;

    @FXML
    private Label metroStatus;

    @FXML
    private Button addMetroButton;

            /** ID activation for a taxi ride */

    @FXML
    private Button rideATaxiButton;

    @FXML
    private ImageView taxiIcon;

    @FXML
    private TextField taxiText;

    @FXML
    private TextField emissionFactorTaxi;

    @FXML
    private Label taxiStatus;

    @FXML
    private Button addTaxiButton;

            /** ID activation for a train ride */

    @FXML
    private Button rideATrainButton;

    @FXML
    private ImageView trainIcon;

    @FXML
    private TextField trainText;

    @FXML
    private TextField emissionFactorTrain;

    @FXML
    private Label trainStatus;

    @FXML
    private Button addTrainButton;

            /** ID activation for a airplane flight */

    @FXML
    private Button rideAPlaneButton;

    @FXML
    private ImageView planeIcon;

    @FXML
    private TextField planeText;

    @FXML
    private TextField emissionFactorPlane;

    @FXML
    private Label planeStatus;

    @FXML
    private Button addPlaneButton;



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
        JwtUser jwtUser = jwtValidator.validate(userTokenString);
        EmissionFriend emissionFriend = userService.getEmissionsOfUser(
                restTemplate, Url.GET_EMISSION_USER.getUrl(), jwtUser.getId(), userTokenString);
        mainWindow.setVisible(true);
        mainWindow.toFront();
        animatePane(mainWindow);
        displayUsernameOnMain("username: " + jwtUser.getUserName());
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
        addTemperatureButton.setVisible(false);

        /** Emissionspage initial visi˚bility - ride bus button view **/
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

        /** Emissionspage initial visibility - household button view **/
        whatTempAfterText.setVisible(false);
        whatTempText.setVisible(false);
        temperatureStatus.setVisible(false);

        /** Emissionspage initial visibility - household button view **/
        householdButton.setVisible(true);
        householdIcon.setVisible(true);
        electricityButton.setVisible(false);
        naturalGasButton.setVisible(false);
        fuelOilButton.setVisible(false);
        lpgButton.setVisible(false);
        wasteButton.setVisible(false);
        waterButton.setVisible(false);
        addElectricityButton.setVisible(false);
        electricityText.setVisible(false);
        backToHouseHoldPageButton.setVisible(false);
        backToEmissionPageButtonHousehold.setVisible(false);
        electricityStatus.setVisible(false);
        emissionFactorElectricity.setVisible(false);
        naturalGasStatus.setVisible(false);
        naturalGasText.setVisible(false);
        emissionFactorNaturalGas.setVisible(false);
        addNaturalGasButton.setVisible(false);
                    /** Fuel oil **/
        fuelOilText.setVisible(false);
        emissionFactorFuelOil.setVisible(false);
        fuelOilStatus.setVisible(false);
        addFuelOilButton.setVisible(false);

                    /** LPG **/
        lpgText.setVisible(false);
        emissionFactorLPG.setVisible(false);
        LPGStatus.setVisible(false);
        addLPGButton.setVisible(false);

                    /** Waste **/
        wasteText.setVisible(false);
        emissionFactorWaste.setVisible(false);
        wasteStatus.setVisible(false);
        addWasteButton.setVisible(false);

                    /** Water **/
        waterText.setVisible(false);
        emissionFactorWater.setVisible(false);
        waterStatus.setVisible(false);
        addWaterButton.setVisible(false);

                    /** Metro **/
        rideAMetroButton.setVisible(false);
        metroIcon.setVisible(false);
        metroText.setVisible(false);
        emissionFactorMetro.setVisible(false);
        metroStatus.setVisible(false);
        addMetroButton.setVisible(false);

                    /**Taxi **/
        rideATaxiButton.setVisible(false);
        taxiIcon.setVisible(false);
        taxiText.setVisible(false);
        emissionFactorTaxi.setVisible(false);
        taxiStatus.setVisible(false);
        addTaxiButton.setVisible(false);

                    /**Train **/
        rideATrainButton.setVisible(false);
        trainIcon.setVisible(false);
        trainText.setVisible(false);
        emissionFactorTrain.setVisible(false);
        trainStatus.setVisible(false);
        addTrainButton.setVisible(false);

                    /**Plane **/
        rideAPlaneButton.setVisible(false);
        planeIcon.setVisible(false);
        planeText.setVisible(false);
        emissionFactorPlane.setVisible(false);
        planeStatus.setVisible(false);
        addPlaneButton.setVisible(false);
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
        householdButton.setVisible(false);
        householdIcon.setVisible(false);
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
     * Functionality when the user clicks the temperature button.
     * @param event mouse click.
     */
    public void temperatureButtonOnClick(ActionEvent event) {
        emissionsPageHide();

        whatTempText.setVisible(true);
        whatTempAfterText.setVisible(true);
        temperatureStatus.setVisible(true);
        backToEmissionPageButtonTemperature.setVisible(true);
        addTemperatureButton.setVisible(true);
    }

    /**
     * Functionality when the user clicks the household button.
     * @param event mouse click.
     */
    public void householdButtonOnClick(ActionEvent event) {
        emissionsPageHide();

       electricityButton.setVisible(true);
       naturalGasButton.setVisible(true);
       fuelOilButton.setVisible(true);
       lpgButton.setVisible(true);
       wasteButton.setVisible(true);
       waterButton.setVisible(true);
       backToEmissionPageButtonHousehold.setVisible(true);
    }

    public void backToHouseHoldPage(ActionEvent event) {
        electricityButton.setVisible(true);
        naturalGasButton.setVisible(true);
        fuelOilButton.setVisible(true);
        lpgButton.setVisible(true);
        wasteButton.setVisible(true);
        waterButton.setVisible(true);
        electricityText.setVisible(false);
        addElectricityButton.setVisible(false);
        backToHouseHoldPageButton.setVisible(false);
        backToEmissionPageButtonHousehold.setVisible(true);
        electricityStatus.setVisible(false);
        emissionFactorElectricity.setVisible(false);
        addNaturalGasButton.setVisible(false);
        naturalGasStatus.setVisible(false);
        naturalGasText.setVisible(false);
        naturalGasStatus.setVisible(false);
        emissionFactorNaturalGas.setVisible(false);
        /** Fuel Oil **/
        fuelOilText.setVisible(false);
        emissionFactorFuelOil.setVisible(false);
        fuelOilStatus.setVisible(false);
        addFuelOilButton.setVisible(false);
        /** LPG **/
        lpgText.setVisible(false);
        emissionFactorLPG.setVisible(false);
        LPGStatus.setVisible(false);
        addLPGButton.setVisible(false);
        /** Waste **/
        wasteText.setVisible(false);
        emissionFactorWaste.setVisible(false);
        wasteStatus.setVisible(false);
        addWasteButton.setVisible(false);
        /** Water **/
        waterText.setVisible(false);
        emissionFactorWater.setVisible(false);
        waterStatus.setVisible(false);
        addWaterButton.setVisible(false);
    }

    public void electricityButtonOnClick(ActionEvent event) {
        electricityButton.setVisible(false);
        naturalGasButton.setVisible(false);
        fuelOilButton.setVisible(false);
        lpgButton.setVisible(false);
        wasteButton.setVisible(false);
        waterButton.setVisible(false);
        electricityText.setVisible(true);
        addElectricityButton.setVisible(true);
        backToHouseHoldPageButton.setVisible(true);
        backToEmissionPageButtonHousehold.setVisible(false);
        electricityStatus.setVisible(true);
        emissionFactorElectricity.setVisible(true);
    }

    public void naturalGasOnClick(ActionEvent event) {
        electricityButton.setVisible(false);
        naturalGasButton.setVisible(false);
        fuelOilButton.setVisible(false);
        lpgButton.setVisible(false);
        wasteButton.setVisible(false);
        waterButton.setVisible(false);
        naturalGasText.setVisible(true);
        naturalGasStatus.setVisible(true);
        emissionFactorNaturalGas.setVisible(true);
        addNaturalGasButton.setVisible(true);
        backToEmissionPageButtonHousehold.setVisible(false);
        backToHouseHoldPageButton.setVisible(true);
    }

    public void fuelOilOnClick(ActionEvent event) {
        electricityButton.setVisible(false);
        naturalGasButton.setVisible(false);
        fuelOilButton.setVisible(false);
        lpgButton.setVisible(false);
        wasteButton.setVisible(false);
        waterButton.setVisible(false);
        backToEmissionPageButtonHousehold.setVisible(false);

        fuelOilText.setVisible(true);
        emissionFactorFuelOil.setVisible(true);
        fuelOilStatus.setVisible(true);
        addFuelOilButton.setVisible(true);
        backToHouseHoldPageButton.setVisible(true);
    }

    public void LPGOnClick(ActionEvent event) {
        electricityButton.setVisible(false);
        naturalGasButton.setVisible(false);
        fuelOilButton.setVisible(false);
        lpgButton.setVisible(false);
        wasteButton.setVisible(false);
        waterButton.setVisible(false);
        backToEmissionPageButtonHousehold.setVisible(false);

        lpgText.setVisible(true);
        emissionFactorLPG.setVisible(true);
        LPGStatus.setVisible(true);
        addLPGButton.setVisible(true);
        backToHouseHoldPageButton.setVisible(true);
    }

    public void wasteOnClick(ActionEvent event) {
        electricityButton.setVisible(false);
        naturalGasButton.setVisible(false);
        fuelOilButton.setVisible(false);
        lpgButton.setVisible(false);
        wasteButton.setVisible(false);
        waterButton.setVisible(false);
        backToEmissionPageButtonHousehold.setVisible(false);

        wasteText.setVisible(true);
        emissionFactorWaste.setVisible(true);
        wasteStatus.setVisible(true);
        addWasteButton.setVisible(true);
        backToHouseHoldPageButton.setVisible(true);
    }

    public void waterOnClick(ActionEvent event) {
        electricityButton.setVisible(false);
        naturalGasButton.setVisible(false);
        fuelOilButton.setVisible(false);
        lpgButton.setVisible(false);
        wasteButton.setVisible(false);
        waterButton.setVisible(false);
        backToEmissionPageButtonHousehold.setVisible(false);

        waterText.setVisible(true);
        emissionFactorWater.setVisible(true);
        waterStatus.setVisible(true);
        addWaterButton.setVisible(true);
        backToHouseHoldPageButton.setVisible(true);
    }


    /**
     * Functionality when the user clicks the vegetarian meal button.
     * @param event mouse click.
     */
    public void transportationButtonOnClick(ActionEvent event) {
        emissionsPageHide();

        //bike
        rideABikeButton.setVisible(true);
        bikeIcon.setVisible(true);

        //ride bus button visible
        rideABusButton.setVisible(true);
        busIcon.setVisible(true);

        //metro
        rideAMetroButton.setVisible(true);
        metroIcon.setVisible(true);

        //taxi
        rideATaxiButton.setVisible(true);
        taxiIcon.setVisible(true);

        //train
        rideATrainButton.setVisible(true);
        trainIcon.setVisible(true);

        //plane
        rideAPlaneButton.setVisible(true);
        planeIcon.setVisible(true);

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

        //metro
        rideAMetroButton.setVisible(false);
        metroIcon.setVisible(false);

        //taxi
        rideATaxiButton.setVisible(false);
        taxiIcon.setVisible(false);

        //train
        rideATrainButton.setVisible(false);
        trainIcon.setVisible(false);

        //plane
        rideAPlaneButton.setVisible(false);
        planeIcon.setVisible(false);
    }

    /**
     * Functionality when the user clicks the ride public transportation button.
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

        //metro
        rideAMetroButton.setVisible(false);
        metroIcon.setVisible(false);

        //taxi
        rideATaxiButton.setVisible(false);
        taxiIcon.setVisible(false);

        //train
        rideATrainButton.setVisible(false);
        trainIcon.setVisible(false);

        //plane
        rideAPlaneButton.setVisible(false);
        planeIcon.setVisible(false);
    }

    /**
     * Functionality when the user clicks the ride the metro button.
     * @param event mouse click.
     */
    public void rideMetroButtonOnClick(ActionEvent event) {
        //features
        metroText.setVisible(true);
        emissionFactorMetro.setVisible(true);
        metroStatus.setVisible(true);
        addMetroButton.setVisible(true);

        backToEmissionPageButton.setVisible(false);
        backToTransportationTypePageButton.setVisible(true);

        //bike
        rideABikeButton.setVisible(false);
        bikeIcon.setVisible(false);

        //ride bus button visible off
        rideABusButton.setVisible(false);
        busIcon.setVisible(false);

        //metro
        rideAMetroButton.setVisible(false);
        metroIcon.setVisible(false);

        //taxi
        rideATaxiButton.setVisible(false);
        taxiIcon.setVisible(false);

        //train
        rideATrainButton.setVisible(false);
        trainIcon.setVisible(false);

        //plane
        rideAPlaneButton.setVisible(false);
        planeIcon.setVisible(false);
    }

    /**
     * Functionality when the user clicks the ride the taxi button.
     * @param event mouse click.
     */
    public void rideTaxiButtonOnClick(ActionEvent event) {
        //features
        taxiText.setVisible(true);
        emissionFactorTaxi.setVisible(true);
        taxiStatus.setVisible(true);
        addTaxiButton.setVisible(true);

        backToEmissionPageButton.setVisible(false);
        backToTransportationTypePageButton.setVisible(true);

        //bike
        rideABikeButton.setVisible(false);
        bikeIcon.setVisible(false);

        //ride bus button visible off
        rideABusButton.setVisible(false);
        busIcon.setVisible(false);

        //metro
        rideAMetroButton.setVisible(false);
        metroIcon.setVisible(false);

        //taxi
        rideATaxiButton.setVisible(false);
        taxiIcon.setVisible(false);

        //train
        rideATrainButton.setVisible(false);
        trainIcon.setVisible(false);

        //plane
        rideAPlaneButton.setVisible(false);
        planeIcon.setVisible(false);
    }

    /**
     * Functionality when the user clicks the ride the train button.
     * @param event mouse click.
     */
    public void rideTrainButtonOnClick(ActionEvent event) {
        //features
        trainText.setVisible(true);
        emissionFactorTrain.setVisible(true);
        trainStatus.setVisible(true);
        addTrainButton.setVisible(true);

        backToEmissionPageButton.setVisible(false);
        backToTransportationTypePageButton.setVisible(true);

        //bike
        rideABikeButton.setVisible(false);
        bikeIcon.setVisible(false);

        //ride bus button visible off
        rideABusButton.setVisible(false);
        busIcon.setVisible(false);

        //metro
        rideAMetroButton.setVisible(false);
        metroIcon.setVisible(false);

        //taxi
        rideATaxiButton.setVisible(false);
        taxiIcon.setVisible(false);

        //train
        rideATrainButton.setVisible(false);
        trainIcon.setVisible(false);

        //plane
        rideAPlaneButton.setVisible(false);
        planeIcon.setVisible(false);
    }

    /**
     * Functionality when the user clicks the ride the plane button.
     * @param event mouse click.
     */
    public void ridePlaneButtonOnClick(ActionEvent event) {
        //features
        planeText.setVisible(true);
        emissionFactorPlane.setVisible(true);
        planeStatus.setVisible(true);
        addPlaneButton.setVisible(true);

        backToEmissionPageButton.setVisible(false);
        backToTransportationTypePageButton.setVisible(true);

        //bike
        rideABikeButton.setVisible(false);
        bikeIcon.setVisible(false);

        //ride bus button visible off
        rideABusButton.setVisible(false);
        busIcon.setVisible(false);

        //metro
        rideAMetroButton.setVisible(false);
        metroIcon.setVisible(false);

        //taxi
        rideATaxiButton.setVisible(false);
        taxiIcon.setVisible(false);

        //train
        rideATrainButton.setVisible(false);
        trainIcon.setVisible(false);

        //plane
        rideAPlaneButton.setVisible(false);
        planeIcon.setVisible(false);
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

        //metro
        rideAMetroButton.setVisible(true);
        metroIcon.setVisible(true);
        metroText.setVisible(false);
        emissionFactorMetro.setVisible(false);
        metroStatus.setVisible(false);
        addMetroButton.setVisible(false);

        //taxi
        rideATaxiButton.setVisible(true);
        taxiIcon.setVisible(true);
        taxiText.setVisible(false);
        emissionFactorTaxi.setVisible(false);
        taxiStatus.setVisible(false);
        addTaxiButton.setVisible(false);

        //train
        rideATrainButton.setVisible(true);
        trainIcon.setVisible(true);
        trainText.setVisible(false);
        emissionFactorTrain.setVisible(false);
        trainStatus.setVisible(false);
        addTrainButton.setVisible(false);

        //plane
        rideAPlaneButton.setVisible(true);
        planeIcon.setVisible(true);
        planeText.setVisible(false);
        emissionFactorPlane.setVisible(false);
        planeStatus.setVisible(false);
        addPlaneButton.setVisible(false);
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
        Double carbonEmissionDouble = localProduce.getFoodProducedLocally() + localProduce.getPackagedFood();
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
            PublicTransportation bus = new PublicTransportation(Float.parseFloat(carMileageTextPublic.getText()),
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
     * This methods adds riding the metro in to the user's database.
     */
    public void addMetroRide() {
        final String token = UserToken.getUserToken();

        if (!emptyMetroRideBoxes()) {
            Float numberOfKilometers = Float.parseFloat(metroText.getText());
            Float emissionFactor = Float.parseFloat(emissionFactorMetro.getText());
            MetroRide metroRide = new MetroRide(numberOfKilometers, emissionFactor);
            JwtUser jwtUser = jwtValidator.validate(token);
            float carbonEmission = numberOfKilometers * emissionFactor;
            String number = String.format("%.5f", carbonEmission);
            metroStatus.setText("You have saved: " + number + " tons of CO2");
            DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
            Date today = Calendar.getInstance().getTime();
            EmissionsClient emissionsClient = new EmissionsClient("7", carbonEmission, today);
            String response = userService.addEmissionOfUser(restTemplate, Url.ADD_EMISSION.getUrl(),
                    jwtUser.getId(), emissionsClient, token);
            System.out.println(response);
        }
    }

    /**
     * This methods adds riding the taxi in to the user's database.
     */
    public void addTaxiRide() {
        final String token = UserToken.getUserToken();

        if (!emptyTaxiRideBoxes()) {
           Float numberOfKilometers = Float.parseFloat(taxiText.getText());
            Float emissionFactor = Float.parseFloat(emissionFactorTaxi.getText());
            TaxiRide taxiRide = new TaxiRide(numberOfKilometers, emissionFactor);
            JwtUser jwtUser = jwtValidator.validate(token);
            float carbonEmission = numberOfKilometers * emissionFactor;
            String number = String.format("%.5f", carbonEmission);
            taxiStatus.setText("You have saved: " + number + " tons of CO2");
            DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
            Date today = Calendar.getInstance().getTime();
            EmissionsClient emissionsClient = new EmissionsClient("8", carbonEmission, today);
            String response = userService.addEmissionOfUser(restTemplate, Url.ADD_EMISSION.getUrl(),
                    jwtUser.getId(), emissionsClient, token);
            System.out.println(response);
        }
    }

    /**
     * This methods adds riding the train in to the user's database.
     */
    public void addTrainRide() {
        final String token = UserToken.getUserToken();

        if (!emptyTrainRideBoxes()) {
            Float numberOfKilometers = Float.parseFloat(trainText.getText());
            Float emissionFactor = Float.parseFloat(emissionFactorTrain.getText());
            TrainRide trainRide = new TrainRide(numberOfKilometers, emissionFactor);
            JwtUser jwtUser = jwtValidator.validate(token);
            float carbonEmission = numberOfKilometers * emissionFactor;
            String number = String.format("%.5f", carbonEmission);
            trainStatus.setText("You have saved: " + number + " tons of CO2");
            DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
            Date today = Calendar.getInstance().getTime();
            EmissionsClient emissionsClient = new EmissionsClient("9", carbonEmission, today);
            String response = userService.addEmissionOfUser(restTemplate, Url.ADD_EMISSION.getUrl(),
                    jwtUser.getId(), emissionsClient, token);
            System.out.println(response);
        }
    }

    /**
     * This methods adds riding the plane in to the user's database.
     */
    public void addPlaneRide() {
        final String token = UserToken.getUserToken();

        if (!emptyPlaneRideBoxes()) {
            Float numberOfKilometers = Float.parseFloat(planeText.getText());
            Float emissionFactor = Float.parseFloat(emissionFactorPlane.getText());
            PlaneRide planeRide = new PlaneRide(numberOfKilometers, emissionFactor);
            JwtUser jwtUser = jwtValidator.validate(token);
            float carbonEmission = numberOfKilometers * emissionFactor;
            String number = String.format("%.5f", carbonEmission);
            planeStatus.setText("You have saved: " + number + " tons of CO2");
            DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
            Date today = Calendar.getInstance().getTime();
            EmissionsClient emissionsClient = new EmissionsClient("10", carbonEmission, today);
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

            SolarPanels solarPanel = new SolarPanels(factorOfCO2Avoidance, annualSolarEnergyProduction, numberOfSolarPanels);
            JwtUser jwtUser = jwtValidator.validate(token);
            //Turning kg into tonnes by dividing it by a 1000
            float carbonEmission = (annualSolarEnergyProduction * factorOfCO2Avoidance * numberOfSolarPanels) / 1000f ;
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
     * This methods adds house temperature in to the user's database.
     */
    public void addEmissionsForHouseTemperature() {
        final String token = UserToken.getUserToken();

        if (!emptyTemperatureBoxes()) {
            Double userHouseTemperatureBefore = Double.valueOf(whatTempText.getText());
            Double userHouseTemperatureAfter = Double.valueOf(whatTempAfterText.getText());
            HouseTemperature houseTemperature = new HouseTemperature(
                    userHouseTemperatureBefore, userHouseTemperatureAfter);

            JwtUser jwtUser = jwtValidator.validate(token);
            float carbonEmissionPPM = userHouseTemperatureBefore.floatValue()
                    - userHouseTemperatureAfter.floatValue();
            //1 degree C = 225ppm = 1.784 tons of C02
            float carbonEmission = carbonEmissionPPM * 1.784f;
            String number = String.format("%.5f", carbonEmission);
            temperatureStatus.setText("You have saved: " + number + " tons of CO2");
            DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
            Date today = Calendar.getInstance().getTime();
            EmissionsClient emissionsClient = new EmissionsClient("6", carbonEmission, today);
            String response = userService.addEmissionOfUser(restTemplate, Url.ADD_EMISSION.getUrl(),
                    jwtUser.getId(), emissionsClient, token);
            System.out.println(response);
        }
    }

    /**
     * This methods adds electricity used in household in to the user's database.
     */
    public void addElectricityInHouseHold() {
        final String token = UserToken.getUserToken();

        if (!emptyElectricityBoxes()) {
            Double electricityUsage = Double.valueOf(electricityText.getText());
            Double emissionFactor = Double.valueOf(emissionFactorElectricity.getText());
            ElectricityEmission electricityEmission = new ElectricityEmission(
                    electricityUsage);
            JwtUser jwtUser = jwtValidator.validate(token);
            // use(kWh/yr) * EF(kgC02/kWh) = emissions(kg CO2)
            //divided by 1000 to convert it into tonnes
            float carbonEmission = (electricityUsage.floatValue() * emissionFactor.floatValue()) / 1000;
            String number = String.format("%.5f", carbonEmission);
            electricityStatus.setText("You have saved: " + number + " tons of CO2");
            DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
            Date today = Calendar.getInstance().getTime();
            EmissionsClient emissionsClient = new EmissionsClient("11", carbonEmission, today);
            String response = userService.addEmissionOfUser(restTemplate, Url.ADD_EMISSION.getUrl(),
                    jwtUser.getId(), emissionsClient, token);
            System.out.println(response);
        }
    }

    /**
     * This methods adds natural gas used in household in to the user's database.
     */
    public void addNaturalGasInHouseHold() {
        final String token = UserToken.getUserToken();

        if (!emptyNaturalGasBoxes()) {
            Double naturalGasUsage = Double.valueOf(naturalGasText.getText());
            Double emissionFactor = Double.valueOf(emissionFactorNaturalGas.getText());
           NaturalGasEmission naturalGasEmission = new NaturalGasEmission(
                   naturalGasUsage);
            JwtUser jwtUser = jwtValidator.validate(token);
            // use(therms/yr) * EF(kgC02/therms) = emissions(kg CO2)
            //divided by 1000 to convert it into tonnes
            float carbonEmission = (naturalGasUsage.floatValue() * emissionFactor.floatValue()) / 1000;
            String number = String.format("%.5f", carbonEmission);
            naturalGasStatus.setText("You have saved: " + number + " tons of CO2");
            DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
            Date today = Calendar.getInstance().getTime();
            EmissionsClient emissionsClient = new EmissionsClient("12", carbonEmission, today);
            String response = userService.addEmissionOfUser(restTemplate, Url.ADD_EMISSION.getUrl(),
                    jwtUser.getId(), emissionsClient, token);
            System.out.println(response);
        }
    }

    /**
     * This methods adds fuel oil used in household in to the user's database.
     */
    public void addFuelInHouseHold() {
        final String token = UserToken.getUserToken();

        if (!emptyFuelOilBoxes()) {
            Double fuelOilUsage = Double.valueOf(fuelOilText.getText());
            Double emissionFactor = Double.valueOf(emissionFactorFuelOil.getText());
            FuelOilEmission fuelOilEmission = new FuelOilEmission(fuelOilUsage);
            JwtUser jwtUser = jwtValidator.validate(token);
            // use(litres/yr) * EF(kgC02/litres) = emissions(kg CO2)
            //divided by 1000 to convert it into tonnes
            float carbonEmission = (fuelOilUsage.floatValue() * emissionFactor.floatValue()) / 1000;
            String number = String.format("%.5f", carbonEmission);
            fuelOilStatus.setText("You have saved: " + number + " tons of CO2");
            DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
            Date today = Calendar.getInstance().getTime();
            EmissionsClient emissionsClient = new EmissionsClient("13", carbonEmission, today);
            String response = userService.addEmissionOfUser(restTemplate, Url.ADD_EMISSION.getUrl(),
                    jwtUser.getId(), emissionsClient, token);
            System.out.println(response);
        }
    }

    /**
     * This methods adds LPG used in household in to the user's database.
     */
    public void addLPGInHouseHold() {
        final String token = UserToken.getUserToken();

        if (!emptyLPGBoxes()) {
            Double LPGUsage = Double.valueOf(lpgText.getText());
            Double emissionFactor = Double.valueOf(emissionFactorLPG.getText());
            LPGEmission lpgEmission = new LPGEmission(LPGUsage);
            JwtUser jwtUser = jwtValidator.validate(token);
            // use(litres/yr) * EF(kgC02/litres) = emissions(kg CO2)
            //divided by 1000 to convert it into tonnes
            float carbonEmission = (LPGUsage.floatValue() * emissionFactor.floatValue()) / 1000;
            String number = String.format("%.5f", carbonEmission);
            LPGStatus.setText("You have saved: " + number + " tons of CO2");
            DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
            Date today = Calendar.getInstance().getTime();
            EmissionsClient emissionsClient = new EmissionsClient("14", carbonEmission, today);
            String response = userService.addEmissionOfUser(restTemplate, Url.ADD_EMISSION.getUrl(),
                    jwtUser.getId(), emissionsClient, token);
            System.out.println(response);
        }
    }

    /**
     * This methods adds waste used in household in to the user's database.
     */
    public void addWasteInHouseHold() {
        final String token = UserToken.getUserToken();

        if (!emptyWasteBoxes()) {
            Double wasteUsage = Double.valueOf(wasteText.getText());
            Double emissionFactor = Double.valueOf(emissionFactorWaste.getText());
            WasteEmission wasteEmission = new WasteEmission(wasteUsage);
            JwtUser jwtUser = jwtValidator.validate(token);
            // use(kg/week) * EF(kgC02/kg) = emissions(kg CO2)
            //divided by 1000 to convert it into tonnes
            float carbonEmission = (wasteUsage.floatValue() * emissionFactor.floatValue()) / 1000;
            String number = String.format("%.5f", carbonEmission);
            wasteStatus.setText("You have saved: " + number + " tons of CO2");
            DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
            Date today = Calendar.getInstance().getTime();
            EmissionsClient emissionsClient = new EmissionsClient("15", carbonEmission, today);
            String response = userService.addEmissionOfUser(restTemplate, Url.ADD_EMISSION.getUrl(),
                    jwtUser.getId(), emissionsClient, token);
            System.out.println(response);
        }
    }

    /**
     * This methods adds water used in household in to the user's database.
     */
    public void addWaterInHouseHold() {
        final String token = UserToken.getUserToken();

        if (!emptyWaterBoxes()) {
            Double waterUsage = Double.valueOf(waterText.getText());
            Double emissionFactor = Double.valueOf(emissionFactorWater.getText());
            WaterEmission waterEmission = new WaterEmission(waterUsage);
            JwtUser jwtUser = jwtValidator.validate(token);
            // use(litres/yr) * EF(kgC02/litres) = emissions(kg CO2)
            //divided by 1000 to convert it into tonnes
            float carbonEmission = (waterUsage.floatValue() * emissionFactor.floatValue()) / 1000;
            String number = String.format("%.5f", carbonEmission);
            waterStatus.setText("You have saved: " + number + " tons of CO2");
            DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
            Date today = Calendar.getInstance().getTime();
            EmissionsClient emissionsClient = new EmissionsClient("16", carbonEmission, today);
            String response = userService.addEmissionOfUser(restTemplate, Url.ADD_EMISSION.getUrl(),
                    jwtUser.getId(), emissionsClient, token);
            System.out.println(response);
        }
    }

    /**
     * This method handles the functionality of giving an error when
     * any of the fields in the adding a vegetarian meal is empty.
     * @return boolean - returns true if the field is null or empty and false if not.
     * */
    private boolean emptyVegetarianMealBoxes() {
        if (checkEmptyOrNullBox
                (dairyText, cerealText, fruitsAndVegetablesText, otherVegetarianMealText)) {
            emptyTextBoxPopup();
            return true;
        } else {
            return false;
        }
    }

    private boolean emptyRideABikeBoxes() {
        if (checkEmptyOrNullBox
                (carMileageText, fuelTypeText, numberOfMilesText)) {
            emptyTextBoxPopup();
            return true;
        } else {
            return false;
        }
    }

    private boolean emptyRideABusBoxes() {
        if (checkEmptyOrNullBox
                (carMileageTextPublic, fuelTypeTextPublic, numberOfMilesTextPublic)) {
            emptyTextBoxPopup();
            return true;
        } else {
            return false;
        }
    }

    private boolean emptySolarPanelBoxes() {
        if (checkEmptyOrNullBox
                (systemSizeText, annualSolarEnergyText, numberSolarPanels)) {
            emptyTextBoxPopup();
            return true;
        } else {
            return false;
        }
    }

    private boolean emptyTemperatureBoxes() {
        if (checkEmptyOrNullBox(
                whatTempText, whatTempAfterText)) {
            emptyTextBoxPopup();
            return true;
        } else {
            return false;
        }
    }

    private boolean emptyElectricityBoxes() {
        if (checkEmptyOrNullBox(
               electricityText, emissionFactorElectricity)) {
            emptyTextBoxPopup();
            return true;
        } else {
            return false;
        }
    }

    private boolean emptyNaturalGasBoxes() {
        if (checkEmptyOrNullBox(
                naturalGasText, emissionFactorNaturalGas)) {
            emptyTextBoxPopup();
            return true;
        } else {
            return false;
        }
    }

    private boolean emptyFuelOilBoxes() {
        if (checkEmptyOrNullBox
                (fuelOilText, emissionFactorFuelOil)) {
            emptyTextBoxPopup();
            return true;
        } else {
            return false;
        }
    }

    private boolean emptyLPGBoxes() {
        if (checkEmptyOrNullBox
                (lpgText, emissionFactorLPG)) {
            emptyTextBoxPopup();
            return true;
        } else {
            return false;
        }
    }

    private boolean emptyWasteBoxes() {
        if (checkEmptyOrNullBox
                (wasteText, emissionFactorWaste)) {
            emptyTextBoxPopup();
            return true;
        } else {
            return false;
        }
    }

    private boolean emptyWaterBoxes() {
        if (checkEmptyOrNullBox
                (waterText, emissionFactorWater)) {
            emptyTextBoxPopup();
            return true;
        } else {
            return false;
        }
    }

    private boolean emptyMetroRideBoxes() {
        if (checkEmptyOrNullBox
                (metroText, emissionFactorMetro)) {
            emptyTextBoxPopup();
            return true;
        } else {
            return false;
        }
    }

    private boolean emptyTaxiRideBoxes() {
        if (checkEmptyOrNullBox
                (taxiText, emissionFactorTaxi)) {
            emptyTextBoxPopup();
            return true;
        } else {
            return false;
        }
    }

    private boolean emptyTrainRideBoxes() {
        if (checkEmptyOrNullBox
                (trainText, emissionFactorTrain)) {
            emptyTextBoxPopup();
            return true;
        } else {
            return false;
        }
    }

    private boolean emptyPlaneRideBoxes() {
        if (checkEmptyOrNullBox
                (planeText, emissionFactorPlane)) {
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

        try {
            //FXMLLoader loader = new FXMLLoader(getClass().getResource("src/main/java/client/profile_page/side_panel.fxml"));
            URL url = new File(
                    "src/main/java/client/mainpage/fxml/sidepanel.fxml").toURI().toURL();
            VBox box = FXMLLoader.load(url);
            //VBox box = FXMLLoader.load(getClass().getResource("client.profile_page.sidepanel.fxml"));
            drawer.setSidePane(box);
        } catch (IOException ex) {
            Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
        }

        HamburgerNextArrowBasicTransition transition = new HamburgerNextArrowBasicTransition(hamburger);
        transition.setRate(-1);
        hamburger.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
            transition.setRate(transition.getRate() * -1);
            transition.play();

            if (drawer.isOpened()) {
                drawer.close();
            } else {
                drawer.open();
            }
        });
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