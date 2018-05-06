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
        int count;
        ArrayList candidateList;

        //go through each square and identify squares that have the same
        for (int a = 1; a <=9; a++){
            for(int b = 1; b<=9; b++){
                candidateList = new ArrayList();
                candidateList.add(a);
                candidateList.add(b);
                if (a!=b) {
                    for (int i = 0; i < bs.length; i++) {
                        squares = new char[9][9];
                        section = bs[i];
                        count = 0;
                        for (int x = section.getMinX(); x <= section.getMaxX(); x++) {
                            for (int y = section.getMinY(); y <= section.getMaxY(); y++) {
                                if (board.getSquare(x, y).getPossibleValues().contains(Integer.valueOf(a))
                                        && board.getSquare(x, y).getPossibleValues().contains(Integer.valueOf(b))
                                        && board.getSquare(x, y).getPossibleValues().size() == 2) {
                                    squares[x][y] = 'x';
                                    count++;
                                }
                            }
                        }
                        if (count >= 2) {
                            removeCandidates(squares, candidateList,section);
                        }

                        for (int c = 1; c<=9; c++){
                            if(a!=c && b!=c){
                                candidateList.add(c);
                                squares = new char[9][9];
                                section = bs[i];
                                count = 0;
                                for (int x = section.getMinX(); x <= section.getMaxX(); x++) {
                                    for (int y = section.getMinY(); y <= section.getMaxY(); y++) {
                                        if (board.getSquare(x, y).getPossibleValues().contains(Integer.valueOf(a))
                                                && board.getSquare(x, y).getPossibleValues().contains(Integer.valueOf(b))
                                                && board.getSquare(x, y).getPossibleValues().contains(Integer.valueOf(c))
                                                && board.getSquare(x, y).getPossibleValues().size() == 3) {
                                            squares[x][y] = 'x';
                                            count++;
                                        }
                                    }
                                }
                                if (count >= 3) {
                                    removeCandidates(squares, candidateList,section);
                                }
                                candidateList.remove(Integer.valueOf(c));
                            }

                        }
                    }

                }


            }
        }
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
