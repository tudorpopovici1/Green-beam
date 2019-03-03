package client.loginpage;

import client.Url;
import client.services.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import org.springframework.web.client.RestTemplate;
import server.model.AuthenticateUser;
import server.model.Users;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class handles all the functionality that is in
 * the main login page of the application.
 */
@SuppressWarnings({"CanBeFinal", "unused"})
public class LoginController {
    /**
     * This is getting the attribute window attribute from the
     * Login.fxml file.
     */
    @FXML
    private AnchorPane window;
    /**
     * This is getting the two status bar attributes from the
     * Login.fxml file.
     */
    @FXML
    private Label lblStatus;

    @FXML
    private Label lblStatus2;
    /**
     * This is getting all the textField attributes from the
     * Login.fxml file.
     */

    @FXML
    private TextField txtUsername;

    @FXML
    private TextField firstNameBox;

    @FXML
    private TextField lastNameBox;

    @FXML
    private TextField doBBox;

    @FXML
    private TextField countryBox;

    @FXML
    private TextField usernameBox;

    @FXML
    private TextField emailBox;
    /**
     * This is getting all the passwordField attributes from the
     * Login.fxml file.
     */
    @FXML
    private PasswordField txtPassword;

    @FXML
    private PasswordField passwordBox;

    @FXML
    private PasswordField passwordBox2;
    /**
     * This is getting all the button attributes from the
     * Login.fxml file.
     */
    @FXML
    private Button nextButton;

    @FXML
    private Button registerButton;

    /**
     * This is getting the ImageView attribute from the
     * Login.fxml file.
     */
    @FXML
    private ImageView thumbsUp;

    /**
     * Creating a new userService object so all the user related
     * methods could be used in this class.
     */
    private final UserService userService;

    {
        userService = new UserService();
    }

    /**
     * Creating a new restTemplate object so all the restTemplate related
     * methods could be used in this class.
     */
    private final RestTemplate restTemplate;

    {
        restTemplate = new RestTemplate();
    }

    /**
     * Creating a newUser from the Users class.
     */
    private Users newUser;
    /**
     * Creating a progress bar to track down the progress of
     * registration.
     */
    private ProgressBar progress;

    /**
     * This method handles the functionality of a user login.
     * @param event - Whenever a user clicks the "login" button, this method starts to run.
     * */

    public void login(ActionEvent event) {
        if (!txtUsername.getText().equals("")
                && !txtPassword.getText().equals("")) {
            AuthenticateUser authenticateUser =
                    new AuthenticateUser(txtUsername.getText(), txtPassword.getText());
            userService.authUser(restTemplate, Url.AUTH_USER.getUrl(), authenticateUser, lblStatus);
        } else if (txtUsername.getText().equals("") || txtPassword.getText().equals("")) {
            emptyLoginBoxPopup();
        } else {
            lblStatus.setText("Either username or password is incorrect.");
        }
    }

    /**
     * This method handles the functionality of registering a user.
     * @param event - Whenever a user clicks the "next" button,
     *              this method starts to run.
     * */
    public void register(ActionEvent event) {
        newUser = new Users();
        String pattern = "dd-mm-yyyy";
        DateFormat dateFormat = new SimpleDateFormat(pattern);
        try {
            if (!emptyRegistrationFormFirstPagePopup()) {
                newUser.setFirstName(firstNameBox.getText());
                newUser.setLastName(lastNameBox.getText());
                Date dob = dateFormat.parse(doBBox.getText());
                newUser.setDateOfBirth(dob);
                newUser.setCountry(countryBox.getText());
                hideRegistrationFormFirstPage();
                registrationFormSecondPage();
                createRegisterButton();
                setProgressBar();
                lblStatus2.setVisible(false);
                progress.setProgress(0.5);
                registerButton.setOnAction(this::getDataFromSecondPage);
            }
        } catch (ParseException e) {
            lblStatus2.setText("Please follow the given date format.");
        }
    }

    /**
     * This method handles the functionality of getting new
     * user data from the second registration page.
     * @param event - Whenever a user clicks the "Register!"
     *              button, this method starts to run.
     * */
    private void getDataFromSecondPage(ActionEvent event) {
        if (!emptyRegistrationFormSecondPagePopup()) {
            newUser.setUsername(usernameBox.getText());
            if (passwordBox.getText() != null && passwordBox2.getText() != null
                   && newUserPasswordMatchCheck()) {
                newUser.setEmail(emailBox.getText());
                progress.setProgress(1.0);
                hideRegistrationFormSecondPage();
                registerButton.setVisible(false);
                registrationComplete();
                System.out.println(newUser.toString());
            }
        }
    }

    /**
     * This method handles the functionality of hiding the registration form from the first
     * page.
     * */
    private void hideRegistrationFormFirstPage() {
        firstNameBox.setVisible(false);
        lastNameBox.setVisible(false);
        doBBox.setVisible(false);
        countryBox.setVisible(false);
        nextButton.setVisible(false);
    }

    /**
     * This method handles the functionality of creating a new registration
     * button on the second registration form page.
     * */
    private void createRegisterButton() {
        registerButton = new Button();
        registerButton.setText("Register!");
        registerButton.setId("registerButton");
        window.getChildren().add(registerButton);
        registerButton.setLayoutX(nextButton.getLayoutX());
        registerButton.setLayoutY(nextButton.getLayoutY());
    }

    /**
     * This method handles the functionality of creating the new registration
     * form on the second registration form page.
     * */
    private void registrationFormSecondPage() {
        usernameBox = new TextField();
        usernameBox.setPromptText("New Username");
        window.getChildren().add(usernameBox);
        usernameBox.setLayoutX(firstNameBox.getLayoutX());
        usernameBox.setLayoutY(firstNameBox.getLayoutY());
        passwordBox = new PasswordField();
        passwordBox.setPromptText("Set Password");
        window.getChildren().add(passwordBox);
        passwordBox.setLayoutX(lastNameBox.getLayoutX());
        passwordBox.setLayoutY(lastNameBox.getLayoutY());
        passwordBox2 = new PasswordField();
        passwordBox2.setPromptText("Retype your password");
        window.getChildren().add(passwordBox2);
        passwordBox2.setLayoutX(doBBox.getLayoutX());
        passwordBox2.setLayoutY(doBBox.getLayoutY());
        emailBox = new TextField();
        emailBox.setPromptText("Email");
        window.getChildren().add(emailBox);
        emailBox.setLayoutX(countryBox.getLayoutX());
        emailBox.setLayoutY(countryBox.getLayoutY());
    }

    /**
     * This method handles the functionality of creating a new progress bar
     * to inform the user how far are they in the registration form.
     * */
    private void setProgressBar() {
        progress = new ProgressBar();
        progress.setStyle("-fx-accent: green;");
        window.getChildren().add(progress);
        progress.setLayoutX(lblStatus2.getLayoutX() + 60);
        progress.setLayoutY(lblStatus2.getLayoutY());
        progress.setPrefWidth(230);
        progress.setPrefHeight(27);
    }

    /**
     * This method handles the functionality of creating a new progress bar
     * to inform the user how far are they in the registration form.
     * */
    private void hideRegistrationFormSecondPage() {
        usernameBox.setVisible(false);
        passwordBox.setVisible(false);
        passwordBox2.setVisible(false);
        emailBox.setVisible(false);
    }

    /**
     * This method handles the functionality of finishing the registration.
     * */
    private void registrationComplete() {
        thumbsUp.setVisible(true);
        thumbsUp.setFitHeight(150);
        thumbsUp.setFitWidth(150);
        thumbsUp.setLayoutX(passwordBox2.getLayoutX());
        thumbsUp.setLayoutY(passwordBox2.getLayoutY() - 70);
        thumbsUp.setOpacity(0.7);
        lblStatus2.setVisible(true);
        lblStatus2.setText("Registration complete!\n"
                + "Let's make a difference together!\nLogin now!");
        lblStatus2.setTextAlignment(TextAlignment.CENTER);
        lblStatus2.setPrefHeight(100);
        lblStatus2.setLayoutY(thumbsUp.getLayoutY());
        lblStatus2.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 20));
        System.out.println(newUser.toString());
        userService.addUser(
                restTemplate, Url.ADD_USER.getUrl(), newUser, lblStatus2);
    }

    /**
     * This method handles the functionality of giving an error
     * either the username or password box is empty.
     * */
    private void emptyLoginBoxPopup() {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("Either your username or password box is empty!"
                + "\nPlease try again.");
        alert.showAndWait();
    }
    /**
     * This method handles the functionality of checking whether
     * the user's new password and retyped password match or not.
     * @return boolean - return true if passwords match, if not, it returns false.
     */

    private boolean newUserPasswordMatchCheck() {
        if (passwordBox.getText().equals(passwordBox2.getText())) {
            newUser.setPassword(passwordBox.getText());
            return true;
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Your passwords do not match."
                    + "\nPlease try again.");
            alert.showAndWait();
            return false;
        }
    }

    /**
     * This method handles the functionality of giving an
     * error when any of the fields in the first registration form is empty.
     * @return boolean - returns true if the field is null or empty and false if not.
     * */
    private boolean emptyRegistrationFormFirstPagePopup() {
        if (checkEmptyOrNullBox(
                firstNameBox, lastNameBox, doBBox, countryBox)) {
            giveEmptyOrNullFieldError();
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method handles the functionality of giving an error when
     * any of the fields in the second registration form is empty.
     * @return boolean - returns true if the field is null or empty and false if not.
     * */
    private boolean emptyRegistrationFormSecondPagePopup() {
        if (checkEmptyOrNullBox(
                usernameBox, passwordBox, passwordBox2, emailBox)) {
            giveEmptyOrNullFieldError();
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
     * This method handles the functionality of giving an error when
     * a box is null or empty.
     * */
    private void giveEmptyOrNullFieldError() {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("One of your fields is empty.\nPlease try again.");
        alert.showAndWait();
    }
}
