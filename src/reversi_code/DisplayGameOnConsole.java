package reversi_code;

public class DisplayGameOnConsole implements DisplayGame {

    //pointer to the game's board
    private Board board;

    /**
     * constructor of DisplayGameOnConsole object.
     * @param board
     */
    public DisplayGameOnConsole(Board board) {
        this.board = board;
    }

    /**
     * printGameBoard function will print the board to the screen as requested.
     */
    public void printGameBoard() {
        //iterating over the board in order to print it as requested
        for(int i = 0; i <= this.board.getRows(); i++){
            for(int j = 0; j <= this.board.getColumns(); j++){
                if(i == 0 && j == 0){
                    System.out.print(" " + "|");
                }
                if(i == 0 && j != 0){
                    System.out.print(" " + j + " " + "|");
                }
                if(i != 0 && j == 0){
                    System.out.print(i + "|");
                }
                if(i != 0 && j != 0){
                    System.out.print(" " + this.board.getBoard()[i-1][j-1].cellToPrint() + " " + "|");
                }

            }
            System.out.println();
            for(int k = 0; k < ((4*this.board.getColumns())+2); k++){
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }
}
