package ristinolla.logic;

import java.util.Arrays;

public class ThreeByThree implements GameLogic {

    int[][] board;
    boolean[][] legalmoves;
    int turn;
    int winner;
    boolean active;

    public ThreeByThree() {
        this.board = new int[3][3];
        this.legalmoves = new boolean[3][3];
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                legalmoves[y][x] = true;
            }
        }
        this.turn = 1;
        this.winner = 0;
        this.active = true;
    }

    public ThreeByThree(int[][] board, int turn) {
        this.board = board;
        this.legalmoves = new boolean[3][3];
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                if (board[y][x] == 0) {
                    legalmoves[y][x] = true;
                }
            }
        }
        this.turn = turn;
        this.winner = 0;
        this.active = true;
        this.checkBoard();
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
            this.switchTurn();
            this.checkBoard();
            return true;
        }

        return false;
    }

    private void checkBoard() {
        this.active = false;
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                if (legalmoves[y][x]) {
                    this.active = true;
                }
            }
        }

        for (int y = 0; y < 3; y++) {
            int sumx = 0;
            int sumy = 0;
            for (int x = 0; x < 3; x++) {
                sumx += board[y][x];
                sumy += board[x][y];
            }
            if (sumx > 2 || sumx < -2 || sumy > 2 || sumy < -2) {
                this.endGame();
                return;
            }
        }

        int diag1 = board[0][0] + board[1][1] + board[2][2];
        int diag2 = board[2][0] + board[1][1] + board[0][2];

        if (diag1 > 2 || diag1 < -2 || diag2 > 2 || diag2 < -2) {
            this.endGame();
        }
    }

    private void endGame() {
        this.active = false;
        this.switchTurn();
        this.winner = this.turn;
        this.switchTurn();
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
        this.legalmoves = new boolean[3][3];
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                legalmoves[y][x] = true;
            }
        }
        this.turn = 1;
        this.winner = 0;
        this.active = true;
    }
}
