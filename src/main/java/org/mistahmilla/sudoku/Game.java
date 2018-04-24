package org.mistahmilla.sudoku;

import org.mistahmilla.sudoku.org.mistahmilla.sudoku.board.Board;
import org.mistahmilla.sudoku.solvers.*;

public class Game {

    private Board _board;

    public Game(String values){
        _board = new Board(values);
    }

    public void run(){
        int pre;
        int post;

        UniqueCandidateSolver us = new UniqueCandidateSolver(_board);
        SoleCandidateSolver sc = new SoleCandidateSolver(_board);
        BestGuessSolver bgs = new BestGuessSolver(_board);

        do{
            pre = _board.missingCount();

            us.Solve();
            sc.Solve();

            post = _board.missingCount();
        }while(post<pre);
        bgs.Solve();
    }

    public Board getBoard(){
        return _board;
    }

}
