package org.mistahmilla.sudoku.solvers;
import org.mistahmilla.sudoku.org.mistahmilla.sudoku.board.Board;
import org.mistahmilla.sudoku.org.mistahmilla.sudoku.board.BoardSection;

import java.util.ArrayList;

public class SoleCandidateSolver implements Solver {

    private Board _board;

    public SoleCandidateSolver(Board board){
        _board = board;
    }

    public void Solve(){

        int changesMade;
        ArrayList candidates;
        BoardSection[] bs;

        do{
            changesMade = 0;

            for(int x = 0; x<9; x++) {
                for(int y=0; y<9; y++) {
                    candidates = new ArrayList();
                    populateCandidates(candidates);
                    bs = _board.getBoardSections(x,y);
                    removeValues(bs,candidates);
                    if(candidates.size() == 1){
                        _board.setValue(x,y,(Integer.parseInt(candidates.get(0).toString())));
                    }
                }
            }


        }while(changesMade >0);


    }

    private void populateCandidates(ArrayList c){
        for (int i = 1; i <=9; i++){
            c.add(i);
        }
    }

    private void removeValues(BoardSection[] sections, ArrayList candidates){
        for (int i = 0; i<sections.length; i++){
            for(int x = sections[i].getMinX(); x<=sections[i].getMaxX(); x++){
                for (int y = sections[i].getMinY(); y<=sections[i].getMaxY(); y++){
                    if (_board.getValue(x,y) != 0){
                        if(candidates.contains(_board.getValue(x, y))){
                            candidates.remove(new Integer(_board.getValue(x,y)));
                        }
                    }
                }
            }
        }
    }
}
