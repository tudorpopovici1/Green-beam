package client.mainpage;

import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.util.Duration;


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
        animate(mainWindow);
        mainWindow.toFront();
        mainWindow.setStyle("-fx-background-color: #FFFFFFFF");
    }

    public void progressPage(ActionEvent event) {
        progressWindow.setVisible(true);
        animate(progressWindow);
        progressWindow.toFront();
        progressWindow.setStyle("-fx-background-color: #000000");
    }


    public void profileWindow(ActionEvent event) {
        profileWindow.setVisible(true);
        animate(profileWindow);
        profileWindow.toFront();
        profileWindow.setStyle("-fx-background-color: blue");
    }

    public void aboutUsWindow(ActionEvent event) {
        aboutUsWindow.setVisible(true);
        animate(aboutUsWindow);
        aboutUsWindow.toFront();
        aboutUsWindow.setStyle("-fx-background-color: gray");
    }

    public void settingsWindow(ActionEvent event) {
        settingsWindow.setVisible(true);
        animate(settingsWindow);
        settingsWindow.toFront();
        settingsWindow.setStyle("-fx-background-color: orange");
    }

    public void logoutWindow(ActionEvent event) {
        logoutWindow.setVisible(true);
        animate(logoutWindow);
        logoutWindow.toFront();
        logoutWindow.setStyle("-fx-background-color: red");
    }

    public void animate(Pane pane) {
        CustomAnimation rht = new CustomAnimation
                (Duration.millis(500), pane, pane.getMinHeight());
        FadeTransition ft = new FadeTransition(Duration.millis(500), pane);
        ft.setFromValue(0);
        ft.setToValue(1);
        SequentialTransition pt = new SequentialTransition(rht, ft);
        pt.play();
    }
}
