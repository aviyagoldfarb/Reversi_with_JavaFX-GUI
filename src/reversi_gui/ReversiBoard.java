package reversi_gui;

import javafx.scene.text.Text;
import reversi_code.*;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.IOException;

public class ReversiBoard extends GridPane {
    private Board board;
    private Player blackPlayer;
    private Player whitePlayer;
    private AbstractGameLogic gameLogic;
    private GameFlow gameFlow;
    private GuiPlayersHandler guiPlayersHandler;

    private FXMLLoader fxmlLoader;

    public ReversiBoard(Board board, Player blackPlayer, Player whitePlayer, AbstractGameLogic gameLogic,
                        GameFlow gameFlow, Text BlackPlayerScoreText, Text WhitePlayerScoreText) {
        this.board = board;
        this.blackPlayer = blackPlayer;
        this.whitePlayer = whitePlayer;
        this.gameLogic = gameLogic;
        this.gameFlow = gameFlow;

        fxmlLoader = new FXMLLoader(getClass().getResource("ReversiBoard.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        /*
        try {
            fxmlLoader.load();
            this.setOnMouseClicked(event -> {
                Point clickedPoint = new Point(this.getRowIndex(), this.getColumnIndex());
                //this.gameLogic.moveMaker(p, blackPlayer, whitePlayer);
                //(int)event.getSceneX(), (int)event.getSceneY()
                guiPlayersHandler.makeMove(clickedPoint);
                event.consume();
            });
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        */
        guiPlayersHandler = new GuiPlayersHandler(this.blackPlayer, this.whitePlayer, this.board, this.gameLogic,
                this.gameFlow, this, BlackPlayerScoreText, WhitePlayerScoreText);
    }

    public void draw() {
        this.getChildren().clear();
        int height = (int)this.getPrefHeight();
        int width = (int)this.getPrefWidth();

        int cellHeight = height / board.getRows();
        int cellWidth = width / board.getColumns();

        int radius;

        if (cellHeight >= cellWidth){
            radius = cellWidth/4;
        }
        else {
            radius = cellHeight/4;
        }
        guiPlayersHandler.setRadius(radius);
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                Rectangle rectangle = new Rectangle(cellWidth, cellHeight, Color.YELLOWGREEN);
                rectangle.setStroke(Color.BLACK);
                this.add(rectangle, j, i);
                try {
                    fxmlLoader.load();
                    rectangle.setOnMouseClicked(event -> {
                        Point clickedPoint = new Point(this.getRowIndex(rectangle) + 1, this.getColumnIndex(rectangle) + 1);
                        guiPlayersHandler.makeMove(clickedPoint);
                        event.consume();
                    });
                } catch (IOException exception) {
                    throw new RuntimeException(exception);
                }

            }
        }
        guiPlayersHandler.draw();
    }
}