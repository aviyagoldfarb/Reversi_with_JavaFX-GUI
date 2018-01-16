package reversi_code;

import java.util.ArrayList;

/**
 * interface GameFlow.
 */
public interface GameFlow {

    /**
     * checks if the chosen cell is in the possibleMovesVector.
     * @param possibleMovesVector
     * @param chosenCell
     * @return boolean
     */
    boolean chosenCellValidity(ArrayList<Point> possibleMovesVector, Point chosenCell);
    /**
     * responsible for the turn exchanges between the players.
     */
    void setNextTurn();
    /**
     * responsible for the game's running.
     */
    int playTheGame(Point chosenCell);

    /**
     * returns the color of player with the current turn
     * @return
     */
    String getCurrentTurn();
}
