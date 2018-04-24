import org.junit.*;

import static org.junit.Assert.*;
import org.mistahmilla.sudoku.*;

public class BoardTest {

    @Test
    public void testSetValue(){
        Board b = new Board();
        b.setValue(0,0,1);
        assertTrue(b.getValue(0,0) == 1);
    }

    @Test
    public void testInput(){
        String input = "0,0,0,0,0,4,1,0,5,8,0,0,5,0,1,9,6,0,0,5,0,6,0,0,2,0,0,0,0,1,0,5,0,0,2,0,0,4,0,0,9,0,0,8,0,0,3,0,0,4,0,5,0,0,0,0,8,0,0,5,0,1,0,0,2,5,4,0,8,0,0,9,6,0,3,2,0,0,0,0,0";
        Board b = new Board(input);
        assertTrue(input.equals(b.toCSV()));
    }

    @Test
    public void testCheckValue(){
        Board b = new Board();
        b.setValue(1,1,1);
        assertEquals(true, b.hasValue(1,1));
        assertEquals(false, b.hasValue(1,0));
    }

    @Test
    public void missingCountTest(){
        Board b = new Board();
        assertEquals(81,b.missingCount());
        b.setValue(1,1,1);
        assertEquals(80,b.missingCount());
    }
}
