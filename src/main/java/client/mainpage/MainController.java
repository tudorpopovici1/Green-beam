package client.mainpage;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.event.ActionEvent;



public class MainController {

    @FXML
    private Pane mainWindow;

    @FXML
    private Pane progressWindow;

    @FXML
    private Pane profileWindow;

    @FXML
    private Pane aboutUsWindow;

    @FXML
    private Pane settingsWindow;

    @FXML
    private Pane logoutWindow;


    public void mainPage(ActionEvent event) {
        mainWindow.toFront();
        mainWindow.setStyle("-fx-background-color: #FFFFFFFF");
    }

    public void progressPage(ActionEvent event) {
        progressWindow.setVisible(true);
        progressWindow.toFront();
        progressWindow.setStyle("-fx-background-color: #000000");
    }

    public void profileWindow(ActionEvent event) {
        profileWindow.setVisible(true);
        profileWindow.toFront();
        profileWindow.setStyle("-fx-background-color: blue");
    }

    public void aboutUsWindow(ActionEvent event) {
        aboutUsWindow.setVisible(true);
        aboutUsWindow.toFront();
        aboutUsWindow.setStyle("-fx-background-color: grey");
    }

    public void settingsWindow(ActionEvent event) {
        settingsWindow.setVisible(true);
        settingsWindow.toFront();
        settingsWindow.setStyle("-fx-background-color: orange");
    }

    public void logoutWindow(ActionEvent event) {
        logoutWindow.setVisible(true);
        logoutWindow.toFront();
        logoutWindow.setStyle("-fx-background-color: red");
    }









}
