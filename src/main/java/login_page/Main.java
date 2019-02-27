package login_page;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
import java.net.URL;
import java.io.File;


public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            URL url = new File("src/main/java/login_page/Login.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Scene scene = new Scene(root, 950, 600);
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
