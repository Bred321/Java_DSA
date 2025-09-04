package Practices.Others;

public class Kadane_Algorithm {
    public static void main(String[] args){
        int[] arr = {-2, 5, -1, 4, -3, 2, -5, 3};
        System.out.println(maxStrengthPower(arr));
    }

    static int maxStrengthPower(int[] items) {
        int maxSoFar = items[0];
        int maxEndingHere = items[0];

        for (int i = 1; i < items.length; i++) {
            maxEndingHere = Math.max(items[i], maxEndingHere + items[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }

}
