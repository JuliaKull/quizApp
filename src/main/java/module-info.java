module ee.kull.quizapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens ee.kull.quizapp to javafx.fxml;
    exports ee.kull.quizapp;
    exports ee.kull.controllers;
    opens ee.kull.controllers to javafx.fxml;
    opens ee.kull.quizapp.easy to javafx.fxml;
    opens ee.kull.quizapp.medium to javafx.fxml;
    opens ee.kull.quizapp.hard to javafx.fxml;
    opens ee.kull.easy to javafx.fxml;

    opens ee.kull.medium to javafx.fxml;
    opens ee.kull.hard to javafx.fxml;

    opens ee.kull.service to javafx.fxml;
}