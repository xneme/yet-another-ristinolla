package ristinolla.logic;

import java.util.Arrays;
import java.util.Random;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BoardCheckerTest {

    BoardChecker checker;

    @Before
    public void setUp() {
        checker = new BoardChecker();
    }

    @Test
    public void detectsTopRowWin() {
        int[][] board = {{1, 1, 1}, {-1, -1, 0}, {0, 0, 0}};
        assertEquals(1, checker.getWinner(board, 3));
    }

    @Test
    public void detectsMiddleRowWin() {
        int[][] board = {{1, 1, 0}, {-1, -1, -1}, {0, 0, 1}};
        assertEquals(-1, checker.getWinner(board, 3));
    }

    @Test
    public void detectsBottomRowWin() {
        int[][] board = {{0, 0, 0}, {-1, -1, 0}, {1, 1, 1}};
        assertEquals(1, checker.getWinner(board, 3));
    }

    @Test
    public void detectsLeftColumnWin() {
        int[][] board = {{1, -1, 1}, {1, -1, 0}, {1, 0, 0}};
        assertEquals(1, checker.getWinner(board, 3));
    }

    @Test
    public void detectsMiddleColumnWin() {
        int[][] board = {{1, -1, 1}, {1, -1, 0}, {0, -1, 1}};
        assertEquals(-1, checker.getWinner(board, 3));
    }

    @Test
    public void detectsRightColumnWin() {
        int[][] board = {{-1, 0, 1}, {-1, 0, 1}, {0, 0, 1}};
        assertEquals(1, checker.getWinner(board, 3));
    }

    @Test
    public void detectsDiagonal1Win() {
        int[][] board = {{-1, 0, 1}, {1, -1, 1}, {1, 0, -1}};
        assertEquals(-1, checker.getWinner(board, 3));
    }

    @Test
    public void detectsDiagonal2Win() {
        int[][] board = {{0, 0, 1}, {0, 1, -1}, {1, 0, -1}};
        assertEquals(1, checker.getWinner(board, 3));
    }
    
    @Test
    public void noWinnerForImpossibleMarkstowin() {
        int[][] board = {{0, 0, 1, 0}, {0, 1, -1, 0}, {1, 0, -1, 0}};
        assertEquals(0, checker.getWinner(board, 4));
    }
    
    @Test
    public void noWinnerForImpossibleMarkstowin2() {
        int[][] board = {{0, 0, 1}, {0, 1, -1}, {1, 0, -1}, {1, 1, 1}};
        assertEquals(0, checker.getWinner(board, 4));
    }

    @Test
    public void legalMovesWorks() {
        int[][] board = {{1, 1, 0}, {-1, -1, 0}, {0, 0, 0}};
        boolean[][] expected = {{false, false, true},{false, false, true},{true, true, true}};
        assertTrue(Arrays.deepEquals(checker.getLegalMoves(board), expected));
    }
    
    @Test
    public void ultimateLegalMovesWorks() {
        Random r = new Random();
        int[][][][] board = new int[3][3][3][3];
        
        boolean[][] expected = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            Arrays.fill(expected[i], true);
        }
        
        for (int i = 0; i < 10; i++) {
            int x = r.nextInt(9);
            int y = r.nextInt(9);
            
            board[y/3][x/3][y%3][x%3] = 1;
            expected[y][x] = false;
        }
        assertTrue(Arrays.deepEquals(checker.getLegalMoves(board), expected));
    }
    
    @Test
    public void ultimateLegalMovesForOneSmallWorks() {
        Random r = new Random();
        int[][][][] board = new int[3][3][3][3];
        
        boolean[][] expected = new boolean[9][9];
        for (int y = 3; y < 6; y++) {
            for (int x = 3; x < 6; x++) {
                expected[y][x] = true;
            }
        }
        
        for (int i = 0; i < 50; i++) {
            int x = r.nextInt(9);
            int y = r.nextInt(9);
            
            board[y/3][x/3][y%3][x%3] = 1;
            expected[y][x] = false;
        }
        assertTrue(Arrays.deepEquals(checker.getLegalMoves(board, 1, 1), expected));
    }
    
}
