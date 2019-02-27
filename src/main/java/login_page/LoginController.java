package login_page;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;

public class LoginController {
    @FXML
    private AnchorPane window;
    @FXML
    private Label lblStatus;
    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField txtPassword;
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
    private PasswordField passwordBox;
    @FXML
    private PasswordField passwordBox2;
    @FXML
    private TextField emailBox;
    @FXML
    private Button nextButton;
    @FXML
    private Button registerButton;

    private User newUser;


    public void Login(ActionEvent event){
         if (txtUsername.getText().equals("user") && txtPassword.getText().equals("pass")){
                lblStatus.setText("Login successful!");
         }
         else {
             lblStatus.setText("Either username or password is incorrect.");
         }
    }

    public void Register(ActionEvent event){
        newUser = new User();
        newUser.setFirstName(firstNameBox.getText());
        newUser.setLastName(lastNameBox.getText());
        newUser.setDateOfBirth(doBBox.getText());
        newUser.setCountry(countryBox.getText());

        HideRegistrationFormFirstPage();
        CreateRegisterButton();
        RegistrationFormSecondPage();
        registerButton.setOnAction(this::GetDataFromSecondPage);
    }

    private void HideRegistrationFormFirstPage(){
        firstNameBox.setVisible(false);
        lastNameBox.setVisible(false);
        countryBox.setVisible(false);
        nextButton.setVisible(false);
    }

    private void CreateRegisterButton(){
        registerButton = new Button();
        registerButton.setText("Register!");
        window.getChildren().add(registerButton);
        registerButton.setLayoutX(nextButton.getLayoutX());
        registerButton.setLayoutY(nextButton.getLayoutY());
    }

    private void RegistrationFormSecondPage(){
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

    private void GetDataFromSecondPage(ActionEvent event){
        newUser.setUsername(usernameBox.getText());
        newUser.setPassword(passwordBox.getText());
        newUser.setEmail(emailBox.getText());
    }
}
