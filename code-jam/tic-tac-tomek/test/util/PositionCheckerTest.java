package util;

import static org.junit.Assert.*;
import logic.PositionChecker;
import logic.Result;

import org.junit.Before;
import org.junit.Test;

public class PositionCheckerTest {

    class PositionCheckerUnderTest extends PositionChecker {
        
        @Override
        protected Result checkRows(int[][] playfield) {
        	return super.checkRows(playfield);
        }

        @Override
        protected Result checkColumns(int[][] playfield) {
        	return super.checkColumns(playfield);
        }

        @Override
        protected Result checkDiagonals(int[][] playfield) {
            return super.checkDiagonals(playfield);
        }        
    }
    
    public PositionCheckerUnderTest checker;
    public int[][] playfield = new int[4][4];
    

    
    @Before
    public void init() {
        checker = new PositionCheckerUnderTest();
        playfield = new int[4][4];
    }
    
   @Test
    public void checkRowsForEmptyPlayfield() {
        Result result = checker.checkRows(playfield);
        assertEquals(Result.DRAWN, result);
    }

   @Test
    public void checkRowsForFilledFirstRow() {
        playfield[0][0] = 1;
        playfield[0][1] = 1;
        playfield[0][2] = 1;
        playfield[0][3] = 1;        
        Result result = checker.checkRows(playfield);
        assertEquals(Result.WON, result);
    }

  @Test
    public void checkRowsForPartiallyFilledFirstRow() {
        playfield[0][0] = 1;
        playfield[0][1] = 1;
        playfield[0][2] = 0;
        playfield[0][3] = 1;        
        Result result = checker.checkRows(playfield);
        assertEquals(Result.DRAWN, result);
    }
   
   @Test
    public void checkRowsForFilledLastRow() {
        playfield[3][0] = 1;
        playfield[3][1] = 1;
        playfield[3][2] = 1;
        playfield[3][3] = 1;        
        Result result = checker.checkRows(playfield);
        assertEquals(Result.WON, result);
    }
  
    @Test
    public void checkRowsForPartiallyFilledLastRow() {
        playfield[3][0] = 0;
        playfield[3][1] = 1;
        playfield[3][2] = 1;
        playfield[3][3] = 1;        
        Result result = checker.checkRows(playfield);
        assertEquals(Result.DRAWN, result);
    }
    
    @Test
    public void checkColumnsForEmptyPlayfield() {
        Result result = checker.checkColumns(playfield);
        assertEquals(Result.DRAWN, result);
    }
    
    @Test
    public void checkColumnsForFilledFirstColumn() {
        playfield[0][0] = 1;
        playfield[1][0] = 1;
        playfield[2][0] = 1;
        playfield[3][0] = 1;        
        Result result = checker.checkColumns(playfield);
        assertEquals(Result.WON, result);
    }

    @Test
    public void checkColumnsForPatriallyFilledFirstColumn() {
        playfield[0][0] = 1;
        playfield[1][0] = 1;
        playfield[2][0] = 0;
        playfield[3][0] = 1;        
        Result result = checker.checkColumns(playfield);
        assertEquals(Result.DRAWN, result);
    }
    
    @Test
    public void checkColumnsForFilledLastColumn() {
        playfield[0][3] = 1;
        playfield[1][3] = 1;
        playfield[2][3] = 1;
        playfield[3][3] = 1;        
        Result result = checker.checkColumns(playfield);
        assertEquals(Result.WON, result);
    }    

    @Test
    public void checkColumnsForPartiallyFilledLastColumn() {
        playfield[0][3] = 1;
        playfield[1][3] = 1;
        playfield[2][3] = 0;
        playfield[3][3] = 1;        
        Result result = checker.checkColumns(playfield);
        assertEquals(Result.DRAWN, result);
    }
    
    @Test
    public void checkDiagonalsForEmptyField() {    
        Result result = checker.checkDiagonals(playfield);
        assertEquals(Result.DRAWN, result);
    }

    @Test
    public void checkDiagonalsForFilledLeftTopDownDiagonal() {    
        playfield[0][0] = 1;
        playfield[1][1] = 1;
        playfield[2][2] = 1;
        playfield[3][3] = 1;
        Result result = checker.checkDiagonals(playfield);
        assertEquals(Result.WON, result);
    }
    
    @Test
    public void checkDiagonalsForPartiallyFilledLeftTopDownDiagonal() {    
        playfield[0][0] = 1;
        playfield[1][1] = 1;
        playfield[2][2] = 0;
        playfield[3][3] = 1;
        Result result = checker.checkDiagonals(playfield);
        assertEquals(Result.DRAWN, result);
    }
    
    @Test
    public void checkDiagonalsForFilledLeftDownTopDiagonal() {    
        playfield[0][3] = 1;
        playfield[1][2] = 1;
        playfield[2][1] = 1;
        playfield[3][0] = 1;
        Result result = checker.checkDiagonals(playfield);
        assertEquals(Result.WON, result);
    }
    
    @Test
    public void checkDiagonalsForPartiallyFilledLeftDownTopDiagonal() {    
        playfield[0][3] = 1;
        playfield[1][2] = 0;
        playfield[2][1] = 1;
        playfield[3][0] = 1;
        Result result = checker.checkDiagonals(playfield);
        assertEquals(Result.DRAWN, result);
    }
    
    @Test
    public void checkGameDraw() {
        Result result = checker.checkGame(playfield);
        assertEquals(Result.DRAWN, result);
    }

    @Test
    public void checkGameWonForRows() {
        playfield[0][0] = 1;
        playfield[0][1] = 1;
        playfield[0][2] = 1;
        playfield[0][3] = 1;  
        Result result = checker.checkGame(playfield);
        assertEquals(Result.WON, result);
    }    

    @Test
    public void checkGameWonForColumns() {
        playfield[0][0] = 1;
        playfield[1][0] = 1;
        playfield[2][0] = 1;
        playfield[3][0] = 1;   
        Result result = checker.checkGame(playfield);
        assertEquals(Result.WON, result);
    }     

    @Test
    public void checkGameWonForLeftTopDownDiagonal() {
        playfield[0][0] = 1;
        playfield[1][1] = 1;
        playfield[2][2] = 1;
        playfield[3][3] = 1;
        Result result = checker.checkGame(playfield);
        assertEquals(Result.WON, result);
    } 

    @Test
    public void checkGameWonForLeftDownTopDiagonal() {
        playfield[0][3] = 1;
        playfield[1][2] = 1;
        playfield[2][1] = 1;
        playfield[3][0] = 1;
        Result result = checker.checkGame(playfield);
        assertEquals(Result.WON, result);
    } 
}
