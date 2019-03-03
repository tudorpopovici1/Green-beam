package loginPage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
import java.net.URL;
import java.io.File;

/**
 * This class launches the application.
 */
public class MainApp extends Application {

    /**
     * The main() method allows you to run JAR files that were
     * created without the JavaFX Launcher, such as when using
     * an IDE in which the JavaFX tools are not fully integrated.
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            URL url = new File(
                    "src/main/java/loginPage/Login.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Scene scene = new Scene(root, 900, 600);
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.setTitle(
                    "GreenBeam - Carbon Footprint Monitoring Application");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
