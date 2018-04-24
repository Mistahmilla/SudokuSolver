package org.mistahmilla.sudoku.org.mistahmilla.sudoku.board;

public class BoardSection {

    private int _minX;
    private int _maxX;
    private int _minY;
    private int _maxY;

    public BoardSection(int minX, int maxX, int minY, int maxY){
        _minX = minX;
        _maxX = maxX;
        _minY = minY;
        _maxY = maxY;
    }

    public int getMinX(){
        return _minX;
    }

    public int getMaxX(){
        return _maxX;
    }

    public int getMinY(){
        return _minY;
    }

    public int getMaxY(){
        return _maxY;
    }
}
