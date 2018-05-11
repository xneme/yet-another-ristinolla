package ristinolla.logic;

import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ristinolla.logic.GameLogic;
import ristinolla.logic.UltimateGame;

public class UltimateGameTest {

    GameLogic logic;

    @Before
    public void setUp() {
        logic = new UltimateGame();
    }

    @Test
    public void BoardEmptyAtStartup() {
        int[][] board = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        assertTrue(Arrays.deepEquals(logic.getBoard(), board));
    }

    @Test
    public void ResetResetsBoard() {
        int[][][][] board = 
        {{{{1, 0, 0}, {1, 0, 0}, {1, 0, 0}},
        {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}},
        {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}},
        {{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}},
        {{0, 0, 0}, {1, 1, 1}, {0, 0, 0}},
        {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}},
        {{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}},
        {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}},
        {{-1, -1, -1}, {0, 0, 0}, {0, 0, 0}}}};
        
        int[][] emptyboard = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        logic = new UltimateGame(board, 1, 0, 0);
        logic.reset();
        assertTrue(Arrays.deepEquals(logic.getBoard(), emptyboard));
    }

    @Test
    public void xStarts() {
        assertEquals(1, logic.getTurn());
    }

    @Test
    public void turnChangesOnMove() {
        logic.makeMove(4, 4);
        assertEquals(-1, logic.getTurn());
    }

    @Test
    public void turnChangesOnMove2() {
        logic.makeMove(4, 4);
        logic.makeMove(4, 5);
        assertEquals(1, logic.getTurn());
    }

    @Test
    public void winDeactivates() {
        int[][][][] board = 
        {{{{0, 1, 1}, {0, 0, 0}, {0, 0, 0}},
        {{1, 1, 1}, {0, 0, 0}, {0, 0, 0}},
        {{1, 1, 1}, {0, 0, 0}, {0, 0, 0}}},
        {{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}},
        {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}},
        {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}},
        {{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}},
        {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}},
        {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}}};
        logic = new UltimateGame(board, 1, 0, 0);
        logic.makeMove(0, 0);
        assertEquals(false, logic.isActive());
    }
    
    @Test
    public void winnerIsReturned() {
        int[][][][] board = 
        {{{{0, 1, 1}, {0, 0, 0}, {0, 0, 0}},
        {{1, 1, 1}, {0, 0, 0}, {0, 0, 0}},
        {{1, 1, 1}, {0, 0, 0}, {0, 0, 0}}},
        {{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}},
        {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}},
        {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}},
        {{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}},
        {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}},
        {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}}};
        logic = new UltimateGame(board, 1, 0, 0);
        logic.makeMove(0, 0);
        assertEquals(1, logic.getWinner());
    }

    @Test
    public void nonWonIsActive() {
        int[][][][] board = 
        {{{{0, 1, 1}, {0, 0, 0}, {0, 0, 0}},
        {{1, 1, 1}, {0, 0, 0}, {0, 0, 0}},
        {{1, 1, 1}, {0, 0, 0}, {0, 0, 0}}},
        {{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}},
        {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}},
        {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}},
        {{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}},
        {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}},
        {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}}};
        logic = new UltimateGame(board, 1, 0, 0);
        assertEquals(true, logic.isActive());
    }
    
    @Test
    public void drawIsInactive() {
        int[][][][] board = 
        {{{{1, -1, 1}, {1, -1, -1}, {-1, 1, -1}},
        {{1, -1, 1}, {1, -1, -1}, {-1, 1, -1}},
        {{1, -1, 1}, {1, -1, -1}, {-1, 1, -1}}},
        {{{1, -1, 1}, {1, -1, -1}, {-1, 1, -1}},
        {{1, -1, 1}, {1, -1, -1}, {-1, 1, -1}},
        {{1, -1, 1}, {1, -1, -1}, {-1, 1, -1}}},
        {{{1, -1, 1}, {1, -1, -1}, {-1, 1, -1}},
        {{1, -1, 1}, {1, -1, -1}, {-1, 1, -1}},
        {{1, -1, 1}, {1, -1, -1}, {-1, 1, -1}}}};
        logic = new UltimateGame(board, 1, 0, 0);
        assertEquals(false, logic.isActive());
    }

    @Test
    public void IllegalMoveFails() {
        assertFalse(logic.makeMove(0, 0));
    }
}
