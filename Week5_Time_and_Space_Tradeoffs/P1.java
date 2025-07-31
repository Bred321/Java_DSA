import java.util.Arrays;
import java.util.Random;

public class P1 {
    public static void main(String[] args){
        int n = 1000000;
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = (int)(Math.random() * 1001);
        }

        // Built-in sorting framework
        int[] builtinArr = arr;
        Arrays.sort(builtinArr);
        
        int[] res = countingSort(arr, n);


    }

    static int[] countingSort(int[] arr, int max){
                // Counting sort
        // 1) Nmax = largest number in the array + 1
        // resultArr.size = n
        // Nmax: the size of the frequency array
        // 2) Going left to right => Increment the value in the frequency array
        // 3) Calculate the accumulative array
        // 4) Going from right to left of the input array, decrease first then add

        // Step 1: Create the empty arrays
        int[] freArr = new int[max + 1];
        int[] resultArr = new int[arr.length];

        // Step 2: Create the frequency array
        for(int val: arr){
            freArr[val] += 1;
        }

        // Step 3: Create the accumulative array
        for(int i = 0; i < max + 1; i++){
            if(i == 0) continue;
            freArr[i] += freArr[i - 1]; 
        }

        // Step 4: Create the result array
        for(int i = arr.length - 1; i >= 0; i--){
            int val = arr[i];
            freArr[val] -= 1;
            int pos = freArr[val];
            resultArr[pos] = val;
        }

        return resultArr;
    }
}
