package org.mistahmilla.sudoku.org.mistahmilla.sudoku.board;

public class Board {

    BoardSquare[][] _board;
    BoardSection[] _boardSections;

    public Board(){
        _board = new BoardSquare[9][9];

        for (int y = 0; y<9; y++){
            for (int x = 0; x<9; x++){
                _board[x][y] = new BoardSquare(0);
            }
        }

        _boardSections = new BoardSection[27];

        for(int i = 0; i < 9; i++){
            _boardSections[i] = new BoardSection(0,8, i, i);
            _boardSections[i+9] = new BoardSection(i,i, 0, 8);
        }
        _boardSections[18] = new BoardSection(0, 2, 0, 2);
        _boardSections[19] = new BoardSection(3, 5, 0, 2);
        _boardSections[20] = new BoardSection(6, 8, 0, 2);
        _boardSections[21] = new BoardSection(0, 2, 3, 5);
        _boardSections[22] = new BoardSection(3, 5, 3, 5);
        _boardSections[23] = new BoardSection(6, 8, 3, 5);
        _boardSections[24] = new BoardSection(0, 2, 6, 8);
        _boardSections[25] = new BoardSection(3, 5, 6, 8);
        _boardSections[26] = new BoardSection(6, 8, 6, 8);
    }

    public Board(String Values) {
        this();
        String[] vals;
        int i;
        vals = Values.split(",");
        i = 0;
        for (int y = 0; y < 9; y++){
            for (int x = 0; x<9; x++){
                if (!vals[i].equals("")) {
                    this.setValue(x, y, Integer.parseInt(vals[i].trim()));
                }
                i++;
            }
        }
    }

    public void setValue(int posX, int posY, int value){
        _board[posX][posY].setValue(value);

/*        //after setting a value, update the possible values
        BoardSection[] b = getBoardSections(posX, posY);
        for(int i = 0; i < b.length; i++){
            for (int x = b[i].getMinX(); x <= b[i].getMaxX(); x++){
                for (int y = b[i].getMinY(); y <= b[i].getMaxY(); y++){
                    getSquare[x][y].removePossibleValue(value);
                }
            }
        }*/
    }

    public int getValue(int posX, int posY){
        return _board[posX][posY].getValue();
    }

    public boolean hasValue(int posX, int posY){
        if(getValue(posX, posY)!= 0){
            return true;
        }
        return false;
    }

    public BoardSquare getSquare(int posX, int posY){
        return _board[posX][posY];
    }

    // return false if the value can't go there, else true
    public boolean validValue(int x, int y, int val){
        BoardSection[] bs;
        if(getValue(x, y) != 0){
            return false;
        }
        bs = getBoardSections(x, y);

        for (int i = 0; i<bs.length; i++){
            for (int x2 = bs[i].getMinX(); x2 <= bs[i].getMaxX(); x2++) {
                for (int y2 = bs[i].getMinY(); y2 <= bs[i].getMaxY(); y2++) {
                    if (getValue(x2, y2) == val){
                        return false;
                    }
                }
            }
        }

        //check column
        //for (int i = 0; i < 9; i++){
        //    if (getValue(i, y) == val && i != y){
        //        return false;
        //    }
        //}
        return true;
    }

    public String toString(){
        String s;
        s = "";
        for (int y = 0; y<9; y++){
            if (y%3==0){
                s += "-------------\n";
            }
            for (int x = 0; x<9; x++){
                if(x%3==0){
                    s += "|";
                }
                s += getValue(x, y);
            }
            s = s+"|\n";
        }
        s += "-------------";
        return s;
    }

    public String toCSV(){
        String s;
        s = "";
        for (int y = 0; y<9; y++){
            for (int x = 0; x<9; x++){
                if (!(y==0 && x ==0)) {
                    s = s + ",";
                }
                s = s + getValue(x, y);
            }
        }
        return s;
    }

    public int missingCount(){
        int i;
        i =0;
        for (int y = 0; y<9; y++){
            for (int x = 0; x<9; x++) {
                if (getValue(x, y) == 0) {
                    i++;
                }
            }
        }
        return i;
    }

    public BoardSection[] getBoardSections(){
        return _boardSections;
    }

    public BoardSection[] getBoardSections(int x, int y){
        BoardSection[] bs = new BoardSection[3];
        int pos;
        pos = 0;
        for(int i = 0; i<_boardSections.length; i++){
            if (x >=_boardSections[i].getMinX() && x<=_boardSections[i].getMaxX() && y >=_boardSections[i].getMinY() && y<=_boardSections[i].getMaxY()){
                bs[pos] = _boardSections[i];
                pos++;
            }
        }
        return bs;
    }

    public BoardSection[] getBoardSection(BoardSectionType type){
        BoardSection[] bs = new BoardSection[9];
        int pos;
        pos = 0;
        for(int i = 0; i<_boardSections.length; i++){
            if(_boardSections[i].getMaxY()-_boardSections[i].getMinY() == type.getHeight()){
                bs[pos] = _boardSections[i];
                pos++;
            }
        }
        return bs;
    }
}