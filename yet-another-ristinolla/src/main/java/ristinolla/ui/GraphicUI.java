package ristinolla.ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import ristinolla.logic.GameLogic;
import ristinolla.logic.ThreeByThree;

public class GraphicUI extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("yet-another-ristinolla");
        primaryStage.setScene(this.menu(primaryStage));
        primaryStage.setWidth(640);
        primaryStage.setHeight(480);
        primaryStage.show();
    }

    public Scene menu(Stage primaryStage) {
        BorderPane layout = new BorderPane();
        layout.setPadding(new Insets(10, 10, 10, 10));
        VBox buttons = new VBox();
        buttons.setPrefWidth(480);
        buttons.setSpacing(5);
        buttons.setPadding(new Insets(10, 10, 10, 10));
        buttons.setAlignment(Pos.CENTER);
        Label info = new Label("Choose game mode!");
        info.setAlignment(Pos.CENTER);
        info.setTextAlignment(TextAlignment.CENTER);
        info.setPadding(new Insets(10, 10, 10, 10));
        info.setFont(Font.font("Monospaced", 30));

        Button button = new Button("3x3");
        button.setMinWidth(buttons.getPrefWidth());
        button.setFont(Font.font("Monospaced", 30));
        button.setOnAction((event) -> {
            primaryStage.setScene(this.threeByThree(primaryStage));
            primaryStage.show();
        });
        buttons.getChildren().add(button);

        Button button2 = new Button("<future expansion>");
        button2.setMinWidth(buttons.getPrefWidth());
        button2.setFont(Font.font("Monospaced", 30));
        button2.setOnAction((event) -> {

        });
        buttons.getChildren().add(button2);

        Button button3 = new Button("<future expansion>");
        button3.setMinWidth(buttons.getPrefWidth());
        button3.setFont(Font.font("Monospaced", 30));
        button3.setOnAction((event) -> {

        });
        buttons.getChildren().add(button3);

        layout.setTop(info);
        layout.setCenter(buttons);

        Scene scene = new Scene(layout);
        return scene;
    }

    public Scene threeByThree(Stage primaryStage) {
        GameLogic game = new ThreeByThree();
        BorderPane layout = new BorderPane();
        GridPane buttons = new GridPane();
        buttons.setAlignment(Pos.CENTER);
        Label info = new Label("X's turn!");
        info.setFont(Font.font("Monospaced", 40));
        Button menubutton = new Button("Back to menu");
        menubutton.setFont(Font.font("Monospaced", 20));
        menubutton.setOnAction((event) -> {
            primaryStage.setScene(this.menu(primaryStage));
            primaryStage.show();
        });

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
        layout.setBottom(menubutton);

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