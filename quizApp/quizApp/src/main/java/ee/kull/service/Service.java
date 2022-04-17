package ee.kull.service;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public abstract class Service {

    protected Stage stage;
    protected Scene scene;
    protected Parent root;



    public void exit() {  //выход из программы
        System.exit(0);
    }

    public void answer(ActionEvent event) {
        try {
            DataBaseHandler dbHandler = new DataBaseHandler();
            dbHandler.addPoints();
            changeScene(event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
