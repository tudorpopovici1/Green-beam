package login_page;

import javafx.fxml.FXML;
import javafx.scene.Parent;
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
    private TextField countryBox;
    @FXML
    private Button nextButton;

    private String firstName;
    private String lastName;
    private String country;
    private String username;
    private String password;
    private String email;


    public void Login(ActionEvent event){
        if (txtUsername.getText().equals("user") && txtPassword.getText().equals("pass")){
            lblStatus.setText("Login successful!");
        }
        else {
            lblStatus.setText("Either username or password is incorrect.");
        }
    }

    public void Register(ActionEvent event){
        firstName = firstNameBox.getText();
        lastName = lastNameBox.getText();
        country = countryBox.getText();


        firstNameBox.setVisible(false);
        lastNameBox.setVisible(false);
        countryBox.setVisible(false);

        RegistrationFormSecondPage();

        nextButton.setText("Register!");
    }


    public void RegistrationFormSecondPage(){
        TextField usernameBox = new TextField();
        usernameBox.setPromptText("New Username");
        window.getChildren().add(usernameBox);
        usernameBox.setLayoutX(firstNameBox.getLayoutX());
        usernameBox.setLayoutY(lastNameBox.getLayoutX());

        TextField passwordBox = new TextField();
        passwordBox.setPromptText("Set Password");
        window.getChildren().add(passwordBox);
        passwordBox.setLayoutX(lastNameBox.getLayoutX());
        passwordBox.setLayoutY(lastNameBox.getLayoutY());

        TextField emailBox = new TextField();
        emailBox.setPromptText("Email");
        window.getChildren().add(emailBox);
        emailBox.setLayoutX(countryBox.getLayoutX());
        emailBox.setLayoutY(countryBox.getLayoutY());

        username = usernameBox.getText();
        password = passwordBox.getText();
        email = emailBox.getText();
    }

}
