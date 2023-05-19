package itcs209.labs.lab8;

import java.util.Scanner;

public class Obox {
    private int x;
    private int y;
    private char label;

    public Obox(char label,int x,int y){
        this.label = label;
        this.x = x;
        this.y = y;
    }
    public boolean checkEmpty(){
        if(label == '_'){
            return true;
        }
        return false;
    }
    public void setLabel(char label){
        this.label = label;
    }
    public char getLabel(){
        return label;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }




}
