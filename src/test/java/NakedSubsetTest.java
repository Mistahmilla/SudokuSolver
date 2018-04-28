import org.junit.*;

import static org.junit.Assert.*;
import org.mistahmilla.sudoku.board.*;
import org.mistahmilla.sudoku.solvers.NakedSubset;

public class NakedSubsetTest {

    @Test
    public void testNakedSubset(){
        Board b = new Board("0,2,0,1,0,0,0,0,0,0,0,6,0,0,0,0,0,0,5,0,3,0,0,0,0,0,0,0,3,0,0,0,0,0,0,0,0,1,0,0,2,0,6,0,0,0,0,0,6,0,0,0,0,0,8,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,9,0,0,0,0,0,0,0,0");
        b.generatePossibleValues();
        NakedSubset ns = new NakedSubset(b);
        ns.eliminate();
        assertTrue(!b.getSquare(0,1).getPossibleValues().contains(Integer.valueOf(4)));
    }
}
