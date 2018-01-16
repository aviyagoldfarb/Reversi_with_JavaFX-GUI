package reversi_code;

/**
 * interface GuiPlayersHandler.
 */
public interface Player {

    /**
     * get the sign of the player(BLACK or WHITE).
     * @return sign of the player.
     */
    Sign getPlayerSign();
    /**
     * set the sign of the player(BLACK or WHITE).
     * @param playerSign .
     */
    void setPlayerSign(Sign playerSign);
    /**
     * get the score of the player.
     * @return playerScore.
     */
    int getPlayerScore();
    /**
     * set the score of the player.
     * @param addToPlayerScore number to add to the current score.
     */
    void setPlayerScore(int addToPlayerScore);
    /**
     * get the color of the player.
     * @return color of the player.
     */
    String getPlayerColor();
    /**
     * set the sign of the player(BLACK or WHITE).
     * @param playerColor .
     */
    void setPlayerColor(String playerColor);

}
