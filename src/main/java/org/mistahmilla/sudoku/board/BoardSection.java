package org.mistahmilla.sudoku.board;

public class BoardSection {

    private int minX;
    private int maxX;
    private int minY;
    private int maxY;
    private BoardSectionType sectionType;

    public BoardSection(int minX, int maxX, int minY, int maxY, BoardSectionType sectionType){
        this.minX = minX;
        this.maxX = maxX;
        this.minY = minY;
        this.maxY = maxY;
        this.sectionType = sectionType;
    }

    public int getMinX(){
        return minX;
    }

    public int getMaxX(){
        return maxX;
    }

    public int getMinY(){
        return minY;
    }

    public int getMaxY(){
        return maxY;
    }

    public BoardSectionType getBoardSectionType(){
        return sectionType;
    }
}
