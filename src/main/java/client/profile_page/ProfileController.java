package client.profile_page;

import com.jfoenix.controls.*;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import com.jfoenix.transitions.hamburger.HamburgerNextArrowBasicTransition;
import javafx.fxml.Initializable;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.FontWeight;
import javafx.scene.control.Alert.AlertType;

public class ProfileController implements Initializable {
    @FXML
    private JFXHamburger hamburger;

    @FXML
    private JFXDrawer drawer;

    @FXML
    private JFXButton addFriendsButton;

    @FXML
    private ListView<Label> friendslistView;

    @FXML
    private JFXTextField searchFriends;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        Label lbl = new Label("Item 2");
//        friendslistView.getItems().add(lbl);
        try {
            //FXMLLoader loader = new FXMLLoader(getClass().getResource("src/main/java/client/profile_page/side_panel.fxml"));
            URL url = new File(
                    "src/main/java/client/profile_page/sidepanel.fxml").toURI().toURL();
            VBox box = FXMLLoader.load(url);
            //VBox box = FXMLLoader.load(getClass().getResource("client.profile_page.sidepanel.fxml"));
            drawer.setSidePane(box);
        } catch (IOException ex) {
            Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("View is now loaded!");
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
}
