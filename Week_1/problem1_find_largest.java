package Week_1;

public class problem1_find_largest {
    public static void main(String[] args){
        int[] arr = {7, 6, 9, 3, 2, 5};
        int max = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        System.out.println("Largest number is: " + max);
    }
}

/*
 * Pseudocode:
 * start = 1
 * end = array length
 * max = array[0]
 * for i from start to (end - 1):
 *   if array[i] > max:
 *     max = array[i]
 * return max
 */