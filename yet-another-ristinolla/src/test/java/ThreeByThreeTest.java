import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ristinolla.logic.GameLogic;
import ristinolla.logic.ThreeByThree;

public class ThreeByThreeTest {
    
    GameLogic logic;
    
    @Before
    public void setUp() {
        logic = new ThreeByThree();
    }
    
    @Test
    public void BoardEmptyAtStartup() {
        int[][] board = {{0,0,0},{0,0,0},{0,0,0}};
        assertTrue(Arrays.deepEquals(logic.getBoard(), board));
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
    public void detectsTopRowWin() {
        int[][] board = {{1,1,1},{-1,-1,0},{0,0,0}};
        logic = new ThreeByThree(board, -1);
        assertEquals(1, logic.getWinner());
    }
    
    @Test
    public void winDeactivates() {
        int[][] board = {{1,1,0},{-1,-1,0},{0,0,0}};
        logic = new ThreeByThree(board, 1);
        logic.makeMove(2, 0);
        assertEquals(false, logic.isActive());
    }
    
    @Test
    public void nonWonIsActive() {
        int[][] board = {{1,1,0},{-1,-1,0},{0,0,1}};
        logic = new ThreeByThree(board, -1);
        assertEquals(true, logic.isActive());
    }
    
    @Test
    public void detectsMiddleRowWin() {
        int[][] board = {{1,1,0},{-1,-1,-1},{0,0,1}};
        logic = new ThreeByThree(board, 1);
        assertEquals(-1, logic.getWinner());
    }
    
    @Test
    public void detectsBottomRowWin() {
        int[][] board = {{0,0,0},{-1,-1,0},{1,1,1}};
        logic = new ThreeByThree(board, -1);
        assertEquals(1, logic.getWinner());
    }
    
    @Test
    public void detectsLeftColumnWin() {
        int[][] board = {{1,-1,1},{1,-1,0},{1,0,0}};
        logic = new ThreeByThree(board, -1);
        assertEquals(1, logic.getWinner());
    }
    
    @Test
    public void detectsMiddleColumnWin() {
        int[][] board = {{1,-1,1},{1,-1,0},{0,-1,1}};
        logic = new ThreeByThree(board, 1);
        assertEquals(-1, logic.getWinner());
    }
    
    @Test
    public void detectsRightColumnWin() {
        int[][] board = {{-1,0,1},{-1,0,1},{0,0,1}};
        logic = new ThreeByThree(board, -1);
        assertEquals(1, logic.getWinner());
    }
    
    @Test
    public void detectsDiagonal1Win() {
        int[][] board = {{-1,0,1},{1,-1,1},{1,0,-1}};
        logic = new ThreeByThree(board, 1);
        assertEquals(-1, logic.getWinner());
    }
    
    @Test
    public void detectsDiagonal2Win() {
        int[][] board = {{0,0,1},{0,1,-1},{1,0,-1}};
        logic = new ThreeByThree(board, -1);
        assertEquals(1, logic.getWinner());
    }
    
    public void detectsDraw() {
        int[][] board = {{0,0,1},{0,1,-1},{1,0,-1}};
        logic = new ThreeByThree(board, -1);
        assertEquals(1, logic.getWinner());
    }
}
