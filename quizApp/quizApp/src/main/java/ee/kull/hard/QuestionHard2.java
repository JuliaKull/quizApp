package ee.kull.hard;

import ee.kull.configuration.DataBaseHandler;
import ee.kull.service.Service;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class QuestionHard2 extends Service {

    String link = "/ee/kull/quizapp/hard/question-hard3.fxml";

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button answerA;

    @FXML
    private Button answerB;

    @FXML
    private Button answerC;

    @FXML
    private Button answerD;

    @FXML
    private Button close;

    @FXML
    private ImageView java_pic;

    @FXML
    private Text question_text;

    @FXML
    void initialize() {


    }

    public void changeScene(ActionEvent event) {

        try {
            root = FXMLLoader.load(getClass().getResource(link));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
