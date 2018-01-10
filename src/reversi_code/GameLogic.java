package reversi_code;

import java.util.ArrayList;

/**
 * the class GameLogic defines GameLogic object.
 */
public class GameLogic implements AbstractGameLogic{

    //points to the game's board
    private Board board;

    /**
     * constructor of GameLogic object.
     * @param board pointer to board object.
     */
    public GameLogic(Board board) {
        this.board = board;
    }

    /**
     * check cell existence before inserting it to the possibleMovesVector.
     * @param possibleMovesVector .
     * @param cell .
     * @return boolean.
     */
    public boolean checkCellExistence(ArrayList<Point> possibleMovesVector, Point cell){
        if(possibleMovesVector.size() == 0){
            return false;
        }
        Point possibleMovesArray[] = new Point [possibleMovesVector.size()];
        possibleMovesArray = possibleMovesVector.toArray(possibleMovesArray);
        for(int i = 0; i < possibleMovesVector.size(); i++){
            if(possibleMovesArray[i].isEqual(cell)){
                return true;
            }
        }
        return false;
    }

    /**
     * returns possible moves for the current player.
     * @param player current player.
     * @param enemy current enemy.
     * @return vector<Point> of possible moves.
     */
    public ArrayList<Point> possibleMoves(Player player, Player enemy){
        //will hold the possible moves for the current player
        ArrayList<Point> possibleMovesVector = new ArrayList<Point>();
        //running indexes
        int k;
        int n;
        //running over all the board's cells
        for(int i = 0; i < this.board.getRows(); i++){
            for(int j = 0; j < this.board.getColumns(); j++){
                if(this.board.getBoard()[i][j].getCell() == player.getPlayerSign()){
                    //up
                    if(i > 1 && this.board.getBoard()[i - 1][j].getCell() == enemy.getPlayerSign()){
                        k = i - 1;
                        do{
                            k -= 1;
                        }while (this.board.getBoard()[k][j].getCell() == enemy.getPlayerSign() && k > 0);
                        if(this.board.getBoard()[k][j].getCell() == Sign.EMPTY){
                            Point optionalPoint = new Point(k+1,j+1);
                            if(!(this.checkCellExistence(possibleMovesVector, optionalPoint))){
                                possibleMovesVector.add(optionalPoint);
                            }
                        }
                    }
                    //down
                    if(i < (this.board.getRows() - 2) &&
                    this.board.getBoard()[i + 1][j].getCell() == enemy.getPlayerSign()){
                        k = i + 1;
                        do{
                            k += 1;
                        }while (this.board.getBoard()[k][j].getCell() == enemy.getPlayerSign() &&
                                k < (this.board.getRows()-1));
                        if(this.board.getBoard()[k][j].getCell() == Sign.EMPTY){
                            Point optionalPoint = new Point(k+1,j+1);
                            if(!(this.checkCellExistence(possibleMovesVector, optionalPoint))){
                                possibleMovesVector.add(optionalPoint);
                            }
                        }
                    }
                    //left
                    if(j > 1 && this.board.getBoard()[i][j - 1].getCell() == enemy.getPlayerSign()){
                        k = j - 1;
                        do{
                            k -= 1;
                        }while (this.board.getBoard()[i][k].getCell() == enemy.getPlayerSign() && k > 0);
                        if(this.board.getBoard()[i][k].getCell() == Sign.EMPTY){
                            Point optionalPoint = new Point(i+1,k+1);
                            if(!(this.checkCellExistence(possibleMovesVector, optionalPoint))){
                                possibleMovesVector.add(optionalPoint);
                            }
                        }
                    }
                    //right
                    if(j < (this.board.getColumns() - 2) &&
                    this.board.getBoard()[i][j + 1].getCell() == enemy.getPlayerSign()){
                        k = j + 1;
                        do{
                            k += 1;
                        }while (this.board.getBoard()[i][k].getCell() == enemy.getPlayerSign() &&
                                k < (this.board.getColumns()-1));
                        if(this.board.getBoard()[i][k].getCell() == Sign.EMPTY){
                            Point optionalPoint = new Point(i+1,k+1);
                            if(!(this.checkCellExistence(possibleMovesVector, optionalPoint))){
                                possibleMovesVector.add(optionalPoint);
                            }
                        }
                    }
                    //up & left
                    if(i > 1 && j > 1 && this.board.getBoard()[i - 1][j - 1].getCell() == enemy.getPlayerSign()){
                        k = i - 1;
                        n = j - 1;
                        do{
                            k -= 1;
                            n -= 1;
                        }while (this.board.getBoard()[k][n].getCell() == enemy.getPlayerSign() && k > 0 && n > 0);
                        if(this.board.getBoard()[k][n].getCell() == Sign.EMPTY){
                            Point optionalPoint = new Point(k+1,n+1);
                            if(!(this.checkCellExistence(possibleMovesVector, optionalPoint))){
                                possibleMovesVector.add(optionalPoint);
                            }
                        }
                    }
                    //up & right
                    if(i > 1 && j < (this.board.getColumns()-2) &&
                    this.board.getBoard()[i-1][j+1].getCell() == enemy.getPlayerSign()){
                        k = i - 1;
                        n = j + 1;
                        do{
                            k -= 1;
                            n += 1;
                        }while (this.board.getBoard()[k][n].getCell() == enemy.getPlayerSign() && k>0 &&
                                n<(this.board.getColumns()-1));
                        if(this.board.getBoard()[k][n].getCell() == Sign.EMPTY){
                            Point optionalPoint = new Point(k+1,n+1);
                            if(!(this.checkCellExistence(possibleMovesVector, optionalPoint))){
                                possibleMovesVector.add(optionalPoint);
                            }
                        }
                    }
                    //down & left
                    if(i < (this.board.getRows() - 2) && j > 1 &&
                            this.board.getBoard()[i+1][j-1].getCell() == enemy.getPlayerSign()){
                        k = i + 1;
                        n = j - 1;
                        do{
                            k += 1;
                            n -= 1;
                        }while (this.board.getBoard()[k][n].getCell() == enemy.getPlayerSign() &&
                                k < (this.board.getRows()-1) && n > 0);
                        if(this.board.getBoard()[k][n].getCell() == Sign.EMPTY){
                            Point optionalPoint = new Point(k+1,n+1);
                            if(!(this.checkCellExistence(possibleMovesVector, optionalPoint))){
                                possibleMovesVector.add(optionalPoint);
                            }
                        }
                    }
                    //down & right
                    if(i < (this.board.getRows() - 2) && j < (this.board.getColumns() - 2) &&
                    this.board.getBoard()[i + 1][j + 1].getCell() == enemy.getPlayerSign()){
                        k = i + 1;
                        n = j + 1;
                        do{
                            k += 1;
                            n += 1;
                        }while (this.board.getBoard()[k][n].getCell() == enemy.getPlayerSign() &&
                                k < (this.board.getRows()-1) &&
                        n < (this.board.getColumns()-1));
                        if(this.board.getBoard()[k][n].getCell() == Sign.EMPTY){
                            Point optionalPoint = new Point(k+1,n+1);
                            if(!(this.checkCellExistence(possibleMovesVector, optionalPoint))){
                                possibleMovesVector.add(optionalPoint);
                            }
                        }
                    }
                }
            }
        }
        return possibleMovesVector;
    }

    /**
     * operates the player's chosen move.
     * @param chosenCell of the current player.
     * @param player .
     * @param enemy .
     */
    public void moveMaker(Point chosenCell, Player player, Player enemy){
        //fit the coordinates back to the real board coordinates (not the printed board coordinates)
        int x = (chosenCell.getX() - 1);
        int y = (chosenCell.getY() - 1);
        //indexes
        int i, j, k, n;
        //set the player's chosen cell to the player's sign
        this.board.setBoard(x, y, player.getPlayerSign());
        //add one to the player's score
        player.setPlayerScore(1);

        //up
        if(x-1 > 0 && this.board.getBoard()[x-1][y].getCell() == enemy.getPlayerSign()){
            i = x-1;
            do{
                i-=1;
            }while(this.board.getBoard()[i][y].getCell() == enemy.getPlayerSign() && i > 0);
            if(this.board.getBoard()[i][y].getCell() == player.getPlayerSign()){
                for(k = x-1; k > i; k--){
                    //set the enemy's occupied cells to the player's sign
                    this.board.setBoard(k, y, player.getPlayerSign());
                    //add one to the player's score and subtract one from the enemy's score
                    player.setPlayerScore(1);
                    enemy.setPlayerScore(-1);
                }
            }
        }
        //down
        if(x+1 < (this.board.getRows()-1) && this.board.getBoard()[x+1][y].getCell() == enemy.getPlayerSign()){
            i = x+1;
            do{
                i+=1;
            }while(this.board.getBoard()[i][y].getCell() == enemy.getPlayerSign() && i < (this.board.getRows()-1));
            if(this.board.getBoard()[i][y].getCell() == player.getPlayerSign()){
                for(k = x+1; k < i; k++){
                    //set the enemy's occupied cells to the player's sign
                    this.board.setBoard(k, y, player.getPlayerSign());
                    //add one to the player's score and subtract one from the enemy's score
                    player.setPlayerScore(1);
                    enemy.setPlayerScore(-1);
                }
            }
        }
        //left
        if(y-1 > 0 && this.board.getBoard()[x][y-1].getCell() == enemy.getPlayerSign()){
            j = y-1;
            do{
                j-=1;
            }while(this.board.getBoard()[x][j].getCell() == enemy.getPlayerSign() && j > 0);
            if(this.board.getBoard()[x][j].getCell() == player.getPlayerSign()){
                for(k = y-1; k > j; k--){
                    //set the enemy's occupied cells to the player's sign
                    this.board.setBoard(x, k, player.getPlayerSign());
                    //add one to the player's score and subtract one from the enemy's score
                    player.setPlayerScore(1);
                    enemy.setPlayerScore(-1);
                }
            }
        }
        //right
        if(y+1 < (this.board.getColumns()-1) && this.board.getBoard()[x][y+1].getCell() == enemy.getPlayerSign()){
            j = y+1;
            do{
                j+=1;
            }while(this.board.getBoard()[x][j].getCell() == enemy.getPlayerSign() && j < (this.board.getColumns()-1));
            if(this.board.getBoard()[x][j].getCell() == player.getPlayerSign()){
                for(k = y+1; k < j; k++){
                    //set the enemy's occupied cells to the player's sign
                    this.board.setBoard(x, k, player.getPlayerSign());
                    //add one to the player's score and subtract one from the enemy's score
                    player.setPlayerScore(1);
                    enemy.setPlayerScore(-1);
                }
            }
        }
        //up & left
        if(x-1 > 0 && y-1 > 0 && this.board.getBoard()[x-1][y-1].getCell() == enemy.getPlayerSign()){
            i = x-1;
            j = y-1;
            do{
                i-=1;
                j-=1;
            }while(this.board.getBoard()[i][j].getCell() == enemy.getPlayerSign() && i > 0 && j > 0);
            if(this.board.getBoard()[i][j].getCell() == player.getPlayerSign()){
                for(k = x-1, n = y-1; k > i && n > j; k--, n--){
                    //set the enemy's occupied cells to the player's sign
                    this.board.setBoard(k, n, player.getPlayerSign());
                    //add one to the player's score and subtract one from the enemy's score
                    player.setPlayerScore(1);
                    enemy.setPlayerScore(-1);
                }
            }
        }
        //up & right
        if(x-1 > 0 && y+1 < (this.board.getColumns()-1) &&
        this.board.getBoard()[x-1][y+1].getCell() == enemy.getPlayerSign()){
            i = x-1;
            j = y+1;
            do{
                i-=1;
                j+=1;
            }while(this.board.getBoard()[i][j].getCell() == enemy.getPlayerSign() && i > 0 &&
                    j < (this.board.getColumns()-1));
            if(this.board.getBoard()[i][j].getCell() == player.getPlayerSign()){
                for(k = x-1, n = y+1; k > i && n < j; k--, n++){
                    //set the enemy's occupied cells to the player's sign
                    this.board.setBoard(k, n, player.getPlayerSign());
                    //add one to the player's score and subtract one from the enemy's score
                    player.setPlayerScore(1);
                    enemy.setPlayerScore(-1);
                }
            }
        }
        //down & left
        if(x+1 < (this.board.getRows()-1) && y-1 > 0 &&
                this.board.getBoard()[x+1][y-1].getCell() == enemy.getPlayerSign()){
            i = x+1;
            j = y-1;
            do{
                i+=1;
                j-=1;
            }while(this.board.getBoard()[i][j].getCell() == enemy.getPlayerSign() && i < (this.board.getRows()-1) &&
            j > 0);
            if(this.board.getBoard()[i][j].getCell() == player.getPlayerSign()){
                for(k = x+1, n = y-1; k < i && n > j; k++, n--){
                    //set the enemy's occupied cells to the player's sign
                    this.board.setBoard(k, n, player.getPlayerSign());
                    //add one to the player's score and subtract one from the enemy's score
                    player.setPlayerScore(1);
                    enemy.setPlayerScore(-1);
                }
            }
        }
        //down & right
        if(x+1 < (this.board.getRows()-1) && y+1 < (this.board.getColumns()-1) &&
        this.board.getBoard()[x+1][y+1].getCell() == enemy.getPlayerSign()){
            i = x+1;
            j = y+1;
            do{
                i+=1;
                j+=1;
            }while(this.board.getBoard()[i][j].getCell() == enemy.getPlayerSign() && i < (this.board.getRows()-1) &&
            j < (this.board.getColumns()-1));
            if(this.board.getBoard()[i][j].getCell() == player.getPlayerSign()){
                for(k = x+1, n = y+1; k < i && n < j; k++, n++){
                    //set the enemy's occupied cells to the player's sign
                    this.board.setBoard(k, n, player.getPlayerSign());
                    //add one to the player's score and subtract one from the enemy's score
                    player.setPlayerScore(1);
                    enemy.setPlayerScore(-1);
                }
            }
        }
    }

    /**
     * checks if the board is full.
     * @return boolean.
     */
    public boolean fullBoard(){
        int i, j;
        int emptyCounter = 0;
        for(i = 0; i < this.board.getRows(); i++) {
            for (j = 0; j < this.board.getColumns(); j++) {
                if(this.board.getBoard()[i][j].getCell() == Sign.EMPTY){
                    emptyCounter++;
                }
            }
        }
        if(emptyCounter > 0){
            return false;
        }
        return true;
    }
}
