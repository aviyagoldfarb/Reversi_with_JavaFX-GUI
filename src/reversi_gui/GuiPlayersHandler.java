package reversi_gui;

import javafx.geometry.HPos;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import reversi_code.*;

import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class GuiPlayersHandler {
    private Player player1;
    private Player player2;
    private Board board;
    private AbstractGameLogic gameLogic;
    private GridPane grid;
    private int radius;
    private Circle disk;

    public GuiPlayersHandler(Player player1, Player player2, Board board, AbstractGameLogic gameLogic, GridPane grid) {
        this.player1 = player1;
        this.player2 = player2;
        this.board = board;
        this.gameLogic = gameLogic;
        this.grid = grid;
    }

    public void draw() {

        //if (this.player.getPlayerSign() == Sign.BLACK){
            //this.disk = new Circle(radius, Color.BLACK);
            for (int i = 0; i < board.getRows(); i++) {
                for (int j = 0; j < board.getColumns(); j++) {
                    if (board.getBoard()[i][j].getCell() == Sign.BLACK){
                        Circle circle = new Circle(radius, Color.BLACK);
                        this.grid.setHalignment(circle, HPos.CENTER);
                        this.grid.add(circle, j, i);
                    }
                    if (board.getBoard()[i][j].getCell() == Sign.WHITE){
                        Circle circle = new Circle(radius, Color.WHITE);
                        this.grid.setHalignment(circle, HPos.CENTER);
                        this.grid.add(circle, j, i);
                    }
                }
            }
        //}
        /*
        else if (this.player.getPlayerSign() == Sign.WHITE){
            //this.disk = new Circle(radius, Color.WHITE);
            for (int i = 0; i < board.getRows(); i++) {
                for (int j = 0; j < board.getColumns(); j++) {
                    if (board.getBoard()[i][j].getCell() == Sign.WHITE){
                        Circle circle = new Circle(radius, Color.WHITE);
                        this.grid.setHalignment(circle, HPos.CENTER);
                        this.grid.add(circle, j, i);
                    }

                }
            }
        }
        */
        //grid.getChildren().remove(disk);
        //grid.setHalignment(disk, HPos.CENTER);
        //grid.add(disk, col, row);
    }

    public void makeMove(Point clickedPoint) {
        //this.gameLogic.moveMaker(clickedPoint, );
        redraw();
    }

    private void redraw() {
        for(Node node : grid.getChildren()){
            if(node instanceof Circle){
                grid.getChildren().remove(node);
            }
        }
        this.draw();
    }

    public void setRadius(int newRadius) {
        this.radius = newRadius;
    }
}
