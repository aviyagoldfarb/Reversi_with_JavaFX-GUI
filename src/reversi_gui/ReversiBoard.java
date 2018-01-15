package reversi_gui;

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
    private GuiPlayersHandler guiPlayersHandler;

    public ReversiBoard(Board board, Player blackPlayer, Player whitePlayer, AbstractGameLogic gameLogic) {
        this.board = board;
        this.blackPlayer = blackPlayer;
        this.whitePlayer = whitePlayer;
        this.gameLogic = gameLogic;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ReversiBoard.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
            this.setOnMouseClicked(event -> {
                Point clickedPoint = new Point((int)event.getSceneX(), (int)event.getSceneY());
                //this.gameLogic.moveMaker(p, blackPlayer, whitePlayer);
                //(int)event.getSceneX(), (int)event.getSceneY()
                guiPlayersHandler.makeMove(clickedPoint);
                event.consume();
            });
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        guiPlayersHandler = new GuiPlayersHandler(this.blackPlayer, this.whitePlayer, this.board, this.gameLogic, this);
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
                Rectangle rectangle = new Rectangle(cellWidth, cellHeight, Color.GREEN);
                rectangle.setStroke(Color.BLACK);
                this.add(rectangle, j, i);

            }
        }
        guiPlayersHandler.draw();
    }
}