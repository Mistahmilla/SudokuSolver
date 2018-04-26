package org.mistahmilla.sudoku;

import org.mistahmilla.sudoku.board.Board;
import org.mistahmilla.sudoku.solvers.*;

public class Game {

    private Board board;

    public Game(String values){
        board = new Board(values);
    }

    public void run(){
        int pre;
        int post;

        UniqueCandidateSolver us = new UniqueCandidateSolver(board);
        SoleCandidateSolver sc = new SoleCandidateSolver(board);
        BestGuessSolver bgs = new BestGuessSolver(board);

        do{
            pre = board.missingCount();

            us.solve();
            sc.solve();

            post = board.missingCount();
        }while(post<pre);

        board.generatePossibleValues();

        bgs.solve();

    }

    public Board getBoard(){
        return board;
    }

}
