package ristinolla.domain;

import javafx.application.Application;
import ristinolla.logic.GameLogic;
import ristinolla.logic.ThreeByThree;
import ristinolla.ui.GraphicUI;
import ristinolla.ui.TextUi;

public class Main {

    public static void main(String[] args) {
//        GameLogic logic = new ThreeByThree();
//        TextUi ui = new TextUi(logic);
//        ui.start();
        Application.launch(GraphicUI.class, args);
    }
}
