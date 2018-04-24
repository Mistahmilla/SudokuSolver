package org.mistahmilla.sudoku.org.mistahmilla.sudoku.board;

import java.util.ArrayList;

public class BoardSquare {

    private int _value;
    private ArrayList _possibleValues;

    public BoardSquare(){
        _value = 0;
        _possibleValues = new ArrayList();
    }

    public BoardSquare(int value){
        this();
        _value = value;
    }

    public void addPossibleValue(int value){
        if(!_possibleValues.contains(value)){
            _possibleValues.add(value);
        }
    }

    public void removePossibleValue(int value){
        if(_possibleValues.contains(value)){
            _possibleValues.remove(new Integer(value));
        }
    }

    public void setValue(int value){
        _value = value;
    }

    public int getValue(){
        return _value;
    }

    public ArrayList getPossibleValues(){
        return _possibleValues;
    }
}
