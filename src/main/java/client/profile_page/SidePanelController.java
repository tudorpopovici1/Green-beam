package client.profile_page;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXPopup;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        friendslistView.getItems().addAll("Iron Man", "Titanic");
        System.out.println("View is now loaded!");

        searchBarBox.setVisible(false);
//        initPopup();
    }

    /**
     * Activates the search bar.
     * @param event - once a user clicks the button linked to
     *              this method, it starts to execute.
     */
    public void searchClicked(ActionEvent event) {
        if (!(searchFriends.getText() == null) && !(searchFriends.getText().equals(""))) {
            foundFriends.getItems().add(searchFriends.getText());
            searchBarBox.setVisible(true);
        }
    }

    /**
     * Adds a friend to the friendslist
     * @param event - once a user clicks the button linked to
     *              this method, it starts to execute.
     */
    public void addFriendsClicked(ActionEvent event) {
         String friend = foundFriends.getSelectionModel().getSelectedItem();
        friendslistView.getItems().add(friend);
        searchBarBox.setVisible(false);
    }



    private void initPopup() {
        JFXButton b1 = new JFXButton("Something 01");
        JFXButton b2 = new JFXButton("Something 01");
        JFXButton b3 = new JFXButton("Something 01");

        b1.setPadding(new Insets(10));
        b2.setPadding(new Insets(10));
        b3.setPadding(new Insets(10));

        VBox vBox = new VBox(b1,b2,b3);

    }

//    @Override
//    public void textValueChanged(TextEvent e){
//        testarea.setText(searchFriends.getText());
//    }



}


