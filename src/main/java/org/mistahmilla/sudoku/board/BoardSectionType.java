package org.mistahmilla.sudoku.board;

public enum BoardSectionType {
    ROW(1), COLUMN(9), SQUARE(3);
    private final int height;

    BoardSectionType(int height){
        this.height = height;
    }

    public int getHeight(){
        return height;
    }
}
