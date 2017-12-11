package sample;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

//    @Override
//    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
//        primaryStage.setTitle("T h e   M a t r i x   h a s   U . . .");
//        primaryStage.setScene(new Scene(root, 640, 300));
//        primaryStage.show();
//
//    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        primaryStage.setTitle("Autorization");
       primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 200, 80));
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
