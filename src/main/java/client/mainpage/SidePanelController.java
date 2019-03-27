package client.mainpage;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXPopup;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.awt.event.MouseEvent;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.net.URL;
import java.util.ResourceBundle;


public class SidePanelController implements Initializable {

    @FXML
    private JFXButton addFriendsButton;

    @FXML
    private JFXListView<String> friendslistView;

    @FXML
    private JFXTextField searchFriends;

    @FXML
    private JFXListView<String> foundFriends;

    @FXML
    private JFXButton searchButton;

    @FXML
    private Pane searchBarBox;

    @FXML
    private ImageView imageSidePanel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        friendslistView.getItems().addAll("Iron Man", "Titanic");

        searchBarBox.setVisible(false);
    }

    /**
     * Activates the search bar.
     * @param event - once a user clicks the button linked to
     *              this method, it starts to execute.
     */
    public void searchClicked(ActionEvent event) {
        searchBarBox.setVisible(false);
        foundFriends.getItems().clear();
        if (!(searchFriends.getText() == null) && !(searchFriends.getText().equals(""))) {
            foundFriends.getItems().add(searchFriends.getText());
            searchBarBox.setVisible(true);
        }

    }

    /**
     * Closes the search bar.
     * @param event - once a user clicks the button linked to
     *              this method, it starts to execute.
     */
    public void backSidePanelClicked(ActionEvent event) {
        searchBarBox.setVisible(false);
        foundFriends.getItems().clear();

    }




    /**
     * Adds a friend to the friendslist
     * @param event - once a user clicks the button linked to
     *              this method, it starts to execute.
     */
    public void addFriendsClicked(ActionEvent event) {
        String friend = foundFriends.getSelectionModel().getSelectedItem();
        if (!(foundFriends.getSelectionModel().getSelectedItem() == null)){
            friendslistView.getItems().add(friend);
        }

        searchBarBox.setVisible(false);
    }



}
