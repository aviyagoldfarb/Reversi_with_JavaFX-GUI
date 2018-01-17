package reversi_code;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * the class HumanEnemyGameFlow defines HumanEnemyGameFlow object.
 */
public class HumanEnemyGameFlow implements GameFlow {

    //pointers to HumanPlayer object
    private Player blackPlayer, whitePlayer;
    //pointer to GameLogic object
    private AbstractGameLogic gameLogic;
    //pointers to HumanPlayer object
    private Player turn, nextTurn;

    /**
     * constructor of HumanEnemyGameFlow object.
     * @param blackPlayer
     * @param whitePlayer
     * @param gameLogic
     */
    public HumanEnemyGameFlow(Player blackPlayer, Player whitePlayer, AbstractGameLogic gameLogic) {
        this.blackPlayer = blackPlayer;
        this.whitePlayer = whitePlayer;
        this.gameLogic = gameLogic;
        //initialize the turns
        this.turn = blackPlayer;
        this.nextTurn = whitePlayer;
    }

    /**
     * checks if the chosen cell is in the possibleMovesVector.
     * @param possibleMovesVector
     * @param chosenCell
     * @return boolean
     */
    public boolean chosenCellValidity(ArrayList<Point> possibleMovesVector, Point chosenCell){
        if(possibleMovesVector.size() == 0){
            return false;
        }
        Point possibleMovesArray[] = new Point [possibleMovesVector.size()];
        possibleMovesArray = possibleMovesVector.toArray(possibleMovesArray);
        for(int i = 0; i < possibleMovesVector.size(); i++){
            if(possibleMovesArray[i].isEqual(chosenCell)){
                return true;
            }
        }
        return false;
    }

    /**
     * responsible for the turn exchanges between the players.
     */
    public void setNextTurn(){
        if(this.turn == blackPlayer){
            this.turn = whitePlayer;
            this.nextTurn = blackPlayer;
        }
    else{
            this.turn = blackPlayer;
            this.nextTurn = whitePlayer;
        }
    }

    /**
     * responsible for the game's running.
     */
    public int playTheGame(Point chosenCell) {
        //create a vector that will get the return value of possibleMoves function
        ArrayList<Point> possibleMovesVector = new ArrayList<Point>();
        //check for the possible moves
        possibleMovesVector = gameLogic.possibleMoves(this.turn, this.nextTurn);
        //check if the vector is empty
        if(possibleMovesVector.size() == 0){
            //there are no optional moves, turn passes
            this.setNextTurn();
            //check for possible moves for the nextTurn player
            possibleMovesVector.clear();
            possibleMovesVector = gameLogic.possibleMoves(this.turn, this.nextTurn);
            //check if the vector is empty
            if(possibleMovesVector.size() == 0){
                //both players have no moves, end the game
                return 1;
            }
            else{
                //the current player has optional moves
                return 0;
            }
        }
        //check the validation of the player's move
        if (this.chosenCellValidity(possibleMovesVector, chosenCell)) {
            gameLogic.moveMaker(chosenCell, this.turn, this.nextTurn);
            possibleMovesVector.clear();
            this.setNextTurn();
            //end of the game criteria
            if(!(gameLogic.fullBoard()) && (gameLogic.possibleMoves(this.turn, this.nextTurn).size() != 0 ||
                    gameLogic.possibleMoves(this.nextTurn, this.turn).size() != 0)){
                //the game not ended, check for possible moves for the nextTurn player
                possibleMovesVector.clear();
                possibleMovesVector = gameLogic.possibleMoves(this.turn, this.nextTurn);
                //check if the vector is empty
                if(possibleMovesVector.size() == 0) {
                    //the nextTurn player has no possible moves, turn passes to the current turn player
                    this.setNextTurn();
                    //check for possible moves for the current turn player
                    possibleMovesVector.clear();
                    possibleMovesVector = gameLogic.possibleMoves(this.turn, this.nextTurn);
                    if(possibleMovesVector.size() == 0){
                        //both players have no moves, end the game
                        return 1;
                    }
                    else{
                        return 0;
                    }
                }
                else {
                    return 0;
                }
            }
            else {
                return 1;
            }
        }
        possibleMovesVector.clear();
        return 0;
    }

    /**
     * returns the color of player with the current turn
     * @return
     */
    public String getCurrentTurn(){
        return this.turn.getPlayerColor();
    }
}
