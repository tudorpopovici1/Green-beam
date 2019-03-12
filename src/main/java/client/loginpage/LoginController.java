package client.loginpage;

import client.Url;
import client.UserToken;
import client.services.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class handles all the functionality that is in
 * the main login page of the application.
 */
public class LoginController {

    public static final Pattern VALIDEMAIL =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

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

    @FXML
    private Button backButton;

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
     * This method handles the functionality of a user login.
     * @param event - Whenever a user clicks the "login" button, this method starts to run.
     * */

    public void login(ActionEvent event) {
        if (!txtUsername.getText().equals("")
                && !txtPassword.getText().equals("")) {
            AuthenticateUser authenticateUser =
                    new AuthenticateUser(txtUsername.getText(), txtPassword.getText());
            String response = userService
                    .authUser(restTemplate, Url.AUTH_USER.getUrl(), authenticateUser);
            lblStatus.setPrefWidth(403);
            if (response.equals("Incorrect username or password")) {
                lblStatus.setText(response);

            } else {
                lblStatus.setText("You have successfuly logged in.");
                System.out.println(response); // THIS IS THE TOKEN OF THE USER.
                UserToken.setUserToken(response);

            }
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
                backButton.setVisible(true);
                backButton.setLayoutY(nextButton.getLayoutY());
                backButton.setOnAction(this::goBack);
                createRegisterButton();
                registerButton.setOnAction(this::getDataFromSecondPage);
            }
        } catch (ParseException e) {
            lblStatus2.setText("Please follow the given date format.");
        }
    }

    /**
     * This method is fired up when a user click the back button
     * if they make a mistake in the first registration form.
     * @param event - the back button fires up this event.
     */
    public void goBack(ActionEvent event) {
        hideRegistrationFormSecondPage();
        firstNameBox.setVisible(true);
        firstNameBox.setText(newUser.getFirstName());
        lastNameBox.setVisible(true);
        lastNameBox.setText(newUser.getLastName());
        doBBox.setVisible(true);
        String datePattern = "dd-MM-yyyy";
        DateFormat df = new SimpleDateFormat(datePattern);
        Date userDoB = newUser.getDateOfBirth();
        String userDoBstring = df.format(userDoB);
        doBBox.setText(userDoBstring);
        countryBox.setVisible(true);
        countryBox.setText(newUser.getCountry());
        backButton.setVisible(false);
        registerButton.setText("Next");
        registerButton.setOnAction(this::register);
    }


    /**
     * This method handles the functionality of getting new
     * user data from the second registration page.
     * @param event - Whenever a user clicks the "Register!"
     *              button, this method starts to run.
     * */
    private void getDataFromSecondPage(ActionEvent event) {
        if (!emptyRegistrationFormSecondPagePopup()
                && !emailConstraintPopUp()) {
            newUser.setUsername(usernameBox.getText());
            if (passwordBox.getText() != null && passwordBox2.getText() != null
                   && newUserPasswordMatchCheck()) {
                newUser.setEmail(emailBox.getText());
                registrationComplete();
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
        usernameBox.setPrefHeight(41);
        usernameBox.setPrefWidth(180);
        passwordBox = new PasswordField();
        passwordBox.setPrefHeight(41);
        passwordBox.setPrefWidth(180);
        passwordBox.setPromptText("Set Password");
        window.getChildren().add(passwordBox);
        passwordBox.setLayoutX(lastNameBox.getLayoutX());
        passwordBox.setLayoutY(lastNameBox.getLayoutY());
        passwordBox2 = new PasswordField();
        passwordBox2.setPrefWidth(180);
        passwordBox2.setPrefHeight(40);
        passwordBox2.setPromptText("Retype your password");
        window.getChildren().add(passwordBox2);
        passwordBox2.setLayoutX(doBBox.getLayoutX());
        passwordBox2.setLayoutY(doBBox.getLayoutY());
        emailBox = new TextField();
        emailBox.setPrefWidth(180);
        emailBox.setPrefHeight(40);
        emailBox.setPromptText("Email");
        window.getChildren().add(emailBox);
        emailBox.setLayoutX(countryBox.getLayoutX());
        emailBox.setLayoutY(countryBox.getLayoutY());
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
        lblStatus2.setText("");
        lblStatus2.setVisible(true);
        newUser.setRole("user");
        String response = userService.addUser(
                restTemplate, Url.ADD_USER.getUrl(), newUser);
        if (!response.equals("Registration complete")) {
            lblStatus2.setText(response);
        }
        if (lblStatus2.getText().equals("")) {
            hideRegistrationFormSecondPage();
            registerButton.setVisible(false);
            thumbsUp.setVisible(true);
            thumbsUp.setFitHeight(75);
            thumbsUp.setFitWidth(75);
            thumbsUp.setLayoutX(430);
            thumbsUp.setLayoutY(passwordBox2.getLayoutY() - 70);
            thumbsUp.setOpacity(1);
            lblStatus2.setVisible(true);
            lblStatus2.setText("Registration complete.\n"
                    + "You can now log in.");
            lblStatus2.setTextAlignment(TextAlignment.CENTER);
            lblStatus2.setPrefHeight(100);
            lblStatus2.setLayoutY(thumbsUp.getLayoutY() + 50);
            lblStatus2.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 20));
            backButton.setVisible(false);
            registerButton.setVisible(false);
        }
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

    private boolean emailConstraintPopUp() {
        if (!validateEmail(emailBox.getText())) {
            emailConstraintError();
            return true;
        }
        return false;
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

    private void emailConstraintError() {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("The email is not in the right format.");
        alert.showAndWait();
    }

    private void giveEmptyOrNullFieldError() {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("One of your fields is empty.\nPlease try again.");
        alert.showAndWait();
    }

    public static boolean validateEmail(String emailStr) {
        Matcher matcher = VALIDEMAIL.matcher(emailStr);
        return matcher.find();
    }



}
