package login_page;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;

public class LoginController {

    @FXML
    private Label lblStatus;
    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField txtPassword;

    public void Login(ActionEvent event){
         if (txtUsername.getText().equals("user") && txtPassword.getText().equals("pass")){
                lblStatus.setText("Login successful!");
         }
         else {
             lblStatus.setText("Login failed...");
         }
    }
}
