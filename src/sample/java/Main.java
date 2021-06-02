package sample.java;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javax.swing.*;
import java.io.File;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/sample/view/sample.fxml"));
        primaryStage.setTitle("OtakuNotes");
        Image ico = new Image("/sample/style/note.png");
        primaryStage.getIcons().add(ico);
        primaryStage.setScene(new Scene(root, 400, 400));
        //root.getStylesheets().add("sample/style/style.css");
        primaryStage.show();

        isDirectory();
    }
    private void isDirectory(){
        String MyDocs = new JFileChooser().getFileSystemView().getDefaultDirectory().toString();
        File dir = new File(MyDocs+"\\OtakuNotes");
        if(!dir.exists()){
           dir.mkdir();
        }
    }

}
