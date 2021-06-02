package sample.java;

import java.io.File;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javax.swing.*;

public class NotesListControler {

    public static String potok = "OtakuNotes";

    ArrayList<OBJNote> arrayList = new ArrayList();
    String MyDocs = new JFileChooser().getFileSystemView().getDefaultDirectory().toString()+"\\OtakuNotes";

    @FXML
    private ListView<String> list;
    @FXML
    private Button edit_notes;
    @FXML
    private Button delete_notes;
    @FXML
    private Button back;

    @FXML
    void initialize() {
        loadList();
        delete_notes.setOnAction(event ->{
            deleteHote(MyDocs);
            list.getItems().clear();
            arrayList.clear();
            loadList();
        });
        back.setOnAction(event ->{
            back.getScene().getWindow().hide();
            new MyWindowLoader().load("/sample/view/sample.fxml",400,400);
        });
        edit_notes.setOnAction(event -> {
            edit_notes.getScene().getWindow().hide();
            editHote();
        });
    }
    private void loadList(){
        File files = new File(MyDocs);
        String[] paths = files.list();
        for (int i = 0; i < paths.length; i++){
            files = new File(paths[i]);
            arrayList.add(new OBJNote(files.getName(),paths[i]));
        }
        for (int i = 0; i < arrayList.size(); i++){
            list.getItems().add(arrayList.get(i).name);
        }
        list.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    private void deleteHote(String dir){
        ObservableList<String> mlist;
        mlist = list.getSelectionModel().getSelectedItems();
        boolean res = false;
        for (String s : mlist){
            File file = new File(dir+"\\"+s);
            res = file.delete();
        }
        if(res) {
            Alert d = new Alert(Alert.AlertType.INFORMATION);
            d.setTitle("Успішно видалено");
            d.setContentText("Успішно видалена нотатка!");
            d.show();
        }
    }
    private void editHote(){
        ObservableList<String> mlist;
        mlist = list.getSelectionModel().getSelectedItems();
        if (mlist.size() > 1){
            Alert d = new Alert(Alert.AlertType.ERROR);
            d.setTitle("Помилка");
            d.setContentText("Ви не можете редагувати зразу декілька нотатків!");
            d.show();
        }else{
            String s = mlist.get(0);
            potok = s;
            new MyWindowLoader().load("/sample/view/add_notes.fxml",400,400);
        }

    }
}

