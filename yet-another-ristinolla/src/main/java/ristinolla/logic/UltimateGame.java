package ristinolla.logic;

public class UltimateGame implements GameLogic {

    private int[][] bigBoard;
    private int[][][][] smallBoards;
    private BoardChecker checker;
    private int winner;
    private boolean active;
    private int turn;
    private boolean[][] legalmoves;

    public UltimateGame() {
        this.bigBoard = new int[3][3];
        this.smallBoards = new int[3][3][3][3];
        this.checker = new BoardChecker();
        this.winner = 0;
        this.active = true;
        this.turn = 1;
        this.legalmoves = checker.getLegalMoves(smallBoards, 1, 1);
    }

    public UltimateGame(int[][][][] board, int turn, int bigX, int bigY) {
        this.bigBoard = new int[3][3];
        this.smallBoards = board;
        this.checker = new BoardChecker();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int status = checker.getWinner(smallBoards[i][j], 3);
                if (status == 0 && !checker.hasLegalMovesLeft(smallBoards[i][j])) {
                    bigBoard[i][j] = 2;
                } else {
                    bigBoard[i][j] = status;
                }
            }
        }
        this.winner = checker.getWinner(bigBoard, 3);
        if (this.winner == 0) {
            this.active = checker.hasLegalMovesLeft(bigBoard);
        } else {
            this.active = false;
        }
        this.turn = turn;

        if (this.bigBoard[bigY][bigX] == 0) {
            this.legalmoves = checker.getLegalMoves(smallBoards, bigX, bigY);
        } else {
            this.legalmoves = checker.getLegalMoves(smallBoards);
        }
    }

    @Override
    public int[][] getBoard() {
        return this.bigBoard;
    }

    @Override
    public boolean[][] legalMoves() {
        return this.legalmoves;
    }

    @Override
    public boolean makeMove(int x, int y) {
        int bigX = x / 3;
        int smallX = x % 3;
        int bigY = y / 3;
        int smallY = y % 3;

        if (this.legalmoves[y][x]) {
            this.smallBoards[bigY][bigX][smallY][smallX] = this.turn;

            int smallStatus = checker.getWinner(smallBoards[bigY][bigX], 3);
            if (smallStatus != 0) {
                fillSmallBoard(bigX, bigY);
                bigBoard[bigY][bigX] = this.turn;
                int bigStatus = checker.getWinner(bigBoard, 3);
                if (bigStatus != 0) {
                    this.winner = bigStatus;
                    this.active = false;
                    this.legalmoves = new boolean[9][9];
                } else if (!checker.hasLegalMovesLeft(bigBoard)) {
                    this.active = false;
                    this.legalmoves = new boolean[9][9];
                }
            } else if (!checker.hasLegalMovesLeft(smallBoards[bigY][bigX])) {
                bigBoard[bigY][bigX] = 2;
            }

            if (this.bigBoard[smallY][smallX] == 0) {
                this.legalmoves = checker.getLegalMoves(smallBoards, smallX, smallY);
            } else {
                this.legalmoves = checker.getLegalMoves(smallBoards);
            }

            this.switchTurn();
            return true;
        }

        return false;
    }

    private void fillSmallBoard(int bigX, int bigY) {
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                smallBoards[bigY][bigX][y][x] = this.turn;
            }
        }
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
        this.bigBoard = new int[3][3];
        this.smallBoards = new int[3][3][3][3];
        this.winner = 0;
        this.active = true;
        this.turn = 1;
        this.legalmoves = checker.getLegalMoves(smallBoards);
    }

    private void switchTurn() {
        if (this.turn == 1) {
            this.turn = -1;
        } else {
            this.turn = 1;
        }
    }

}
