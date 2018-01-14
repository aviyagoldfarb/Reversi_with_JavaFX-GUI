package reversi_gui;

import reversi_code.*;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.IOException;

public class ReversiBoard extends GridPane {
    private int[][] board;
    private static final int FREE = 0;
    private static final int WALL = 1;

    private GuiPlayer player;

    public ReversiBoard(int[][] board) {
        this.board = board;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ReversiBoard.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
            this.setOnKeyPressed(event -> {
                switch (event.getCode()) {
                    case DOWN:
                        player.moveDown();
                        break;
                    case UP:
                        player.moveUp();
                        break;
                    case LEFT:
                        player.moveLeft();
                        break;
                    case RIGHT:
                        player.moveRight();
                        break;
                }
                event.consume();
            });
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        player = new GuiPlayer(this, 0, 0);
    }

    public void draw() {
        this.getChildren().clear();
        int height = (int)this.getPrefHeight();
        int width = (int)this.getPrefWidth();

        int cellHeight = height / board.length;
        int cellWidth = width / board[0].length;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == FREE)
                    this.add(new Rectangle(cellWidth, cellHeight,
                            Color.WHITE), j, i);
                else
                    this.add(new Rectangle(cellWidth, cellHeight,
                            Color.BLACK), j, i);
            }
        }
        player.draw(cellWidth, cellHeight);
    }

}