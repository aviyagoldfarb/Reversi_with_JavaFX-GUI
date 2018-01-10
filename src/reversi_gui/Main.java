package reversi_gui;

import reversi_code.*;

import javafx.application.Application;
//import javafx.fxml.FXMLLoader;

import javafx.scene.control.Label;

import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.text.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        primaryStage.setTitle("Hello World, Whats Up?");

        Label lbl = new Label("At Last!");
        lbl.setFont(new Font("Arial", 30));
        StackPane root = new StackPane();
        root.getChildren().add(lbl);

        primaryStage.setScene(new Scene(root, 600, 600));

        primaryStage.show();

    }

    public static void main(String[] args) {

        //creating an instance of Board object
        Board board = new Board(8, 8);
        Player blackPlayer = new HumanPlayer(Sign.BLACK);
        Player whitePlayer = new HumanPlayer(Sign.WHITE);
        AbstractGameLogic gameLogic = new GameLogic(board);
        DisplayGame displayGameOnConsole = new DisplayGameOnConsole(board);

        GameFlow gameFlow = new HumanEnemyGameFlow(blackPlayer, whitePlayer, gameLogic, displayGameOnConsole);
        gameFlow.playTheGame();

        //return 0;

        launch(args);
    }
}
