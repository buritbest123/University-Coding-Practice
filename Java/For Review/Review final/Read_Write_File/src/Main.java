import java.io.*;

class Main{
    public static void main(String[] args){
        File f = new File("Demo.txt"); // Create file named "Demo.txt"
        try {
            FileWriter writer = new FileWriter(f); // Begin to write sth. in "Demo.txt"
            FileWriter writer2 = new FileWriter(new File("Score.txt")); // Create file named "Score.txt" and begin to write sth. in "Demo.txt"
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}