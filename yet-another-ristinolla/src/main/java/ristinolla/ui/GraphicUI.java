package ristinolla.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ristinolla.logic.GameLogic;
import ristinolla.logic.ThreeByThree;

public class GraphicUI extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("yet-another-ristinolla");
        primaryStage.setScene(this.menu(primaryStage));
        primaryStage.show();
    }

    public Scene menu(Stage primaryStage) {
        BorderPane layout = new BorderPane();
        VBox buttons = new VBox();
        Label info = new Label("Choose game mode!");
        info.setFont(Font.font("Monospaced", 40));

        Button button = new Button("3x3");
        button.setFont(Font.font("Monospaced", 40));
        button.setOnAction((event) -> {
            primaryStage.setScene(this.threeByThree());
            primaryStage.show();
        });
        buttons.getChildren().add(button);
        
        Button button2 = new Button("unimplemented");
        button2.setFont(Font.font("Monospaced", 40));
        button2.setOnAction((event) -> {
            
        });
        buttons.getChildren().add(button2);
        
        Button button3 = new Button("unimplemented");
        button3.setFont(Font.font("Monospaced", 40));
        button3.setOnAction((event) -> {
            
        });
        buttons.getChildren().add(button3);

        layout.setTop(info);
        layout.setCenter(buttons);

        Scene scene = new Scene(layout);
        return scene;
    }

    public Scene threeByThree() {
        GameLogic game = new ThreeByThree();
        BorderPane layout = new BorderPane();
        GridPane buttons = new GridPane();
        Label info = new Label("X's turn!");
        info.setFont(Font.font("Monospaced", 40));

        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                final int x = i - 1;
                final int y = j - 1;
                Button button = new Button(" ");
                button.setFont(Font.font("Monospaced", 40));
                button.setOnAction((event) -> {
                    this.makeMove(game, button, info, x, y);
                });
                buttons.add(button, i, j);
            }
        }

        layout.setTop(info);
        layout.setCenter(buttons);

        Scene scene = new Scene(layout);
        return scene;
    }

    private boolean makeMove(GameLogic game, Button button, Label info, int x, int y) {
        if (game.isActive()) {
            String turn = this.getTurnString(game.getTurn());
            boolean ret = game.makeMove(x, y);
            if (ret) {
                button.setText(turn);
                if (game.isActive()) {
                    info.setText(String.format("%s's turn!", this.getTurnString(game.getTurn())));
                } else {
                    info.setText(String.format("%s won!", this.getTurnString(game.getWinner())));
                }
            }

            return true;
        }

        return false;
    }

    private String getTurnString(int turn) {
        if (turn == 1) {
            return "X";
        } else {
            return "O";
        }
    }
}
