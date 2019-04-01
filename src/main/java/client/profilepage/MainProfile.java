package client.profilepage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;


public class MainProfile extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            URL url = new File(
                    "src/main/java/client/profilepage/profile.fxml").toURI().toURL();
            URL url1 = new File(
                    "src/main/java/client/mainpage/fxml/Development.fxml").toURI().toURL();

            Parent root = FXMLLoader.load(url);

            primaryStage.setTitle("Hello World");
            primaryStage.setScene(new Scene(root, 679, 700));
            primaryStage.setResizable(false);
            primaryStage.show();

            //URL bruh = new File(
            // "src/main/java/client/profilepage/SidePanel1.fxml").toURI().toURL();
            //Parent broot = FXMLLoader.load(bruh);
            //primaryStage.setTitle("Hello World");
            //primaryStage.setScene(new Scene(broot, 200, 700));
            //primaryStage.setResizable(false);
            //primaryStage.show()
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

