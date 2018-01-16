package reversi_gui;

import javafx.scene.text.Text;
import reversi_code.*;
import javafx.geometry.HPos;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Alert;

public class GuiPlayersHandler {
    private Player player1;
    private Player player2;
    private Board board;
    private AbstractGameLogic gameLogic;
    private GameFlow gameFlow;
    private GridPane grid;
    private int radius;
    private Circle disk;
    private Text BlackPlayerScoreText;
    private Text WhitePlayerScoreText;
    private Text CurrentPlayerText;

    public GuiPlayersHandler(Player player1, Player player2, Board board, AbstractGameLogic gameLogic,
                             GameFlow gameFlow, GridPane grid, Text BlackPlayerScoreText, Text WhitePlayerScoreText,
                             Text CurrentPlayerText) {
        this.player1 = player1;
        this.player2 = player2;
        this.board = board;
        this.gameLogic = gameLogic;
        this.gameFlow = gameFlow;
        this.grid = grid;
        this.BlackPlayerScoreText = BlackPlayerScoreText;
        this.WhitePlayerScoreText = WhitePlayerScoreText;
        this.CurrentPlayerText = CurrentPlayerText;
    }

    public void draw() {
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                if (board.getBoard()[i][j].getCell() == Sign.BLACK){
                    Circle circle = new Circle(radius, Color.valueOf(player1.getPlayerColor()));
                    this.grid.setHalignment(circle, HPos.CENTER);
                    this.grid.add(circle, j, i);
                }
                if (board.getBoard()[i][j].getCell() == Sign.WHITE){
                    Circle circle = new Circle(radius, Color.valueOf(player2.getPlayerColor()));
                    this.grid.setHalignment(circle, HPos.CENTER);
                    this.grid.add(circle, j, i);
                }
            }
        }
    }

    public void makeMove(Point clickedPoint) {
        int endOfGame = 0;
        endOfGame = gameFlow.playTheGame(clickedPoint);
        this.CurrentPlayerText.setText(this.gameFlow.getCurrentTurn());
        this.BlackPlayerScoreText.setText(Integer.toString(player1.getPlayerScore()));
        this.WhitePlayerScoreText.setText(Integer.toString(player2.getPlayerScore()));
        redraw();
        if(endOfGame == 1){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Game Over");
            alert.setHeaderText("The winner is:");
            if(player1.getPlayerScore() > player2.getPlayerScore()){
                String playerColor = player1.getPlayerColor();
                String playerScore = Integer.toString(player1.getPlayerScore());
                String finalStr = "The " + playerColor + " player with " + playerScore + " cells.";
                alert.setContentText(finalStr);
            }
            if(player1.getPlayerScore() < player2.getPlayerScore()){
                String playerColor = player2.getPlayerColor();
                String playerScore = Integer.toString(player2.getPlayerScore());
                String finalStr = "The " + playerColor + " player with " + playerScore + " cells.";
                alert.setContentText(finalStr);
            }
            if(player1.getPlayerScore() == player2.getPlayerScore()){
                String playerScore = Integer.toString(player1.getPlayerScore());
                alert.setContentText("No winner, both players are even with " + playerScore + " cells each.");
            }
            alert.showAndWait();
        }
    }

    private void redraw() {
        int size = grid.getChildren().size();
        for(int i = 0; i < size; i++){
            for(Node node : grid.getChildren()){
                if(node instanceof Circle){
                    grid.getChildren().remove(node);
                    break;
                }
            }
        }

        this.draw();
    }

    public void setRadius(int newRadius) {
        this.radius = newRadius;
    }
}
