import org.junit.*;
import org.mistahmilla.sudoku.board.BoardSquare;

import static org.junit.Assert.*;

public class BoardSquareTest {

    @Test
    public void setValue(){
        BoardSquare bs = new BoardSquare();
        bs.setValue(1);
        assertEquals(1,bs.getValue());

        bs = new BoardSquare(2);
        assertEquals(2, bs.getValue());
    }

    @Test
    public void setPossibleValue(){
        BoardSquare bs = new BoardSquare();
        bs.addPossibleValue(5);
        assertTrue(bs.getPossibleValues().contains(5));
        bs.removePossibleValue(5);
        assertTrue(!bs.getPossibleValues().contains(5));
        bs.addPossibleValue(1);
        bs.addPossibleValue(2);
        assertTrue(bs.getPossibleValues().contains(1));
    }
}
