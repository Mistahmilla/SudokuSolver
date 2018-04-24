package org.mistahmilla.sudoku.solvers;
import org.mistahmilla.sudoku.*;

public class BestGuessSolver implements Solver {

    private Board _board;

    public BestGuessSolver(Board board){
        _board = board;
    }

    public void Solve(){
        generatePossibleValues();
        int bestX;
        int bestY;
        int fewest;
        boolean done;
        Game g;

        done = false;
        bestX = 0;
        bestY = 0;
        fewest = 9;

        for (int x = 0; x <9; x++){
            for (int y = 0; y<9; y++){
                if(_board.getSquare(x, y).getPossibleValues().size() < fewest && _board.getSquare(x, y).getPossibleValues().size() != 0){
                    bestX = x;
                    bestY = y;
                    fewest = _board.getSquare(x, y).getPossibleValues().size();
                }
            }
        }

        // create new games seeded off the possible numbers and try to solve them
        for (int i = 0; i < _board.getSquare(bestX, bestY).getPossibleValues().size() && !done; i++){
            g = new Game(_board.toCSV());
            g.getBoard().setValue(bestX, bestY, Integer.parseInt(_board.getSquare(bestX, bestY).getPossibleValues().get(i).toString()));
            g.run();

            if(g.getBoard().missingCount() ==0){
                // found the winning board
                done = true;
                for (int x = 0; x <9; x++){
                    for (int y = 0; y<9; y++){
                        if(_board.getValue(x,y) == 0){
                            _board.setValue(x,y,g.getBoard().getValue(x,y));
                        }
                    }
                }
            }
        }
    }

    void generatePossibleValues(){
        for (int x= 0; x<9; x++){
            for (int y = 0; y<9; y++){
                if(!_board.hasValue(x, y)){
                    for(int i = 1; i<=9; i++) {
                        if(_board.validValue(x, y, i)){
                            _board.getSquare(x, y).addPossibleValue(i);
                        }
                    }
                }
            }
        }

    }
}
