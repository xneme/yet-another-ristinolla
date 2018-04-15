package ristinolla.logic;

public class BoardChecker {

    public boolean[][] getLegalMoves(int[][] board) {
        boolean[][] legalMoves = new boolean[board.length][board[0].length];

        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[0].length; x++) {
                if (board[y][x] == 0) {
                    legalMoves[y][x] = true;
                }
            }
        }

        return legalMoves;
    }
    
    public boolean hasLegalMovesLeft(int[][] board) {
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[0].length; x++) {
                if (board[y][x] == 0) {
                    return true;
                }
            }
        }
        
        return false;
    }

    public int getWinner(int[][] board, int marksToWin) {
        
        if (marksToWin > board.length && marksToWin > board[0].length) {
            return 0;
        }
        
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[0].length; x++) {
                if (board[y][x] != 0) {
                    int result = checkNeighbours(board, marksToWin, x, y);
                    if (result != 0) {
                        return result;
                    }
                }
            }
        }
        
        return 0;
    }
    
    private int checkNeighbours(int[][] board, int marksToWin, int x, int y) {
        int ne,e,se,s;
        int[] dir = new int[4]; // [ne, e, se, s]
        dir[0] = dir[1] = dir[2] = dir[3] = board[y][x];
        
        for (int i = 1; i <= marksToWin; i++) {
            if (x + i < board[0].length) {
                if (y + i < board.length) {
                    dir[2] += board[y+i][x+i];
                }
                if (y - i >= 0) {
                    dir[0] += board[y-i][x+i];
                }
                dir[1] += board[y][x+i];
            }
            if (y + i < board.length) {
                dir[3] += board[y+i][x];
            }
        }
        
        for (int c: dir) {
            if (c == marksToWin || -1 * c == marksToWin) {
                return board[y][x];
            }
        }
        
        return 0;
    }
}
