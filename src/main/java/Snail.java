import java.util.ArrayList;
import java.util.List;

public class Snail {
    public static void main(String[] args) {
        int[][] z = new int[][] {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };
        flattenSnail(z);
    }

    public static int[] flattenSnail(int[][] array2d) {
        int[] emptyArray = new int[0];
        if (array2d == null || !isPerfectSquare(array2d)) {
            return emptyArray;
        }

        List<Integer> snailList = new ArrayList<>();
        int row = 0;
        int col = 0;
        int rowCount = array2d.length;
        int colCount = array2d[0].length;

        while (snailList.size() < array2d.length * array2d[0].length) {
            for (int i = 0; i < colCount; i++) {
                snailList.add(array2d[row][col]);
                col++;
            }
            col--;
            row++;
            colCount--;

            for (int i = 0; i < rowCount - 1; i++) {
                snailList.add(array2d[row][col]);
                row++;
            }
            row--;
            col--;
            rowCount--;

            for (int i = 0; i < colCount; i++) {
                snailList.add(array2d[row][col]);
                col--;
            }
            col++;
            row--;
            colCount--;

            for (int i = 0; i < rowCount - 2; i++) {
                snailList.add(array2d[row][col]);
                row--;
            }
            row++;
            col++;
            rowCount--;
        }

        int[] snailArray = snailList.stream().mapToInt(Integer::intValue).toArray();
        return snailArray;
    }

    public static int[][] makeSnail(int[] array1d) {
        int[][] emptyArray = new int[0][0];
        if (array1d == null || !isPerfectSquare(array1d)) {
            return emptyArray;
        }

        int size = (int) Math.sqrt(array1d.length);
        int[][] snailArray = new int[size][size];
        int row = 0;
        int col = 0;
        int rowCount = size;
        int colCount = size;
        int index = 0;

        while (index < array1d.length) {
            for (int i = 0; i < colCount; i++) {
                snailArray[row][col] = array1d[index];
                col++;
                index++;
            }
            col--;
            row++;
            colCount--;

            for (int i = 0; i < rowCount - 1; i++) {
                snailArray[row][col] = array1d[index];
                row++;
                index++;
            }
            row--;
            col--;
            rowCount--;

            for (int i = 0; i < colCount; i++) {
                snailArray[row][col] = array1d[index];
                col--;
                index++;
            }
            col++;
            row--;
            colCount--;

            for (int i = 0; i < rowCount - 2; i++) {
                snailArray[row][col] = array1d[index];
                row--;
                index++;
            }
            row++;
            col++;
            rowCount--;
        }

        return snailArray;
    }

    private static boolean isPerfectSquare(int[][] array2d) {
        int length = array2d.length;
        return Math.sqrt(length) % 1 == 0;
    }

    private static boolean isPerfectSquare(int[] array1d) {
        int length = array1d.length;
        return Math.sqrt(length) % 1 == 0;
    }
}