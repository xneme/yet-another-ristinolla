package ristinolla.logic;

public class FreeSizeGame implements GameLogic {

    private BoardChecker checker;
    private int[][] board;
    private boolean[][] legalmoves;
    private int turn;
    private int winner;
    private boolean active;
    private int marksToWin;
    private int size;

    public FreeSizeGame(int size, int marksToWin) {
        checker = new BoardChecker();
        this.size = size;
        this.board = new int[size][size];
        this.legalmoves = checker.getLegalMoves(board);
        this.turn = 1;
        this.winner = 0;
        this.active = true;
        this.marksToWin = marksToWin;
    }

    public FreeSizeGame(int[][] board, int marksToWin, int turn) {
        checker = new BoardChecker();
        this.board = board;
        this.legalmoves = checker.getLegalMoves(board);
        this.marksToWin = marksToWin;
        this.size = board.length;
        this.turn = turn;
        this.winner = 0;
        this.active = true;
        int status = checker.getWinner(board, marksToWin);
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

            int status = checker.getWinner(board, marksToWin);
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
        this.board = new int[size][size];
        this.legalmoves = checker.getLegalMoves(board);
        this.turn = 1;
        this.winner = 0;
        this.active = true;
    }
}
