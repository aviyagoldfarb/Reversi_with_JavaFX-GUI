package reversi_gui;

import reversi_code.*;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.*;

import java.net.URL;
import java.util.ResourceBundle;

public class ReversiGameController implements Initializable {
    @FXML
    private HBox root;
    private int[][] maze = {
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0}

    };
@Override
public void initialize(URL location, ResourceBundle resources) {



    //creating an instance of Board object
    Board board = new Board(8, 8);
    Player blackPlayer = new HumanPlayer(Sign.BLACK);
    Player whitePlayer = new HumanPlayer(Sign.WHITE);
    AbstractGameLogic gameLogic = new GameLogic(board);
    //DisplayGame displayGameOnConsole = new DisplayGameOnConsole(board);

    GameFlow gameFlow = new HumanEnemyGameFlow(blackPlayer, whitePlayer, gameLogic, displayGameOnConsole);
    gameFlow.playTheGame();

    ReversiBoard reversiBoard = new ReversiBoard(maze);
    reversiBoard.setPrefWidth(400);
    reversiBoard.setPrefHeight(400);
    root.getChildren().add(0, reversiBoard);
    reversiBoard.draw();

    root.widthProperty().addListener((observable, oldValue, newValue) -> {
        double boardNewWidth = newValue.doubleValue() - 170;
        reversiBoard.setPrefWidth(boardNewWidth);
        reversiBoard.draw();
    });
    root.heightProperty().addListener((observable, oldValue, newValue) -> {
        reversiBoard.setPrefHeight(newValue.doubleValue());
        reversiBoard.draw();
    });
    root.setOnKeyPressed(reversiBoard.getOnKeyPressed());
    }
}
