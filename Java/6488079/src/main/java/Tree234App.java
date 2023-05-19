import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.*;

public class Tree234App {
    public static void main(String[] args) throws IOException {

        Tree234 tree = new Tree234();
        long preInsert = 0, postInsert = 0, time = 0;

        try(
                CSVParser psr = CSVFormat.DEFAULT.withDelimiter(',').withHeader().parse(new BufferedReader(new FileReader("data.csv")));
        ) {
            preInsert = System.nanoTime();
            for(CSVRecord recor : psr) {
                long code = Integer.parseInt(recor.get("admin3Pcode").replaceAll("\\D", ""));
                tree.insert(recor.get("admin3Name_en"),code,recor.get("admin2Name_en"),recor.get("admin2Pcode"),recor.get("admin1Name_en"),recor.get("admin1Pcode"),  recor.get("admin0Name_en"), recor.get("admin0Pcode"), Double.parseDouble(recor.get("Shape_Length")),  Double.parseDouble(recor.get("Shape_Area")));
            }
            postInsert = System.nanoTime();
            time = postInsert - preInsert;
        } catch (Exception e) {
            e.printStackTrace();
        }
        tree.displayTree();

        // Insertion
        System.out.println("Insert: " +time + " ns");
        System.out.println("Calculated"+ "\n" +"----------");
        System.out.println("End time: " + postInsert + " ns");
        System.out.println("Start time: " + preInsert + " ns");
        System.out.println("Elapse time = End time - Start time = " + time);
        System.out.println("------------------------------------------------");

        // Searching
        long preSearch = 0, postSearch = 0;
        System.out.print("Find: ");
        preSearch = System.nanoTime();
        int find = tree.find(460303);
        postSearch = System.nanoTime();
        time = postSearch - preSearch;
        System.out.println((time) + " ns");
        System.out.println("Calculated"+ "\n" +"----------");
        System.out.println("End time: " + postSearch + " ns");
        System.out.println("Start time: " + preSearch + " ns");
        System.out.println("Elapse time = End time - Start time = " + time);
    }
}
