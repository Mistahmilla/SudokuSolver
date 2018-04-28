package org.mistahmilla.sudoku.solvers;

import org.mistahmilla.sudoku.board.*;

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

        //go through each square and identify squares that have the same
        for (int a = 1; a <=9; a++){
            for(int b = 1; b<=9; b++){
                if (a!=b) {
                    for (int i = 0; i < bs.length; i++) {
                        squares = new char[9][9];
                        section = bs[i];
                        count = 0;
                        for (int x = section.getMinX(); x < section.getMaxX(); x++) {
                            for (int y = section.getMinY(); y < section.getMaxY(); y++) {
                                if (board.getSquare(x, y).getPossibleValues().contains(Integer.valueOf(a))
                                        && board.getSquare(x, y).getPossibleValues().contains(Integer.valueOf(b))
                                        && board.getSquare(x, y).getPossibleValues().size() == 2) {
                                    squares[x][y] = 'x';
                                    count++;
                                }
                            }
                        }
                        if (count >= 2) {
                            for (int x = section.getMinX(); x < section.getMaxX(); x++) {
                                for (int y = section.getMinY(); y < section.getMaxY(); y++) {
                                    if (squares[x][y] != 'x') {
                                        board.getSquare(x, y).removePossibleValue(a);
                                        board.getSquare(x, y).removePossibleValue(b);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
