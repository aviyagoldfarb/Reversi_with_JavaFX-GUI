package reversi_code;

import java.util.ArrayList;

/**
 * interface AbstractGameLogic.
 */
public interface AbstractGameLogic {

    /**
     * check cell existence before inserting it to the possibleMovesVector.
     * @param possibleMovesVector .
     * @param cell .
     * @return boolean.
     */
    boolean checkCellExistence(ArrayList<Point> possibleMovesVector, Point cell);
    /**
     * returns possible moves for the current player.
     * @param player current player.
     * @param enemy current enemy.
     * @return vector<Point> of possible moves.
     */
    ArrayList<Point> possibleMoves(Player player, Player enemy);
    /**
     * operates the player's chosen move.
     * @param chosenCell of the current player.
     * @param player .
     * @param enemy .
     */
    void moveMaker(Point chosenCell, Player player, Player enemy);
    /**
     * checks if the board is full.
     * @return boolean.
     */
    boolean fullBoard();

}
