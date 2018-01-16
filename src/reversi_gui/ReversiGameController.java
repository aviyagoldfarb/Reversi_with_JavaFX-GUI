package reversi_gui;

import javafx.scene.text.Text;
import reversi_code.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.*;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class ReversiGameController implements Initializable {
    @FXML
    private HBox root;
    @FXML
    private Text CurrentPlayerText;
    @FXML
    public Text BlackPlayerScoreText;
    @FXML
    public Text WhitePlayerScoreText;
    @FXML
    private javafx.scene.control.TextField sizeTextField;
    @FXML
    private javafx.scene.control.TextField firstcolorTextField;
    @FXML
    private javafx.scene.control.TextField secondcolorTextField;
    private Board board;
    private Player blackPlayer;
    private Player whitePlayer;
    private AbstractGameLogic gameLogic;
    private GameFlow gameFlow;

@Override
public void initialize(URL location, ResourceBundle resources) {

    File checkFileExistence = new File("configurationFile.txt");
    boolean exists = checkFileExistence.exists();

    String sizeOfBoardStr = null;
    int sizeOfBoard;
    String player1Color = null;
    String player2Color = null;

    blackPlayer = new HumanPlayer(Sign.BLACK);
    whitePlayer = new HumanPlayer(Sign.WHITE);
    BlackPlayerScoreText.setText("2");
    WhitePlayerScoreText.setText("2");

    if(exists){
        try {
            //File file = new File("test.txt");
            FileReader fileReader = new FileReader(checkFileExistence);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuffer stringBuffer = new StringBuffer();

            sizeOfBoardStr = bufferedReader.readLine();
            player1Color = bufferedReader.readLine();
            player2Color = bufferedReader.readLine();
            /*
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuffer.append(line);
                stringBuffer.append("\n");
            }
            fileReader.close();
            System.out.println("Contents of file:");
            System.out.println(stringBuffer.toString());
            */
        } catch (IOException e) {
            e.printStackTrace();
        }

        sizeOfBoard = Integer.parseInt(sizeOfBoardStr);
        //creating an instance of Board object
        board = new Board(sizeOfBoard, sizeOfBoard);
        blackPlayer.setPlayerColor(player1Color);
        whitePlayer.setPlayerColor(player2Color);
    }
    else {
        //creating an instance of Board object
        board = new Board(4, 4);
    }

    gameLogic = new GameLogic(board);
    gameFlow = new HumanEnemyGameFlow(blackPlayer, whitePlayer, gameLogic);

    ReversiBoard reversiBoard = new ReversiBoard(board, blackPlayer, whitePlayer, gameLogic, gameFlow,
            BlackPlayerScoreText, WhitePlayerScoreText);
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

    @FXML
    protected void Apply() {
        String size = sizeTextField.getText();
        String firstColor = firstcolorTextField.getText();
        String secondColor = secondcolorTextField.getText();

        try {
            File configurationFile = new File("configurationFile.txt");

            //if (!configurationFile.createNewFile()) { // if the file is already exists
            BufferedWriter out = new BufferedWriter(new FileWriter(configurationFile ,false));
            out.write(size);
            out.write('\n');
            out.write(firstColor);
            out.write('\n');
            out.write(secondColor);
            out.close();
            //}
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }
}
