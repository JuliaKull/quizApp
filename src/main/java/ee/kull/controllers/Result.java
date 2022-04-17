package ee.kull.controllers;

import ee.kull.configuration.DataBaseHandler;
import ee.kull.service.Service;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Result extends Service {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button close;

    @FXML
    private ImageView java_pic;

    @FXML
    private TextField score;

    @FXML
    void initialize() throws SQLException {
        score.setText(String.valueOf(result()));
    }

    private Integer result() { //проверка зарегистрирован ли пользователь уже
        DataBaseHandler dbHandler = new DataBaseHandler();
        ResultSet result = dbHandler.getScore();
        int userScore = 0;
        while (true) {
            try {
                if (!result.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                userScore = result.getInt("result");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return userScore;
    }
}
