package Week_1;
public class problem2_find_missing_num {
    public static void main(String[] args){
        int[] arr = {0, 1, 2, 3, 4, 5};
        int n = arr.length;
        int full_sum = n * (n + 1) / 2;
        int miss_sum = 0;
        for(int i: arr){
            miss_sum += i;
        }
        if (full_sum == miss_sum) {
            System.out.println("Missing number is:" + 0);
        } else {
            System.out.println("Missing number is:" + (full_sum - miss_sum));
        }
    }
}

// Pseudocode:
// 1. Initialize an array with numbers from 0 to n.
// 2. Calculate the expected sum of numbers from 0 to n using the formula n * (n + 1) / 2.
// 3. Initialize a variable to hold the sum of the numbers in the array.    
// 4. Iterate through the array and add each number to the sum variable.
// 5. Compare the expected sum with the actual sum.
// 6. If they are equal, print that the missing number is 0.
// 7. If they are not equal, print the difference as the missing number.
// 8. End.