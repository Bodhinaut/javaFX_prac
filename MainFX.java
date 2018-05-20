import javafx.application.Application;

import javafx.stage.Stage;
import javafx.scene.Scene;

public class MainFX extends Application {
    
    @Override
    public void start(Stage stage) {
        stage.setTitle("JavaFX Event Demo");
        stage.setScene( new Scene( new DrawBorderPane(), 500, 550) );
        stage.show();
    }
    
    public static void main(String[] args) {
        Application.launch(args);
    }
}