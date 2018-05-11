package ristinolla.logic;

/**
 * Class for handling a tic-tac-toe game logic.
 */
public interface GameLogic {

    /**
     * Method for getting the 1/0/-1 tic tac toe board.
     *
     * @return int[][] array with 1 and -1 for moves, 0 for free squares.
     */
    int[][] getBoard();

    /**
     * Method for finding free squares available for moves.
     *
     * @return boolean[][] with true for free squares.
     */
    boolean[][] legalMoves();

    /**
     * Method for making a game move. Players alternate automatically.
     *
     * @param x x-coordinate on board
     *
     * @param y y-coordinate on board
     *
     * @return true if move succeeded, false if move was illegal.
     */
    boolean makeMove(int x, int y);

    /**
     * Method for finding out which player's turn it is.
     *
     * @return 1 or -1, depending on which turn it is.
     */
    int getTurn();

    /**
     * Method for finding out the winner.
     *
     * @return 0 for draw or active game, 1 or -1 if there is a winner.
     */
    int getWinner();

    /**
     * Method for finding out if the game is still active, meaning there are no
     * winners and there are legal moves left.
     *
     * @return true for active game, false otherwise.
     */
    boolean isActive();

    /**
     * Method for resetting the game.
     */
    void reset();

}
