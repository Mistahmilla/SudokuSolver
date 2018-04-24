package org.mistahmilla.sudoku;

public class SudokuSolver {

    public static void main(String args[]){
        Game g;

        if (args.length == 1){
            g = new Game(args[0]);
            g.run();

            while(g.getBoard().missingCount() != 0){
            }

            System.out.println(g.getBoard());
            System.out.println(g.getBoard().toCSV());

        }
    }
}
