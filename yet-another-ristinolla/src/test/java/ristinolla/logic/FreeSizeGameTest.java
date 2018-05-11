package ristinolla.logic;

import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ristinolla.logic.GameLogic;
import ristinolla.logic.FreeSizeGame;

public class FreeSizeGameTest {

    GameLogic logic;

    @Before
    public void setUp() {
        logic = new FreeSizeGame(3, 3);
    }

    @Test
    public void BoardEmptyAtStartup() {
        int[][] board = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        assertTrue(Arrays.deepEquals(logic.getBoard(), board));
    }

    @Test
    public void ResetResetsBoard() {
        int[][] board = {{1, 1, 1}, {-1, -1, 0}, {0, 0, 0}};
        int[][] emptyboard = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        logic = new FreeSizeGame(board, 3, -1);
        logic.reset();
        assertTrue(Arrays.deepEquals(logic.getBoard(), emptyboard));
    }

    @Test
    public void xStarts() {
        assertEquals(1, logic.getTurn());
    }

    @Test
    public void turnChangesOnMove() {
        logic.makeMove(0, 0);
        assertEquals(-1, logic.getTurn());
    }
    
    @Test
    public void turnChangesOnMove2() {
        logic.makeMove(0, 0);
        logic.makeMove(0, 1);
        assertEquals(1, logic.getTurn());
    }

    @Test
    public void winDeactivates() {
        int[][] board = {{1, 1, 0}, {-1, -1, 0}, {0, 0, 0}};
        logic = new FreeSizeGame(board, 3, 1);
        logic.makeMove(2, 0);
        assertEquals(false, logic.isActive());
    }

    @Test
    public void nonWonIsActive() {
        int[][] board = {{1, 1, 0}, {-1, -1, 0}, {0, 0, 1}};
        logic = new FreeSizeGame(board, 3, -1);
        assertEquals(true, logic.isActive());
    }

    @Test
    public void drawDeactivates() {
        int[][] board = {{1, -1, 1}, {1, -1, -1}, {-1, 1, -1}};
        logic = new FreeSizeGame(board, 3, -1);
        assertFalse(logic.isActive());
    }
    
     @Test
    public void drawMoveDeactivates() {
        int[][] board = {{1, 0, 1}, {1, -1, -1}, {-1, 1, -1}};
        logic = new FreeSizeGame(board, 3, -1);
        logic.makeMove(1, 0);
        assertFalse(logic.isActive());
    }
    
     @Test
    public void winnerIs0OnDraw() {
        int[][] board = {{1, -1, 1}, {1, -1, -1}, {-1, 1, -1}};
        logic = new FreeSizeGame(board, 3, -1);
        assertEquals(0, logic.getWinner());
    }
    
    @Test
    public void legalMovesWorks() {
        int[][] board = {{1, 1, 0}, {-1, -1, 0}, {0, 0, 0}};
        boolean[][] expected = {{false, false, true},{false, false, true},{true, true, true}};
        logic = new FreeSizeGame(board, 3, 1);
        assertTrue(Arrays.deepEquals(logic.legalMoves(), expected));
    }
    
    @Test
    public void IllegalMoveFails() {
        int[][] board = {{1, 1, 1}, {-1, -1, 0}, {0, 0, 0}};
        logic = new FreeSizeGame(board, 3, -1);
        assertFalse(logic.makeMove(0, 0));
    }
}
