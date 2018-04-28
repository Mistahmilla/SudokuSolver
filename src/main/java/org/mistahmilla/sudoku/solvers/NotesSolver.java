package org.mistahmilla.sudoku.solvers;
import org.mistahmilla.sudoku.board.Board;

public class NotesSolver implements Solver{

    private Board board;

    public NotesSolver(Board board){
        this.board = board;
    }

    public void solve(){
        NakedSubset ns = new NakedSubset(board);
        generatePossibleValues();
        ns.eliminate();
        checkBoard();
    }

    public void checkBoard(){
        int changed;

        do {
            changed = 0;
            for (int x = 0; x < 9; x++) {
                for (int y = 0; y < 9; y++) {
                    if (board.getSquare(x, y).getPossibleValues().size() == 1) {
                        board.setValue(x, y, Integer.parseInt(board.getSquare(x, y).getPossibleValues().get(0).toString()));
                        changed++;
                    }
                }
            }
        }while(changed>0);
    }

    void generatePossibleValues(){
        for (int x= 0; x<9; x++){
            for (int y = 0; y<9; y++){
                if(!board.hasValue(x, y)){
                    for(int i = 1; i<=9; i++) {
                        if(board.validValue(x, y, i)){
                            board.getSquare(x, y).addPossibleValue(i);
                        }
                    }
                }
            }
        }

    }

}