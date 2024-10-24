import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;

public class HashChainApp {

    public static void main(String[] args) throws FileNotFoundException {
        int count = 7425;

        HashTable hc = new HashTable(count);
        long preInsert = 0, postInsert = 0, time = 0;

        // Insertion
        try(
                CSVParser parser = CSVFormat.DEFAULT.withDelimiter(',').withHeader().parse(new BufferedReader(new FileReader("data.csv")));
        ) {
            preInsert = System.nanoTime();
            for(CSVRecord record : parser) {
                int pCode = Integer.parseInt(record.get("admin3Pcode").replaceAll("\\D", ""));
                hc.insert(new Link(record.get("admin3Name_en"),pCode, record.get("admin2Name_en"),record.get("admin2Pcode"), record.get("admin1Name_en"),  record.get("admin1Pcode"), record.get("admin0Name_en"), record.get("admin0Pcode"), Double.parseDouble(record.get("Shape_Length")), Double.parseDouble(record.get("Shape_Area"))));
            }
            postInsert = System.nanoTime();


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        hc.displayTable();
        time = postInsert - preInsert;
        System.out.println("Insertion: " + (time)  + "ns");
        System.out.println("Calculated"+ "\n" +"----------");
        System.out.println("End time: " + postInsert + " ns");
        System.out.println("Start time: " + preInsert + " ns");
        System.out.println("Elapse time = End time - Start time = " + time);
        System.out.println("------------------------------------------------");


        // Searching
        System.out.print("Found ");
        long preFind = 0;
        long postFind = 0;
        preFind = System.nanoTime();
        hc.find(460303);
        postFind = System.nanoTime();

        time = postFind - preFind;
        System.out.println("Searching: "  + (time) + "ns");
        System.out.println("Calculated"+ "\n" +"----------");
        System.out.println("End time: " + postFind + " ns");
        System.out.println("Start time: " + preFind + " ns");
        System.out.println("Elapse time = End time - Start time = " + time);
        System.out.println("------------------------------------------------");


        // Deletion
        long preDel;
        long postDel;

        preDel = System.nanoTime();
        hc.delete(460303);
        postDel = System.nanoTime();

        time = postDel - preDel;
        System.out.println("Deletion: " + time + "ns");
        System.out.println("Calculated"+ "\n" +"----------");
        System.out.println("End time: " + postDel + " ns");
        System.out.println("Start time: " + preDel + " ns");
        System.out.println("Elapse time = End time - Start time = " + time);
        System.out.println("------------------------------------------------");
    }
}
