package reversi_code;

/**
 * the class HumanPlayer defines HumanPlayer object.
 */
public class HumanPlayer implements Player {

    //the sign of the player(BLACK or WHITE)
    private Sign playerSign;
    //the score of the player
    private int playerScore;
    //the color of the player
    private String playerColor;

    /**
     * constructor of HumanPlayer object.
     * @param playerSign value from enum Sign.
     */
    public HumanPlayer(Sign playerSign) {
        this.playerSign = playerSign;
        this.playerScore = 2;
        this.playerColor = playerSign.toString();
    }

    /**
     * get the sign of the player(BLACK or WHITE).
     * @return sign of the player.
     */
    public Sign getPlayerSign() {
        return playerSign;
    }

    /**
     * set the sign of the player(BLACK or WHITE).
     * @param playerSign .
     */
    public void setPlayerSign(Sign playerSign) {
        this.playerSign = playerSign;
    }

    /**
     * get the score of the player.
     * @return playerScore.
     */
    public int getPlayerScore() {
        return playerScore;
    }

    /**
     * set the score of the player.
     * @param addToPlayerScore number to add to the current score.
     */
    public void setPlayerScore(int addToPlayerScore) {
        this.playerScore += addToPlayerScore;
    }

    /**
     * get the color of the player.
     * @return color of the player.
     */
    public String getPlayerColor() {
        return playerColor;
    }

    /**
     * set the sign of the player(BLACK or WHITE).
     * @param playerColor .
     */
    public void setPlayerColor(String playerColor) {
        this.playerColor = playerColor;
    }
}
