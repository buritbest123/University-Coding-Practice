public class MatrixSearcher {

    public static boolean binaryFind(int[][] matrix, int target) {
        /**
         * Search a 2-D array for a target value.
         * @param matrix : 2-D array.
         * @param searchtarget : Target value to search.
         * @return true if found and false if not found.
         */

        int rows = matrix.length; // 10 rows
        int cols = matrix.length; // 10 cols
        int start = 0;
        int end = rows * cols - 1; // 10 * 10 - 1 == 99
        int mid, midRow, midCol, midVal;

        while (start <= end) { // This while-loop will run 100 times because 0 <= 99
            // Split the 2DArray down the middle to two halves. | (0+99) / 2 = 49.5 only 49 (ignore the decimal part)
            mid = (start + end) / 2;
            // (4) = 49 / 10
            midRow = mid / cols;
            // (9) = 49 % 10
            midCol = mid % cols;
            // midval = matrix[4][9]
            midVal = matrix[midRow][midCol];

            if (midVal == target) {
                // Return true if target found
                // If the middle element is the target search element then search returns the element position.
                return true;

            } else if (midVal > target) {
                // If the target element is less than the middle element then search the first half of the 2DArray.
                end = mid - 1;

            } else {
                // if the target element is greater than the middle element then search the second half of the 2DArray.
                start = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args)
    // Entry point
    {
        int[][] matrix = {{1, 4, 4, 7, 8, 10, 10, 10, 11, 11},
                {12, 13, 14, 15, 15, 17, 17, 18, 18, 18},
                {18, 22, 23, 23, 24, 24, 24, 25, 27, 28},
                {28, 28, 29, 29, 29, 30, 31, 31, 32, 32},
                {32, 33, 33, 35, 36, 37, 38, 39, 39, 42},
                {42, 43, 43, 43, 44, 45, 49, 52, 52, 54},
                {54, 55, 55, 56, 58, 60, 60, 61, 62, 62},
                {64, 67, 68, 68, 70, 71, 72, 72, 73, 75},
                {76, 77, 78, 81, 81, 84, 84, 85, 86, 86},
                {86, 87, 90, 90, 91, 95, 96, 97, 97, 98}};


        System.out.println("Contains 55?:" + binaryFind(matrix, 55));
        System.out.println("Contains 1?:" + binaryFind(matrix, 1));
        System.out.println("Contains -1?:" + binaryFind(matrix, -1));
        System.out.println("Contains 98?:" + binaryFind(matrix, 98));
        System.out.println("Contains 100?:" + binaryFind(matrix, 100));
    }
}