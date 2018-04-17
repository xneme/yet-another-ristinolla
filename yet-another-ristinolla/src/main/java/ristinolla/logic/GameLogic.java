package ristinolla.logic;

public interface GameLogic {

    int[][] getBoard();

    boolean[][] legalMoves();

    boolean makeMove(int x, int y);

    int getTurn();

    int getWinner();

    boolean isActive();

    void reset();

}
