package sample.java;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller {

    @FXML
    private Button addNotes;
    @FXML
    private Button viewNotes;

    @FXML
    void initialize() {
        addNotes.setOnAction(event->{
            addNotes.getScene().getWindow().hide();
            new MyWindowLoader().load("/sample/view/add_notes.fxml",400,400);
        });
        viewNotes.setOnAction(event ->{
            viewNotes.getScene().getWindow().hide();
            new MyWindowLoader().load("/sample/view/notes_list.fxml",400,400);
        });

    }
}
