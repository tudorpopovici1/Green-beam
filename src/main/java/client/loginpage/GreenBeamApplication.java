package client.loginpage;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * This class launches the application.
 */

public class GreenBeamApplication extends Application {

    /**
     * The main() method allows you to run JAR files that were
     * created without the JavaFX Launcher, such as when using
     * an IDE in which the JavaFX tools are not fully integrated.
     * @param args main param of this function
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            URL url = new File(
                    "src/main/java/client/loginpage/fxml/Login.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Scene scene = new Scene(root, 900, 700);
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.setTitle(
                    "GreenBeam - Carbon Footprint Monitoring Application");
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Closes the application completely.
     */
    public void closeApplication() {
        Platform.exit();
    }
}
