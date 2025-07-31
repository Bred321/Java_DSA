import java.util.Arrays;
import java.util.Random;

public class P1 {
    public static void main(String[] args){
        int[] arr = generate(100000, 1000000000);
        int max = Arrays.stream(arr).max().getAsInt(); 

        // Built-in sorting framework
        int[] builtinArr = arr;
        long t1 = System.currentTimeMillis();
        Arrays.sort(builtinArr);
        long t2 = System.currentTimeMillis();
        System.out.println("Builtin sort: " + (t2 - t1) + " milliseconds");
        
        long dist1 = System.currentTimeMillis();
        int[] res = countingSort(arr, max);
        long dist2 = System.currentTimeMillis();
        System.out.println("Counting sort: " + (dist2 - dist1) + " milliseconds");

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

    static int[] generate(int size, int max){
        int[] res = new int[size];

        for(int i = 0; i < size; i++){
            res[i] = (int)(Math.random() * max + 1);
        }

        return res;
    }

    static void printArr(int[] arr){
        for(int val: arr){
            System.out.print(val);
            System.out.print(' ');
        }
        System.out.println();
    }
        
}
