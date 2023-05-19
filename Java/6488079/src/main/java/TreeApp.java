import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.*;

public class TreeApp {
    public static void main(String[] args) {

        Tree theTree = new Tree();

        long preInsert = 0, postInsert = 0, time = 0;


        try(
                BufferedReader br = new BufferedReader(new FileReader("data.csv"));
                CSVParser parser = CSVFormat.DEFAULT.withDelimiter(',').withHeader().parse(br);
        ) {
            preInsert = System.nanoTime();
            for(CSVRecord best : parser) {
                theTree.insert(Integer.parseInt(best.get("admin3Pcode").replaceAll("\\D", "")), best.get("admin3Name_en"), best.get("admin2Name_en"), best.get("admin2Pcode"), best.get("admin1Name_en"), best.get("admin1Pcode"), best.get("admin0Name_en"), best.get("admin0Pcode"),  Double.parseDouble(best.get("Shape_Length")), Double.parseDouble(best.get("Shape_Area")));
            }
            postInsert = System.nanoTime();

        } catch (Exception e) {
            e.printStackTrace();
        }
        // Insertion
        time = postInsert - preInsert;
        System.out.println("Insertion: " + (time) + " ns");
        System.out.println("Calculated"+ "\n" +"----------");
        System.out.println("End time: " + postInsert + " ns");
        System.out.println("Start time: " + preInsert + " ns");
        System.out.println("Elapse time = End time - Start time = " + time);
        System.out.println("------------------------------------------------");

        // Searching
        long preSearch ;
        long postSearch;
        System.out.print("Searching ");
        preSearch = System.nanoTime();
        Node find = theTree.find(460303);
        postSearch = System.nanoTime();
        find.displayNode();
        Print_Calculation(preSearch, postSearch);
        System.out.println("------------------------------------------");

        // Deletion
        long preDel ;
        long postDel ;
        System.out.print("Deletion ");
        preDel = System.nanoTime();
        theTree.delete(460303);
        postDel = System.nanoTime();
        Print_Calculation(preDel, postDel);
    }

    private static void Print_Calculation(long preSearch, long postSearch) {
        long time;
        time = postSearch - preSearch;
        System.out.println(time + " ns");
        System.out.println("Calculated"+ "\n" +"----------");
        System.out.println("End time: " + postSearch + " ns");
        System.out.println("Start time: " + preSearch + " ns");
        System.out.println("Elapse time = End time - Start time = " + time);
    }
}