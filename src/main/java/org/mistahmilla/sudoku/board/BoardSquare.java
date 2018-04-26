package org.mistahmilla.sudoku.board;

import java.util.ArrayList;
import java.util.List;

public class BoardSquare {

    private int value;
    private ArrayList possibleValues;

    public BoardSquare(){
        value = 0;
        possibleValues = new ArrayList();
    }

    public BoardSquare(int value){
        this();
        this.value = value;
    }

    public void addPossibleValue(int value){
        if(!possibleValues.contains(value)){
            possibleValues.add(value);
        }
    }

    public void removePossibleValue(int value){
        if(possibleValues.contains(value)){
            possibleValues.remove(Integer.valueOf(value));
        }
    }

    public void removeAllPossibleValues(){
        possibleValues = new ArrayList();
    }

    public void setValue(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }

    public List getPossibleValues(){
        return possibleValues;
    }
}
