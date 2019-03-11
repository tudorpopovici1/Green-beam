package profile_page;

import java.net.URL;
import java.io.File;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;

public class Main_profile extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("profile.fxml"));
            primaryStage.setTitle("Hello World");
            primaryStage.setScene(new Scene(root, 900, 600));
            primaryStage.show();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
