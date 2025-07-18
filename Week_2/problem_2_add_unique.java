// Describe an algorithm that prints out all the unique elements in an array. What is the complexity of your algorithm? (Consider two different approaches: without sorting and with sorting)

// Example:

// Array = [6, 8, 10, 11, 6, 10] => print out [6, 8, 10, 11] (you can print the values in any order)

// Note: some students proposed using a set ADT to solve this problem. However, the operations on a set are not basic operations.
package Week2;

public class problem_2_add_unique {
    public static void main(String[] args){
        int[] nums = {6, 8, 10, 11, 6, 10};
        System.out.println(sol_1_without_sorting(nums));
    }

    public static int[] sol_1_without_sorting(int[] nums){
        int[] unique = new int[nums.length];
        int index = 0;
        // Loop through each number in the input array
        // and check if it is already in the unique (output) array
        for(int i: nums){
            boolean found = false;
            for(int j: unique){
                if(i == j){
                    found = true;
                    break;
                }
            }
            if(!found){
                unique[index] = i;
                index++;
            }
        }
        return unique;
    }     
}