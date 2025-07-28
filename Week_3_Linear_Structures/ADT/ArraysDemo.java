package Week_3_Linear_Structures.ADT;
import java.util.Arrays;

public class ArraysDemo {
    public static void main(String[] args) {
        // ===== Basic Initialization =====
        int[] numbers = {5, 2, 9, 1, 3};
        String[] words = {"dog", "cat", "bird"};

        // ===== sort(array) =====
        Arrays.sort(numbers);
        System.out.println("Sorted: " + Arrays.toString(numbers)); // [1, 2, 3, 5, 9]

        // ===== binarySearch(array, key) =====
        int index = Arrays.binarySearch(numbers, 3);
        System.out.println("Index of 3: " + index); // 2

        // ===== equals(array1, array2) =====
        int[] a = {1, 2, 3};
        int[] b = {1, 2, 3};
        System.out.println("Arrays equal: " + Arrays.equals(a, b)); // true

        // ===== fill(array, value) =====
        int[] filled = new int[5];
        Arrays.fill(filled, 7);
        System.out.println("Filled: " + Arrays.toString(filled)); // [7, 7, 7, 7, 7]

        // ===== copyOf(array, newLength) =====
        int[] copied = Arrays.copyOf(a, 5);
        System.out.println("copyOf: " + Arrays.toString(copied)); // [1, 2, 3, 0, 0]

        // ===== copyOfRange(array, from, to) =====
        int[] rangeCopy = Arrays.copyOfRange(a, 1, 3);
        System.out.println("copyOfRange: " + Arrays.toString(rangeCopy)); // [2, 3]

        // ===== toString(array) =====
        System.out.println("toString: " + Arrays.toString(words)); // [dog, cat, bird]

        // ===== deepEquals (for nested arrays) =====
        String[][] names1 = {{"Alice", "Bob"}, {"Carol"}};
        String[][] names2 = {{"Alice", "Bob"}, {"Carol"}};
        System.out.println("deepEquals: " + Arrays.deepEquals(names1, names2)); // true

        // ===== deepToString (for nested arrays) =====
        System.out.println("deepToString: " + Arrays.deepToString(names1)); // [[Alice, Bob], [Carol]]

        // ===== parallelSort (Java 8+) =====
        int[] big = {9, 7, 5, 3, 1, 2, 4, 6, 8};
        Arrays.parallelSort(big);
        System.out.println("parallelSort: " + Arrays.toString(big)); // [1, 2, 3, ..., 9]

        // ===== mismatch (Java 9+) =====
        int[] x = {1, 2, 3};
        int[] y = {1, 2, 4};
        int mismatchIndex = Arrays.mismatch(x, y);
        System.out.println("mismatch: " + mismatchIndex); // 2
    }
}
