// Given an array of numbers (array size >= 2), find two in the array whose sum is closest to zero.

// What is the complexity of your algorithm?

// Example 1: [2, 3, 9, 6] => 2 and 3

// Example 2: [-100, 50, -52, 99] => -100 and 99
public class problem_4_find_closest{
    public static void main(String[] args){
        int[] arr1 = {2, 3, 9, 6};
        int[] arr2 = {-100, 50, -52, 99};

        System.out.println(findClosest(arr1)); // Output: 2 and 3
        System.out.println(findClosest(arr2)); // Output: -100 and 99
    }

    public static String findClosest(int[] arr){
        int n = arr.length;
        if (n < 2){
            return "Array must contain at least two elements.";
        }

        int minSum = Integer.MAX_VALUE;
        int[] closestPair = new int[2];

        for(int i = 0; i < n - 1; i++){
            for(int j= i + 1; j < n; j++){
                int sum = arr[i] + arr[j];
                if (Math.abs(sum) < Math.abs(minSum)){
                    minSum = sum;
                    closestPair[0] = arr[i];
                    closestPair[1] = arr[j];
                }
            }
        }

        return closestPair[0] + " and " + closestPair[1];
    }
}