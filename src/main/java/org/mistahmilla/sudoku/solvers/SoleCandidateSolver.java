package org.mistahmilla.sudoku.solvers;
import org.mistahmilla.sudoku.board.Board;
import org.mistahmilla.sudoku.board.BoardSection;

import java.util.ArrayList;

public class SoleCandidateSolver implements Solver {

    private Board board;

    public SoleCandidateSolver(Board board){
        this.board = board;
    }

    public void solve(){

        int changesMade;
        ArrayList candidates;
        BoardSection[] bs;

        do{
            changesMade = 0;

            for(int x = 0; x<9; x++) {
                for(int y=0; y<9; y++) {
                    candidates = new ArrayList();
                    populateCandidates(candidates);
                    bs = board.getBoardSections(x,y);
                    removeValues(bs,candidates);
                    if(candidates.size() == 1 && board.getValue(x,y) == 0){
                        board.setValue(x,y,(Integer.parseInt(candidates.get(0).toString())));
                        changesMade++;
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
                    if (board.getValue(x,y) != 0 && candidates.contains(board.getValue(x, y))){
                        candidates.remove(Integer.valueOf(board.getValue(x,y)));
                    }
                }
            }
        }
    }
}
