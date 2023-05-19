import java.util.Random;
import java.util.stream.IntStream;

public class Main {

    static void unknow(int nums[]){
        int n = nums.length;
        for (int i = 1; i < n; ++i){
            int key = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > key){
                nums[j + 1] = nums[j];
                j = j - 1;
            }
            nums[j + 1] = key;
        }
    }

    private static int[] revArr(int[] arr){
        int start = 0;
        int end = arr.length;
        return IntStream.range(start, end).map(i -> end-i + start-1).toArray();
    }

    private static int[] buildRandomArray(int n) {
        Random random = new Random();
        return IntStream.range(0, n).map(i -> random.nextInt(5000)).toArray();
    }

    private static void checkPerformance(int[] arr) {
        long start = System.nanoTime();
        //Code to measure performance
        long end = System.nanoTime();
        System.out.println("Time:" + (end - start) / 1000_000f + " ms ");
    }

    public static void main (String[] args) {
        int[] d1 = IntStream.range(0, 1000).toArray();
        int[] d2 = IntStream.range(0, 5000).toArray();
        int[] d3 = IntStream.range(0, 100000).toArray();

        checkPerformance(d3);
        checkPerformance(revArr(d3));
        checkPerformance(buildRandomArray(100000));
    }
}