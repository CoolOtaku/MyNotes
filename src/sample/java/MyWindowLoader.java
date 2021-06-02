package sample.java;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MyWindowLoader {

    public void load(String path, int x, int y){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(path));
            loader.load();

            Parent root = loader.getRoot();
            root.getStylesheets().add("sample/style/style.css");
            Stage stage = new Stage();
            stage.setScene(new Scene(root,x,y));
            stage.setTitle("OtakuNotes");
            Image ico = new Image("/sample/style/note.png");
            stage.getIcons().add(ico);
            stage.show();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
