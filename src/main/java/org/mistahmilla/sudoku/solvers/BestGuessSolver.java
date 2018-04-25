package org.mistahmilla.sudoku.solvers;
import org.mistahmilla.sudoku.*;
import org.mistahmilla.sudoku.org.mistahmilla.sudoku.board.Board;

public class BestGuessSolver implements Solver {

    private Board board;

    public BestGuessSolver(Board board){
        this.board = board;
    }

    public void Solve(){
        int bestX;
        int bestY;
        int fewest;
        boolean done;
        Game g;

        board.generatePossibleValues();

        done = false;
        bestX = 0;
        bestY = 0;
        fewest = 9;

        for (int x = 0; x <9; x++){
            for (int y = 0; y<9; y++){
                if(board.getSquare(x, y).getPossibleValues().size() < fewest && board.getSquare(x, y).getPossibleValues().size() != 0){
                    bestX = x;
                    bestY = y;
                    fewest = board.getSquare(x, y).getPossibleValues().size();
                }
            }
        }

        // create new games seeded off the possible numbers and try to solve them
        for (int i = 0; i < board.getSquare(bestX, bestY).getPossibleValues().size() && !done; i++){
            g = new Game(board.toCSV());
            g.getBoard().setValue(bestX, bestY, Integer.parseInt(board.getSquare(bestX, bestY).getPossibleValues().get(i).toString()));
            g.getBoard().generatePossibleValues();

            g.run();

            if(g.getBoard().missingCount() ==0){
                // found the winning board
                done = true;
                for (int x = 0; x <9; x++){
                    for (int y = 0; y<9; y++){
                        if(board.getValue(x,y) == 0){
                            board.setValue(x,y,g.getBoard().getValue(x,y));
                        }
                    }
                }
            }
        }
    }

}
