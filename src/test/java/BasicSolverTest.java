import org.junit.*;
import org.mistahmilla.sudoku.board.Board;
import org.mistahmilla.sudoku.solvers.UniqueCandidateSolver;

import static org.junit.Assert.*;

public class BasicSolverTest {

    @Test
    public void testEasy(){
        String input = "0,0,0,0,0,4,1,0,5,8,0,0,5,0,1,9,6,0,0,5,0,6,0,0,2,0,0,0,0,1,0,5,0,0,2,0,0,4,0,0,9,0,0,8,0,0,3,0,0,4,0,5,0,0,0,0,8,0,0,5,0,1,0,0,2,5,4,0,8,0,0,9,6,0,3,2,0,0,0,0,0";
        Board b = new Board(input);
        UniqueCandidateSolver bs = new UniqueCandidateSolver(b);
        bs.solve();
        assertTrue( b.toCSV().equals("3,6,2,9,8,4,1,7,5,8,7,4,5,2,1,9,6,3,1,5,9,6,3,7,2,4,8,9,8,1,7,5,3,4,2,6,5,4,6,1,9,2,3,8,7,2,3,7,8,4,6,5,9,1,4,9,8,3,6,5,7,1,2,7,2,5,4,1,8,6,3,9,6,1,3,2,7,9,8,5,4"));
    }
}
