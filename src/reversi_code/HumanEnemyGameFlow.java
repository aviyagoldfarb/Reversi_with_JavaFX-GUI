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
            this.setNextTurn();
            return 0;
        }
        if (this.chosenCellValidity(possibleMovesVector, chosenCell)) {
            gameLogic.moveMaker(chosenCell, this.turn, this.nextTurn);
            possibleMovesVector.clear();
            this.setNextTurn();
            if(!(gameLogic.fullBoard()) && (gameLogic.possibleMoves(this.turn, this.nextTurn).size() != 0 ||
                    gameLogic.possibleMoves(this.nextTurn, this.turn).size() != 0)){
                return 0;
            } else {
                return 1;
            }
        }
        possibleMovesVector.clear();
        return 0;
        //create a vector that will get the return value of possibleMoves function
//        ArrayList<Point> possibleMovesVector = new ArrayList<Point>();
        //int x, y;
        //running until the end of the game criteria
        //do{
            //System.out.println("Current board:");
            //System.out.println();

            //printing the board using printGameBoard function from DisplayGameOnConsole class
            //this.displayGame.printGameBoard();

            //System.out.println(String.valueOf(this.turn.getPlayerSign()) + ": It's your move.");

            //check for the possible moves
//            possibleMovesVector = gameLogic.possibleMoves(this.turn, this.nextTurn);
            //check if the vector is empty
//            if(possibleMovesVector.size() == 0){
                //System.out.println("No possible moves. Play passes back to other player.");
                //System.out.println();
//                this.setNextTurn();
//                return;
                //continue;
//            }
            //System.out.println("Your possible moves: ");
            //display the optional cells
            //Point possibleMovesArray[] = new Point [possibleMovesVector.size()];
            //possibleMovesArray = possibleMovesVector.toArray(possibleMovesArray);
            //for(int i = 0; i < possibleMovesVector.size(); i++){
            //    possibleMovesArray[i].pointToPrint();
            //    if(i < possibleMovesVector.size() - 1){
            //        System.out.print(",");
            //    }
            //}
            //System.out.println();
            //System.out.println();
            //loop until the player enters appropriate cell
            //do {
                //System.out.print("Please enter your move row col: ");
                //Scanner scanner = new Scanner(System.in);
                //x = Integer.parseInt(scanner.next());
                //y = Integer.parseInt(scanner.next());

                //create a point from the player's input
                //Point chosenCell = new Point(x, y);
                //check if the player's input is valid
//                if (this.chosenCellValidity(possibleMovesVector, chosenCell)) {
//                    gameLogic.moveMaker(chosenCell, this.turn, this.nextTurn);
                    //break;
//                    return;
//                } else {
                    //keep looping
                    //System.out.println("The chosen cell is not valid. Try again.");
                    //System.out.println();
//                }
            //}while(true);
//            possibleMovesVector.clear();
//            this.setNextTurn();
            //end of the game criteria
        //}while(!(gameLogic.fullBoard()) && (gameLogic.possibleMoves(this.turn, this.nextTurn).size() != 0 ||
        //        gameLogic.possibleMoves(this.nextTurn, this.turn).size() != 0));

        //printing the board using printGameBoard function from DisplayGameOnConsole class
        //this.displayGame.printGameBoard();


        /*
        System.out.println();
        System.out.println();
        //display the results of the game
        System.out.println("The winner is: ");
        if(blackPlayer.getPlayerScore() > whitePlayer.getPlayerScore()){
            System.out.println("The black player with " + blackPlayer.getPlayerScore() + " cells.");
        }
        if(blackPlayer.getPlayerScore() < whitePlayer.getPlayerScore()){
            System.out.println("The white player with " + whitePlayer.getPlayerScore() + " cells.");
        }
        if(blackPlayer.getPlayerScore() == whitePlayer.getPlayerScore()){
            System.out.println("No winner, both players are even with " + blackPlayer.getPlayerScore() + " cells each.");
        }
        System.out.println();
        */
    }
}
