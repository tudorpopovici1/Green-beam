package client.profile_page;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.FontWeight;
import javafx.scene.control.Alert.AlertType;


public class SidePanelController implements Initializable {

    @FXML
    private JFXButton addFriendsButton;

    @FXML
    private JFXListView<String> friendslistView;

    @FXML
    private JFXTextField searchFriends;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Label lbl = new Label("Item 2");
        friendslistView.getItems().addAll("Iron Man", "Titanic", "Contact", "Surrogates", "Iron Man", "Titanic", "Contact", "Surrogates", "Iron Man", "Titanic", "Contact");
        System.out.println("View is now loaded!");
    }

}


