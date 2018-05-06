package org.mistahmilla.sudoku.solvers;

import org.junit.*;

import static org.junit.Assert.*;
import org.mistahmilla.sudoku.board.*;
import org.mistahmilla.sudoku.solvers.NakedSubset;

import java.util.ArrayList;

public class NakedSubsetTest {

    @Test
    public void testNakedSubset2(){
        Board b = new Board("0,2,0,1,0,0,0,0,0,0,0,6,0,0,0,0,0,0,5,0,3,0,0,0,0,0,0,0,3,0,0,0,0,0,0,0,0,1,0,0,2,0,6,0,0,0,0,0,6,0,0,0,0,0,8,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,9,0,0,0,0,0,0,0,0");
        b.generatePossibleValues();
        NakedSubset ns = new NakedSubset(b);
        assertTrue(b.getSquare(0,1).getPossibleValues().contains(Integer.valueOf(4)));
        ns.eliminate();
        assertTrue(!b.getSquare(0,1).getPossibleValues().contains(Integer.valueOf(4)));
    }

    @Test
    public void testNakedSubset3(){
        Board b = new Board("0,2,0,0,0,0,0,0,0,0,0,6,0,0,0,0,0,0,5,0,3,0,0,0,0,0,0,0,3,0,0,0,0,0,0,0,0,0,0,0,2,0,6,0,0,0,0,0,6,0,0,0,0,0,8,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,9,0,0,0,0,0,0,0,0");
        b.generatePossibleValues();
        NakedSubset ns = new NakedSubset(b);
        assertTrue(b.getSquare(0,7).getPossibleValues().contains(Integer.valueOf(4)));
        ns.eliminate();
        assertTrue(!b.getSquare(0,7).getPossibleValues().contains(Integer.valueOf(4)));
    }

    @Test
    public void testRemoveCandidates(){

        Board b = new Board();
        b.setValue(0, 0, 1);
        b.generatePossibleValues();
        NakedSubset ns = new NakedSubset(b);
        char[][] squares = new char[9][9];
        ArrayList candidates = new ArrayList();
        candidates.add(2);
        assertTrue(b.getSquare(0, 1).getPossibleValues().contains(Integer.valueOf(2)));
        ns.removeCandidates(squares, candidates, b.getBoardSections()[9]);
        assertTrue(!b.getSquare(0, 1).getPossibleValues().contains(Integer.valueOf(2)));

    }
}
