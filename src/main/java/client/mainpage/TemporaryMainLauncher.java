
package client.mainpage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class TemporaryMainLauncher extends Application {

public static void main(String[] args) {
launch(args);
}

@Override
public void start(Stage primaryStage) {
try {
URL url = new File(
"src/main/java/client/mainpage/fxml/Main.fxml").toURI().toURL();
Parent root = FXMLLoader.load(url);
Scene scene = new Scene(root, 900, 700);
primaryStage.setScene(scene);
primaryStage.setResizable(false);
primaryStage.show();
} catch (IOException e) {
e.printStackTrace();
}
}



}

