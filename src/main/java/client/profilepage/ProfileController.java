package client.profilepage;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.transitions.hamburger.HamburgerNextArrowBasicTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            //FXMLLoader loader = new FXMLLoader(getClass().getResource("src/main/java/client/profilepage/SidePanel1.fxml"));
            URL url = new File(
                    "src/main/java/client/profilepage/SidePanel2.fxml").toURI().toURL();
            VBox box = FXMLLoader.load(url);
            //VBox box = FXMLLoader.load(getClass().getResource("client.profilepage.SidePanel2.fxml"));
            drawer.setSidePane(box);
        } catch (IOException ex) {
            Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
        }

//        System.out.println("View is now loaded!");
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
