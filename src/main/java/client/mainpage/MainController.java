package client.mainpage;

import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;


/**
 * This is the main controller for the application
 * once the user logs into the application.
 */
@SuppressWarnings("Duplicates")
public class MainController {

    @FXML
    private Pane mainWindow;

    @FXML
    private Pane emissionsWindow;

    @FXML
    private Label addEmissionsText;

    @FXML
    private ImageView foodIcon;

    @FXML
    private ImageView transportationIcon;

    @FXML
    private ImageView tempIcon;

    @FXML
    private ImageView energyIcon;

    @FXML
    private ImageView customIcon;

    @FXML
    private Button mealButton;

    @FXML
    private Button vegetarianMealButton;

    @FXML
    private TextField localProduceText;

    @FXML
    private TextField dairyText;

    @FXML
    private TextField cerealText;

    @FXML
    private TextField fruitsAndVegetablesText;

    @FXML
    private TextField otherVegetarianMealText;

    @FXML
    private Button addButton;

    @FXML
    private Button transportationButton;

    @FXML
    private Button temperatureButton;

    @FXML
    private Button renewableEnergyButton;

    @FXML
    private Button customButton;

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
    }

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

    public void emissionsPageShow() {
        foodIcon.setVisible(true);
        mealButton.setVisible(true);
        transportationIcon.setVisible(true);
        transportationButton.setVisible(true);
        tempIcon.setVisible(true);
        temperatureButton.setVisible(true);
        renewableEnergyButton.setVisible(true);
        energyIcon.setVisible(true);
        customButton.setVisible(true);
        customIcon.setVisible(true);
        vegetarianMealButton.setVisible(false);
        localProduceText.setVisible(false);
        dairyText.setVisible(false);
        cerealText.setVisible(false);
        fruitsAndVegetablesText.setVisible(false);
        otherVegetarianMealText.setVisible(false);
        addEmissionsText.setText("Choose Your Emission Type");
        addButton.setVisible(false);
    }

    public void emissionsPageHide() {
        foodIcon.setVisible(false);
        mealButton.setVisible(false);
        transportationIcon.setVisible(false);
        transportationButton.setVisible(false);
        tempIcon.setVisible(false);
        temperatureButton.setVisible(false);
        renewableEnergyButton.setVisible(false);
        energyIcon.setVisible(false);
        customButton.setVisible(false);
        customIcon.setVisible(false);
    }

    public void mealButtonOnClick(ActionEvent event) {
        emissionsPageHide();
        vegetarianMealButton.setVisible(true);
        localProduceText.setVisible(true);
        addEmissionsText.setText("    Choose Your Meal Type");
    }

    public void vegetarianMealButtonOnClick(ActionEvent event) {
        vegetarianMealButton.setVisible(false);
        localProduceText.setVisible(false);
        dairyText.setVisible(true);
        cerealText.setVisible(true);
        fruitsAndVegetablesText.setVisible(true);
        otherVegetarianMealText.setVisible(true);
        addButton.setVisible(true);
    }

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

    /**
     * Renders the login page once user logs out.
     * @param event - once a user clicks the button linked to
     *              this method, it starts to execute.
     */
    public void logoutWindow(ActionEvent event) {
        LogoutController logoutController = new LogoutController();
        logoutController.logout();
    }

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