package ristinolla.logic;

import java.util.Arrays;

public class ThreeByThree implements GameLogic {

    BoardChecker checker;
    int[][] board;
    boolean[][] legalmoves;
    int turn;
    int winner;
    boolean active;

    public ThreeByThree() {
        checker = new BoardChecker();
        this.board = new int[3][3];
        this.legalmoves = checker.getLegalMoves(board);
        this.turn = 1;
        this.winner = 0;
        this.active = true;
    }

    public ThreeByThree(int[][] board, int turn) {
        checker = new BoardChecker();
        this.board = board;
        this.legalmoves = checker.getLegalMoves(board);
        this.turn = turn;
        this.winner = 0;
        this.active = true;
        int status = checker.getWinner(board, 3);
        if (status != 0) {
            this.winner = status;
            this.active = false;
        } else if (!checker.hasLegalMovesLeft(board)) {
            this.active = false;
        }
    }

    @Override
    public int[][] getBoard() {
        return this.board;
    }

    private void switchTurn() {
        if (this.turn == 1) {
            this.turn = -1;
        } else {
            this.turn = 1;
        }
    }

    @Override
    public boolean[][] legalMoves() {
        return this.legalmoves;
    }

    @Override
    public boolean makeMove(int x, int y) {
        if (this.legalmoves[y][x]) {
            this.board[y][x] = this.turn;
            this.legalmoves[y][x] = false;

            int status = checker.getWinner(board, 3);
            if (status != 0) {
                this.winner = status;
                this.active = false;
            } else if (!checker.hasLegalMovesLeft(board)) {
                this.active = false;
            }
            this.switchTurn();
            return true;
        }

        return false;
    }

    @Override
    public int getTurn() {
        return this.turn;
    }

    @Override
    public int getWinner() {
        return this.winner;
    }

    @Override
    public boolean isActive() {
        return this.active;
    }

    @Override
    public void reset() {
        this.board = new int[3][3];
        this.legalmoves = checker.getLegalMoves(board);
        this.turn = 1;
        this.winner = 0;
        this.active = true;
    }
}
