package org.mistahmilla.sudoku;

public class SudokuSolver {

    public static void main(String[] args){
        Game g;

        if (args.length == 1){

            try {
                g = new Game(args[0]);
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
                return;
            }
            g.run();

            while(g.getBoard().missingCount() != 0){
            }

            System.out.println(g.getBoard());
            System.out.println(g.getBoard().toCSV());

        }
    }
}
