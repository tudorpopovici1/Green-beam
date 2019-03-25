package client.profilepage;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.net.URL;
import java.util.ResourceBundle;


public class SidePanelController implements Initializable,TextListener {

    @FXML
    private JFXButton addFriendsButton;

    @FXML
    private JFXListView<String> friendslistView;

    @FXML
    private JFXTextField searchFriends;

    @FXML
    private TextField testforum;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Label lbl = new Label("Item 2");
        friendslistView.getItems().addAll(
                "Iron Man", "Titanic", "Contact", "Surrogates",
                "Iron Man", "Titanic", "Contact", "Surrogates",
                "Iron Man", "Titanic", "Contact");
        System.out.println("View is now loaded!");
        initPopup();
    }

    private void initPopup() {
        JFXButton b1 = new JFXButton("Something 01");
        JFXButton b2 = new JFXButton("Something 01");
        JFXButton b3 = new JFXButton("Something 01");

        b1.setPadding(new Insets(10));
        b2.setPadding(new Insets(10));
        b3.setPadding(new Insets(10));

        //VBox vBox = new VBox(b1,b2,b3);

    }

    @Override
    public void textValueChanged(TextEvent textEvent) {
        testforum.setText(searchFriends.getText());
    }



}


