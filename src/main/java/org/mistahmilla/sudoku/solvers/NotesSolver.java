package org.mistahmilla.sudoku.solvers;
import org.mistahmilla.sudoku.*;

public class NotesSolver implements Solver{

    private Board _board;

    public NotesSolver(Board board){
        _board = board;
    }

    public void Solve(){
        generatePossibleValues();
        // TODO: 4/23/2018 add functionality for notes solver
        checkBoard();
    }

    public void checkBoard(){
        int changed;

        do {
            changed = 0;
            for (int x = 0; x < 9; x++) {
                for (int y = 0; y < 9; y++) {
                    if (_board.getSquare(x, y).getPossibleValues().size() == 1) {
                        _board.setValue(x, y, Integer.parseInt(_board.getSquare(x, y).getPossibleValues().get(0).toString()));
                        changed++;
                    }
                }
            }
        }while(changed>0);
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
