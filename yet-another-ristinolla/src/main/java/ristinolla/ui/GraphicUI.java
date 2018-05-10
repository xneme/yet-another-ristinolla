package ristinolla.ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import ristinolla.logic.FreeSizeGame;
import ristinolla.logic.GameLogic;
import ristinolla.logic.ThreeByThree;
import ristinolla.logic.UltimateGame;

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
        primaryStage.setWidth(640);
        primaryStage.setHeight(480);
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

        Button button2 = new Button("10x10");
        button2.setMinWidth(buttons.getPrefWidth());
        button2.setFont(Font.font("Monospaced", 30));
        button2.setOnAction((event) -> {
            primaryStage.setScene(this.nByN(primaryStage, 10, 4));
            primaryStage.show();
        });
        buttons.getChildren().add(button2);

        Button button3 = new Button("Ultimate");
        button3.setMinWidth(buttons.getPrefWidth());
        button3.setFont(Font.font("Monospaced", 30));
        button3.setOnAction((event) -> {
            primaryStage.setScene(this.ultimate(primaryStage));
            primaryStage.show();
        });
        buttons.getChildren().add(button3);

        layout.setTop(info);
        layout.setCenter(buttons);

        Scene scene = new Scene(layout);
        return scene;
    }

    public Scene threeByThree(Stage primaryStage) {
        primaryStage.setWidth(640);
        primaryStage.setHeight(480);
        GameLogic game = new ThreeByThree();
        BorderPane layout = new BorderPane();
        GridPane buttons = new GridPane();
        buttons.setAlignment(Pos.CENTER);
        Label info = new Label("X's turn!");
        info.setPadding(new Insets(10, 10, 10, 10));
        info.setFont(Font.font("Monospaced", 40));
        Button menubutton = new Button("Back to menu");
        menubutton.setPadding(new Insets(10, 10, 10, 10));
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
        layout.setPadding(new Insets(10, 10, 10, 10));

        Scene scene = new Scene(layout);
        return scene;
    }

    public Scene nByN(Stage primaryStage, int size, int marks) {
        primaryStage.setWidth(1024);
        primaryStage.setHeight(960);
        GameLogic game = new FreeSizeGame(size, marks);
        BorderPane layout = new BorderPane();
        GridPane buttons = new GridPane();
        buttons.setAlignment(Pos.CENTER);
        Label info = new Label("X's turn!");
        info.setFont(Font.font("Monospaced", 40));
        info.setPadding(new Insets(10, 10, 10, 10));
        Button menubutton = new Button("Back to menu");
        menubutton.setFont(Font.font("Monospaced", 20));
        menubutton.setPadding(new Insets(10, 10, 10, 10));
        menubutton.setOnAction((event) -> {
            primaryStage.setScene(this.menu(primaryStage));
            primaryStage.show();
        });

        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
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
        layout.setPadding(new Insets(10, 10, 10, 10));

        Scene scene = new Scene(layout);
        return scene;
    }

    public Scene ultimate(Stage primaryStage) {
        primaryStage.setWidth(1024);
        primaryStage.setHeight(960);
        GameLogic game = new UltimateGame();
        BorderPane layout = new BorderPane();
        GridPane buttons = new GridPane();
        buttons.setAlignment(Pos.CENTER);
        Label info = new Label("X's turn!");
        info.setFont(Font.font("Monospaced", 40));
        info.setPadding(new Insets(10, 10, 10, 10));
        Button menubutton = new Button("Back to menu");
        menubutton.setFont(Font.font("Monospaced", 20));
        menubutton.setPadding(new Insets(10, 10, 10, 10));
        menubutton.setOnAction((event) -> {
            primaryStage.setScene(this.menu(primaryStage));
            primaryStage.show();
        });

        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                final int x = i - 1;
                final int y = j - 1;
                Button button = new Button(" ");
                button.setFont(Font.font("Monospaced", 40));
                button.setOnAction((event) -> {
                    this.makeMove(game, button, info, x, y);
                    this.colorLegal(game.legalMoves(), buttons);
                });
                buttons.add(button, i, j);
            }
        }

        this.colorLegal(game.legalMoves(), buttons);

        layout.setTop(info);
        layout.setCenter(buttons);
        layout.setBottom(menubutton);
        layout.setPadding(new Insets(10, 10, 10, 10));

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
                } else if (game.getWinner() == 0) {
                    info.setText("Draw!");
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

    private void colorLegal(boolean[][] legalmoves, GridPane buttons) {
        for (Node node : buttons.getChildren()) {
            int y = GridPane.getRowIndex(node) - 1;
            int x = GridPane.getColumnIndex(node) - 1;
            node.setStyle(STYLESHEET_MODENA);
            if (legalmoves[y][x]) {
                node.setStyle("-fx-base: #b6e7c9;");
            }
        }
    }
}
