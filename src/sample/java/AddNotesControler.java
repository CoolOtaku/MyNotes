package sample.java;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.*;

public class AddNotesControler {

    boolean isDelete = false;
    String MyDocs = new JFileChooser().getFileSystemView().getDefaultDirectory().toString()+"\\OtakuNotes";
    @FXML
    private TextField inputName;
    @FXML
    private TextArea inputText;
    @FXML
    private Button saved;
    @FXML
    private Button back;

    @FXML
    void initialize() {
        String name = NotesListControler.potok;

        if (!name.equals("OtakuNotes")){
            NotesListControler.potok = "OtakuNotes";
            try {
                File f = new File(MyDocs + "\\" + name);
                StringBuilder text = new StringBuilder(name);
                int size = text.length();
                text.delete(size-4,size);
                inputName.setText(text.toString());

                FileReader fr = new FileReader(f);
                text = new StringBuilder();
                int c;
                while ((c = fr.read()) != -1){
                    text.append((char) c);
                }
                fr.close();
                inputText.setText(text.toString());
                isDelete = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }

        saved.setOnAction(event ->{
            try {
                if(isDelete){
                   File f2 = new File(MyDocs + "\\" + name);
                   f2.delete();
                }
            File file = new File(MyDocs+"\\"+inputName.getText()+".txt");
            if(!file.exists()) {
                file.createNewFile();
                FileWriter wf = new FileWriter(file);
                wf.write(inputText.getText());
                wf.flush();
                wf.close();

                Alert d = new Alert(Alert.AlertType.INFORMATION);
                d.setTitle("Успішно ствонеро");
                d.setContentText("Успішно ствонена нова нотатка!");
                d.show();
            }else{
                Alert d = new Alert(Alert.AlertType.ERROR);
                d.setTitle("Помилка");
                d.setContentText("Така нотатка уже існує!");
                d.show();
            }
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });
        back.setOnAction(event ->{
            back.getScene().getWindow().hide();
            new MyWindowLoader().load("/sample/view/sample.fxml",400,400);
        });
    }
}

