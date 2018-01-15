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
    private Board board;
    private Player blackPlayer;
    private Player whitePlayer;
    private AbstractGameLogic gameLogic;
@Override
public void initialize(URL location, ResourceBundle resources) {



    //creating an instance of Board object
    board = new Board(8, 8);
    blackPlayer = new HumanPlayer(Sign.BLACK);
    whitePlayer = new HumanPlayer(Sign.WHITE);
    gameLogic = new GameLogic(board);

    //GameFlow gameFlow = new HumanEnemyGameFlow(blackPlayer, whitePlayer, gameLogic);
    //gameFlow.playTheGame();

    ReversiBoard reversiBoard = new ReversiBoard(board, blackPlayer, whitePlayer, gameLogic);
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
