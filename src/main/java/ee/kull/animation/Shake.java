package ee.kull.animation;

import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class Shake {
    private TranslateTransition tt;

    public Shake(Node node) {
        tt = new TranslateTransition(Duration.millis(70),node); //how long will shake
        tt.setFromX(0f); // отступ
        tt.setByX(10f); // передвижение
        tt.setCycleCount(3);
        tt.setAutoReverse(true);// возвращается обратно после тряски
    }

    public void playAnim(){
        tt.playFromStart();
    }
}
