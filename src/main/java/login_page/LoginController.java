package login_page;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.FontWeight;


public class LoginController {
    @FXML
    private AnchorPane window;
    @FXML
    private Label lblStatus, lblStatus2;
    @FXML
    private TextField txtUsername, firstNameBox, lastNameBox, doBBox, countryBox, usernameBox, emailBox ;
    @FXML
    private PasswordField txtPassword, passwordBox, passwordBox2;
    @FXML
    private Button nextButton, registerButton;
    @FXML
    private ImageView thumbsUp;

    private User newUser;
    private ProgressBar progress;


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
        RegistrationFormSecondPage();
        CreateRegisterButton();
        SetProgressBar();
        lblStatus2.setVisible(false);
        progress.setProgress(0.5);
        registerButton.setOnAction(this::GetDataFromSecondPage);
    }

    private void GetDataFromSecondPage(ActionEvent event){
        newUser.setUsername(usernameBox.getText());
        newUser.setPassword(passwordBox.getText());
        newUser.setEmail(emailBox.getText());
        progress.setProgress(1.0);
        HideRegistrationFormSecondPage();
        registerButton.setVisible(false);
        RegistrationComplete();
    }

    private void HideRegistrationFormFirstPage(){
        firstNameBox.setVisible(false);
        lastNameBox.setVisible(false);
        doBBox.setVisible(false);
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

    private void SetProgressBar(){
        progress = new ProgressBar();
        progress.setStyle("-fx-accent: green;");
        window.getChildren().add(progress);
        progress.setLayoutX(lblStatus2.getLayoutX() + 60);
        progress.setLayoutY(lblStatus2.getLayoutY());
        progress.setPrefWidth(230);
        progress.setPrefHeight(27);
    }

    private void HideRegistrationFormSecondPage(){
        usernameBox.setVisible(false);
        passwordBox.setVisible(false);
        passwordBox2.setVisible(false);
        emailBox.setVisible(false);
    }

    private void RegistrationComplete(){
        thumbsUp.setVisible(true);
        thumbsUp.setFitHeight(150);
        thumbsUp.setFitWidth(150);
        thumbsUp.setLayoutX(passwordBox2.getLayoutX());
        thumbsUp.setLayoutY(passwordBox2.getLayoutY() - 70);
        thumbsUp.setOpacity(0.7);
        lblStatus2.setVisible(true);
        lblStatus2.setText("Registration complete!\nLet's make a difference together!");
        lblStatus2.setTextAlignment(TextAlignment.CENTER);
        lblStatus2.setPrefHeight(100);
        lblStatus2.setLayoutY(thumbsUp.getLayoutY());
        lblStatus2.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 20));
    }
}
