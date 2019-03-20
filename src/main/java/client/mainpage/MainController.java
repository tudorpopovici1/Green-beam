package client.mainpage;

import client.Url;
import client.UserToken;
import client.services.ApiService;
import client.services.UserService;
import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import org.springframework.web.client.RestTemplate;
import server.model.EmissionsClient;
import server.model.Meal;

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
    private TextField litresOfFuelText;

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
    private ImageView localProduceIcon;

    @FXML
    private Button mealButton;

    @FXML
    private Button vegetarianMealButton;

    @FXML
    private Button localProduceButton;

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

    private RestTemplate restTemplate = new RestTemplate();
    private ApiService apiService = new ApiService();
    private UserService userService = new UserService();

    /**---------------------------- MAIN PAGE -----------------------------------------**/

    /**
     * Renders the main page.
     * @param event - once a user clicks the button linked to
     *              this method, it starts to execute.
     *
     */
    public void mainPage(ActionEvent event) {
        mainWindow.setVisible(true);
        mainWindow.toFront();
        animatePane(mainWindow);
        displayUsernameOnMain("user: irtazahashmi");
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
        localProduceIcon.setVisible(false);
        vegetarianMealButton.setVisible(false);
        localProduceButton.setVisible(false);
        dairyText.setVisible(false);
        cerealText.setVisible(false);
        fruitsAndVegetablesText.setVisible(false);
        otherVegetarianMealText.setVisible(false);
        addEmissionsText.setText("Choose Your Emission Type");
        addMealButton.setVisible(false);
        rideABikeButton.setVisible(false);
        bikeIcon.setVisible(false);
        litresOfFuelText.setVisible(false);
        carMileageText.setVisible(false);
        fuelTypeText.setVisible(false);
        addTransportationButton.setVisible(false);
        backToEmissionPageButton.setVisible(false);
        backToMealTypePageButton.setVisible(false);
        backToTransportationTypePageButton.setVisible(false);
        vegetarianMealStatus.setVisible(false);
        transportationStatus.setVisible(false);
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
     * Functionality when the user clicks the vegetarian meal button.
     * @param event mouse click.
     */
    public void transportationButtonOnClick(ActionEvent event) {
        emissionsPageHide();
        rideABikeButton.setVisible(true);
        bikeIcon.setVisible(true);
        backToEmissionPageButton.setVisible(true);
    }

    /**
     * Functionality when the user clicks the ride a bike button.
     * @param event mouse click.
     */
    public void rideABikeButtonOnClick(ActionEvent event) {
        litresOfFuelText.setVisible(true);
        carMileageText.setVisible(true);
        fuelTypeText.setVisible(true);
        bikeIcon.setVisible(false);
        addTransportationButton.setVisible(true);
        backToEmissionPageButton.setVisible(false);
        backToTransportationTypePageButton.setVisible(true);
        transportationStatus.setVisible(true);
    }

    /**
     * Functionality of the back button to the transportation page.
     * @param event mouse click
     */
    public void backToTransportationTypeButtonOnClick(ActionEvent event) {
        litresOfFuelText.setVisible(false);
        carMileageText.setVisible(false);
        fuelTypeText.setVisible(false);
        bikeIcon.setVisible(true);
        addTransportationButton.setVisible(false);
        backToEmissionPageButton.setVisible(true);
        backToTransportationTypePageButton.setVisible(false);
        rideABikeButton.setVisible(true);
        transportationStatus.setVisible(false);
    }

    /**
     * This methods adds a meal in to the user's database.
     */
    public void addEmissionsUser() {
        final String token = UserToken.getUserToken();

        Meal meal = new Meal(Float.parseFloat(dairyText.getText()),
                Float.parseFloat(otherVegetarianMealText.getText()),
                Float.parseFloat(fruitsAndVegetablesText.getText()),
                Float.parseFloat(cerealText.getText()));

        float carbonEmission = apiService.getVegetarianMealEmissions(meal);

        DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
        Date today = Calendar.getInstance().getTime();
        EmissionsClient emissionsClient = new EmissionsClient("1", carbonEmission, today);
        String response = userService.addEmissionOfUser(restTemplate, Url.ADD_EMISSION.getUrl(),
                69L, emissionsClient, token);
        System.out.println(response);
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