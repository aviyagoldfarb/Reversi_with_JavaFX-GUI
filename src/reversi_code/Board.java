package reversi_code;

//import static reversi_code.Sign.*;

/**
 * the class Board defines Board object.
 * the board is vector of vectors of cells.
 */
public class Board {

    //will hold the value of the rows of the board
    private int rows;
    //will hold the value of the columns of the board
    private int columns;
    //will hold to the board
    private Cell[][] board;

    /**
     * constructor of Board object.
     * @param rows = 8 by default.
     * @param columns = 8 by default.
     */
    public Board(int rows, int columns) {

        this.rows = rows;
        this.columns = columns;
        //creating two dimensional vector of type Cell
        this.board = new Cell[this.rows][this.columns];
        //initializing the board as requested
        for (int i = 0; i < this.rows; i++){
            for(int j = 0; j < this.columns; j++){
                this.board[i][j] = new Cell();
            }
        }
        this.board[(rows/2)-1][(columns/2)-1].setCell(Sign.WHITE);
        this.board[(rows/2)][(columns/2)].setCell(Sign.WHITE);
        this.board[(rows/2)-1][(columns/2)].setCell(Sign.BLACK);
        this.board[(rows/2)][(columns/2)-1].setCell(Sign.BLACK);
    }

    /**
     * get the number of rows.
     * @return numer of rows.
     */
    public int getRows() {
        return this.rows;
    }

    /**
     * get the number of columns.
     * @return numer of columns.
     */
    public int getColumns() {
        return this.columns;
    }

    /**
     * get the board.
     * @return vector<vector<Cell> >.
     */
    public Cell[][] getBoard() {
        return board;
    }

    /**
     * set a cell in the board.
     * @param i row.
     * @param j column.
     * @param newCellSign .
     */
    public void setBoard(int i, int j, Sign newCellSign) {
        this.board[i][j].setCell(newCellSign);
    }

}
