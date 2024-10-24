package itcs209.labs.lab8;

import javax.swing.*;

public class Floor {
    private int row;
    private int column;
    private Obox[][] boxB;

    public Floor() {
        this.row = 7;
        this.column = 20;
        //floor = new char[this.row][this.column];
        boxB = new Obox[this.row][this.column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                //floor[i][j] = '_';
                boxB[i][j] = new Obox('_',i,j);
            }
        }
    }

    public boolean checkInBound(int row, int column) {
        boolean a;
        if (row >= 0 && column >= 0 && row < this.row && column < this.column) {
            a = true;
        } else {
            a = false;
        }

        return a;
    }
    public boolean addBox(int x,int y,char label){

                if(boxB[x][y].checkEmpty() && checkInBound(x,y)){
                    boxB[x][y].setLabel(label);
                    return true;
                }
                return  false;

    }
    public void printArray(){
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(boxB[i][j].getLabel());
            }
            System.out.println("");
        }
    }
}
