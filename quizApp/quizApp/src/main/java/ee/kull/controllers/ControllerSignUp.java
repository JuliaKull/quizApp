package ee.kull.controllers;

import ee.kull.animation.Shake;
import ee.kull.configuration.DataBaseHandler;
import ee.kull.model.User;
import ee.kull.service.Service;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerSignUp extends Service {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button close;

    @FXML
    private ImageView java_pic;

    @FXML
    private PasswordField password;

    @FXML
    private Text question_text;

    @FXML
    private Button signup;

    @FXML
    private TextField username;

    @FXML
    void initialize() {

        signup.setOnAction(actionEvent -> {
            signUpNewUser();
        });
    }

    private void signUpNewUser() {
        DataBaseHandler dbHandler = new DataBaseHandler();
        String loginText = username.getText().trim();
        String loginPassword = password.getText().trim();
        if (!loginText.equals("") && !loginPassword.equals("")) {
            User user = new User(loginText, loginPassword);
            dbHandler.signUpUser(user);
            enterQuiz();
        } else {
            Shake userLoginAnimation = new Shake(username);
            Shake userPasAnimation = new Shake(password);
            userLoginAnimation.playAnim();
            userPasAnimation.playAnim();
            System.out.println("Please, enter your username and password");
        }
    }

    private void enterQuiz() {
        signup.setOnAction(actionEvent -> {
            signup.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/ee/kull/quizapp/levels.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
    }
}

