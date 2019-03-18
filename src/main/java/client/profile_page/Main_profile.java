package client.profile_page;

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
//            URL url = new File(
//                    "src/main/java/client/profile_page/profile.fxml").toURI().toURL();
//            Parent root = FXMLLoader.load(url);
//            primaryStage.setTitle("Hello World");
//            primaryStage.setScene(new Scene(root, 709, 700));
//            primaryStage.setResizable(false);
//            primaryStage.show();

            URL bruh = new File(
                    "src/main/java/client/profile_page/side_panel.fxml").toURI().toURL();
            Parent broot = FXMLLoader.load(bruh);
            primaryStage.setTitle("Hello World");
            primaryStage.setScene(new Scene(broot, 200, 700));
            primaryStage.setResizable(false);
            primaryStage.show();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}

