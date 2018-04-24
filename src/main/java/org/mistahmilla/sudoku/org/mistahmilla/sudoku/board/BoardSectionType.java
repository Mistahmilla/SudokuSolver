package org.mistahmilla.sudoku.org.mistahmilla.sudoku.board;

public enum BoardSectionType {
    ROW(1), COLUMN(9), SQUARE(3);
    private final int _height;

    BoardSectionType(int height){
        this._height = height;
    }

    public int getHeight(){
        return _height;
    }
}
