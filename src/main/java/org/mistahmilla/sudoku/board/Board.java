package org.mistahmilla.sudoku.board;

public class Board {

    BoardSquare[][] boardSquares;
    BoardSection[] boardSections;

    public Board(){
        boardSquares = new BoardSquare[9][9];

        for (int y = 0; y<9; y++){
            for (int x = 0; x<9; x++){
                boardSquares[x][y] = new BoardSquare(0);
            }
        }

        boardSections = new BoardSection[27];

        for(int i = 0; i < 9; i++){
            boardSections[i] = new BoardSection(0,8, i, i, BoardSectionType.ROW);
            boardSections[i+9] = new BoardSection(i,i, 0, 8, BoardSectionType.COLUMN);
        }
        boardSections[18] = new BoardSection(0, 2, 0, 2, BoardSectionType.SQUARE);
        boardSections[19] = new BoardSection(3, 5, 0, 2, BoardSectionType.SQUARE);
        boardSections[20] = new BoardSection(6, 8, 0, 2, BoardSectionType.SQUARE);
        boardSections[21] = new BoardSection(0, 2, 3, 5, BoardSectionType.SQUARE);
        boardSections[22] = new BoardSection(3, 5, 3, 5, BoardSectionType.SQUARE);
        boardSections[23] = new BoardSection(6, 8, 3, 5, BoardSectionType.SQUARE);
        boardSections[24] = new BoardSection(0, 2, 6, 8, BoardSectionType.SQUARE);
        boardSections[25] = new BoardSection(3, 5, 6, 8, BoardSectionType.SQUARE);
        boardSections[26] = new BoardSection(6, 8, 6, 8, BoardSectionType.SQUARE);
    }

    public Board(String values) {
        this();
        String[] vals;
        int i;
        vals = values.split(",");

        if(vals.length != 81){
            throw new IllegalArgumentException("Board must contain exactly 81 spaces");
        }

        i = 0;
        for (int y = 0; y < 9; y++){
            for (int x = 0; x<9; x++){
                if (!vals[i].equals("")) {
                    this.setValue(x, y, Integer.parseInt(vals[i].trim()));
                }
                i++;
            }
        }

        if (!isValid()){
            throw new IllegalArgumentException("Board is not valid");
        }
    }

    public void setValue(int posX, int posY, int value){
        boardSquares[posX][posY].setValue(value);
    }

    public int getValue(int posX, int posY){
        return boardSquares[posX][posY].getValue();
    }

    public boolean hasValue(int posX, int posY){
        return getValue(posX, posY)!= 0;
    }

    public BoardSquare getSquare(int posX, int posY){
        return boardSquares[posX][posY];
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
        return true;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();

        for (int y = 0; y<9; y++){
            if (y%3==0){
                sb.append( "-------------\n");
            }
            for (int x = 0; x<9; x++){
                if(x%3==0){
                    sb.append("|");
                }
                sb.append(getValue(x, y));
            }
            sb.append("|\n");
        }
        sb.append("-------------");
        return sb.toString();
    }

    public String toCSV(){
        StringBuilder sb = new StringBuilder();

        for (int y = 0; y<9; y++){
            for (int x = 0; x<9; x++){
                if (!(y==0 && x ==0)) {
                    sb.append(",");
                }
                sb.append(getValue(x, y));
            }
        }
        return sb.toString();
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
        return boardSections;
    }

    public BoardSection[] getBoardSections(int x, int y){
        BoardSection[] bs = new BoardSection[3];
        int pos;
        pos = 0;
        for(int i = 0; i< boardSections.length; i++){
            if (x >= boardSections[i].getMinX() && x<= boardSections[i].getMaxX()
                    && y >= boardSections[i].getMinY() && y<= boardSections[i].getMaxY()){
                bs[pos] = boardSections[i];
                pos++;
            }
        }
        return bs;
    }

    public BoardSection[] getBoardSection(BoardSectionType type){
        BoardSection[] bs = new BoardSection[9];
        int pos;
        pos = 0;
        for(int i = 0; i< boardSections.length; i++){
            if(boardSections[i].getMaxY()- boardSections[i].getMinY() == type.getHeight()){
                bs[pos] = boardSections[i];
                pos++;
            }
        }
        return bs;
    }

    public void generatePossibleValues(){

        for (int x= 0; x<9; x++){
            for (int y = 0; y<9; y++){
                getSquare(x, y).removeAllPossibleValues();
                if(!hasValue(x, y)){
                    for(int i = 1; i<=9; i++) {
                        if(validValue(x, y, i)){
                            getSquare(x, y).addPossibleValue(i);
                        }
                    }
                }
            }
        }

    }

    public boolean isValid(){
        //check that each section only has one of each number

        int[] valueCount = new int[9];

        for (int i = 0; i < boardSections.length; i++){
            for (int v = 0; v<valueCount.length; v++){
                valueCount[v] = 0;
            }

            for (int x = boardSections[i].getMinX(); x <= boardSections[i].getMaxX(); x++){
                for (int y = boardSections[i].getMinY(); y <= boardSections[i].getMaxY(); y++){
                    if(getValue(x, y) != 0){
                        valueCount[getValue(x, y)-1]++;
                    }
                }
            }

            for (int v = 0; v<valueCount.length; v++){
                if (valueCount[v] > 1){
                    return false;
                }
            }
        }

        return true;
    }
}
