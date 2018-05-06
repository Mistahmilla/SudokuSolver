package org.mistahmilla.sudoku.solvers;

import org.mistahmilla.sudoku.board.*;

import java.util.ArrayList;

public class NakedSubset implements NoteEliminator {

    Board board;

    public NakedSubset (Board board){
        this.board = board;
    }

    public void eliminate(){
        char[][] squares;
        BoardSection[] bs = board.getBoardSections();
        BoardSection section;
        ArrayList candidateList;

        //go through each square and identify squares that have the same
        for (int a = 1; a <=9; a++){
            for(int b = 1; b<=9; b++){
                candidateList = new ArrayList();
                candidateList.add(a);
                candidateList.add(b);
                if (a==b) {
                    continue;
                }

                for (int i = 0; i < bs.length; i++) {
                    squares = new char[9][9];
                    section = bs[i];

                    if (checkCandidates(squares, candidateList, section) >= 2) {
                        removeCandidates(squares, candidateList,section);
                    }

                    for (int c = 1; c<=9; c++){
                        if(a==c || b==c) {
                            continue;
                        }

                        candidateList.add(c);
                        squares = new char[9][9];
                        section = bs[i];
                        if (checkCandidates(squares, candidateList, section) >= 3) {
                            removeCandidates(squares, candidateList,section);
                        }
                        candidateList.remove(Integer.valueOf(c));
                    }
                }
            }
        }
    }

    int checkCandidates(char[][] squares, ArrayList candidates, BoardSection s){
        int count = 0;
        boolean b;
        for (int x = s.getMinX(); x <= s.getMaxX(); x++) {
            for (int y = s.getMinY(); y <= s.getMaxY(); y++) {
                b = true;
                for (int i = 0; i < candidates.size(); i ++){
                    if(!board.getSquare(x, y).getPossibleValues().contains(candidates.get(i))){
                        b = false;
                    }
                }
                if (b && board.getSquare(x, y).getPossibleValues().size() == candidates.size()) {
                    squares[x][y] = 'x';
                    count++;
                }
            }
        }
        return count;
    }

    void removeCandidates(char[][] squares, ArrayList candidates, BoardSection s){
        for (int x = s.getMinX(); x<=s.getMaxX(); x++){
            for (int y = s.getMinY(); y<=s.getMaxY(); y++){
                if (squares[x][y] != 'x'){
                    for (int i = 0; i < candidates.size(); i++) {
                        board.getSquare(x, y).removePossibleValue(Integer.parseInt(candidates.get(i).toString()));
                    }
                }
            }
        }
    }
}
