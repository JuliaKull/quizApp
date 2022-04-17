package ee.kull.controllers;

import ee.kull.configuration.DataBaseHandler;
import ee.kull.service.Service;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class LevelsController extends Service {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button close;

    @FXML
    private Button easyTest;

    @FXML
    private Button hardTest;

    @FXML
    private ImageView java_pic;

    @FXML
    private Button mediumTest;


    @FXML
    void initialize() throws Exception {

    }

    public void easy(ActionEvent event) {
        easyTest.setOnAction(actionEvent -> {
            easyTest.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/ee/kull/quizapp/easy/question-easy1.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            DataBaseHandler dbHandler = new DataBaseHandler();
            dbHandler.levelSelection("'easy'");
        });
    }

    public void medium(ActionEvent event) {
        mediumTest.setOnAction(actionEvent -> {
            mediumTest.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/ee/kull/quizapp/medium/question-medium1.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            DataBaseHandler dbHandler = new DataBaseHandler();
            dbHandler.levelSelection("'medium'");
        });
    }

    public void hard(ActionEvent event) {
        hardTest.setOnAction(actionEvent -> {
            hardTest.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/ee/kull/quizapp/hard/question-hard1.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            DataBaseHandler dbHandler = new DataBaseHandler();
            dbHandler.levelSelection("'hard'");
        });
    }


}