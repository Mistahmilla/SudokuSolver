import org.junit.*;

import static org.junit.Assert.*;

import org.mistahmilla.sudoku.board.Board;

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

    @Test
    public void testBoardSizeSmall(){
        boolean thrown = false;
        try {
            Board b = new Board("1,2,3");
        }catch (IllegalArgumentException e){
            thrown = true;
        }
        assertTrue(thrown);
    }

    @Test
    public void testBoardSizeLarge(){
        boolean thrown = false;
        try {
            Board b = new Board("9,3,4,7,1,2,6,5,8,2,6,5,9,8,3,4,7,1,1,7,8,5,4,6,9,3,2,7,2,1,4,6,9,3,8,5,6,8,9,3,7,5,1,2,4,5,4,3,8,2,1,7,9,6,4,9,2,6,3,8,5,1,7,3,1,7,2,5,4,8,6,9,8,5,6,1,9,7,2,4,3,1");
        }catch (IllegalArgumentException e){
            thrown = true;
        }
        assertTrue(thrown);
    }

    @Test
    public void testBoardSizeCorrect(){
        boolean thrown = false;
        try {
            Board b = new Board("9,3,4,7,1,2,6,5,8,2,6,5,9,8,3,4,7,1,1,7,8,5,4,6,9,3,2,7,2,1,4,6,9,3,8,5,6,8,9,3,7,5,1,2,4,5,4,3,8,2,1,7,9,6,4,9,2,6,3,8,5,1,7,3,1,7,2,5,4,8,6,9,8,5,6,1,9,7,2,4,3");
        }catch (IllegalArgumentException e){
            thrown = true;
        }
        assertTrue(!thrown);
    }

    @Test
    public void testIsValidFalse(){
        boolean thrown = false;
        try {
            Board b = new Board("9,9,4,7,1,2,6,5,8,2,6,5,9,8,3,4,7,1,1,7,8,5,4,6,9,3,2,7,2,1,4,6,9,3,8,5,6,8,9,3,7,5,1,2,4,5,4,3,8,2,1,7,9,6,4,9,2,6,3,8,5,1,7,3,1,7,2,5,4,8,6,9,8,5,6,1,9,7,2,4,3");
        }catch(IllegalArgumentException e){
            thrown = true;
        }
        assertTrue(thrown);
    }

    @Test
    public void testIsValidTrue(){
        boolean thrown = false;
        try {
            Board b = new Board("9,3,4,7,1,2,6,5,8,2,6,5,9,8,3,4,7,1,1,7,8,5,4,6,9,3,2,7,2,1,4,6,9,3,8,5,6,8,9,3,7,5,1,2,4,5,4,3,8,2,1,7,9,6,4,9,2,6,3,8,5,1,7,3,1,7,2,5,4,8,6,9,8,5,6,1,9,7,2,4,3");
        }catch(IllegalArgumentException e){
            thrown = true;
        }
        assertTrue(!thrown);
    }

}
