package org.mistahmilla.sudoku.solvers;
import org.mistahmilla.sudoku.board.Board;
import org.mistahmilla.sudoku.board.BoardSection;

public class UniqueCandidateSolver implements Solver{

    private Board board;

    public UniqueCandidateSolver(Board board){
        this.board = board;
    }

    public void solve(){
        int trueCount;
        int validX;
        int validY;
        int changesMade;
        BoardSection[] boardSections;
        BoardSection bs;

        boardSections = board.getBoardSections();
        do {
            validX = 0;
            validY = 0;
            changesMade = 0;
            trueCount = 0;
            //check each board section for a number that only has one valid spot
            for (int i = 1; i <= 9; i++){
                for (int a=0; a<boardSections.length; a++){
                    bs = boardSections[a];
                    for (int x = bs.getMinX(); x <= bs.getMaxX(); x++) {
                        for (int y = bs.getMinY(); y <= bs.getMaxY(); y++) {
                            if (board.validValue(x, y, i)) {
                                trueCount++;
                                validX = x;
                                validY = y;
                            }
                        }
                    }
                    if (trueCount == 1) {
                        board.setValue(validX, validY, i);
                        changesMade++;
                    }
                    trueCount = 0;
                }
            }
        }while(changesMade != 0);


    }

}
