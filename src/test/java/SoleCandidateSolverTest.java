import org.junit.*;
import org.mistahmilla.sudoku.board.Board;
import org.mistahmilla.sudoku.solvers.SoleCandidateSolver;

import static org.junit.Assert.*;

public class SoleCandidateSolverTest {

    @Test
    public void testEasy(){
        String input = "0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,6,0,0,0,0,0,0,4,0,0,0,0,0,0,0,0,0,8,0,0,0,0,2,0,9,0,0,0,0,0,7,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,0,0,0,0,0,0,0,0,0,0,0,0";
        Board b = new Board(input);
        SoleCandidateSolver bs = new SoleCandidateSolver(b);
        bs.solve();
        assertEquals(5, b.getValue(5,5));
    }

}
