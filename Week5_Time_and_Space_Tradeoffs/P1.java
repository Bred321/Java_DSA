import java.util.Arrays;
import java.util.Random;

public class P1 {
    public static void main(String[] args){
        int size = 1000000;
        int[] arr = new int[size];

        for(int i = 0; i < size; i++){
            arr[i] = (int)(Math.random() * 100001);
        }

        // Sort the array
        int[] builtinArr = arr;
        Arrays.sort(builtinArr);
    }
}
