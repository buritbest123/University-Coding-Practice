import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.*;

public class HashDoubleApp {
    public static void main(String[] args) throws IOException, FileNotFoundException {

        int count = 7425;
        long preInsert = 0;
        long postInsert = 0;

        HashDoubleTable hash = new HashDoubleTable(count);

        try(
                BufferedReader bread = new BufferedReader(new FileReader("data.csv"));
                CSVParser parse = CSVFormat.DEFAULT.withDelimiter(',').withHeader().parse(bread);
        ) {
            preInsert = System.nanoTime();
            for(CSVRecord recor : parse) {
                hash.insert(count++, new DataItem(recor.get("admin3Name_en"), Integer.parseInt(recor.get("admin3Pcode").replaceAll("\\D", "")), recor.get("admin2Name_en"),  recor.get("admin2Pcode"), recor.get("admin1Name_en"), recor.get("admin1Pcode"), recor.get("admin0Name_en"), recor.get("admin0Pcode"), Double.parseDouble(recor.get("Shape_Length")), Double.parseDouble(recor.get("Shape_Area"))));
            }
            postInsert = System.nanoTime();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Insertion
        hash.displayTable();
        System.out.println("Insertion: " + (postInsert - preInsert) + " ns");
        System.out.println("Calculated"+ "\n" +"----------");
        System.out.println("End time: " + postInsert + " ns");
        System.out.println("Start time: " + preInsert + " ns");
        System.out.println("Elapse time = End time - Start time = " + (postInsert - preInsert));
        System.out.println("------------------------------------------------");

        // Searching
        long postSearch, preSearch;
        preSearch = System.nanoTime();
        DataItem temp = hash.find(460303);
        postSearch = System.nanoTime();
        System.out.println("Searching: "+ (postSearch - preSearch) + " ns");
        Print_Calculation(postSearch, preSearch);

        // Deletion
        long preDel = 0, postDel = 0;
        preDel = System.nanoTime();
        hash.delete(460303);
        postDel = System.nanoTime();
        System.out.println("Deletion: "+ (postDel - preDel) + " ns");

        Print_Calculation(postDel, preDel);

    }

    private static void Print_Calculation(long postSearch, long preSearch) {
        System.out.println("Calculated"+ "\n" +"----------");
        System.out.println("End time: " + postSearch + " ns");
        System.out.println("Start time: " + preSearch + " ns");
        System.out.println("Elapse time = End time - Start time = " + (postSearch - preSearch));
        System.out.println("------------------------------------------------");
    }
}