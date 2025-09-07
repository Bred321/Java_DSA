package Week7_Divide_and_Conquer;

import java.util.Random;

public class P1 {
    static final int SIZE = (int)1e6;
    static final int SIZE_SMALL = 10;
    static final int RANGE = (int)1e3;

    // Main function
    public static void main(String[] args) throws Exception{
        MergeSort merge = new MergeSort();
        int[] arr1 = generate(true);
        System.out.println("Before merge sort: ");
        print(arr1);
        merge.mergeSort(arr1);
        System.out.println("After merge sort: ");
        print(arr1);

    }

    // Generate a radom array
    public static int[] generate(boolean small){
        int size = SIZE;
        if(small) {
            size = SIZE_SMALL;
        }
        Random rnd = new Random();
        int[] res = new int[size];
        for (int i = 0;i < res.length; i++){
            res[i] = rnd.nextInt(RANGE);
        }

        return res;
    }

    // Print the array
    public static void print(int[] arr){
        StringBuilder sb = new StringBuilder("Array: ");
        boolean first = true;
        for(int n: arr){
            if(!first){
                sb.append(", " + n);
            } else {
                sb.append(n);
                first = false;
            }
        }
        System.out.println(sb);
    }
}

class MergeSort{
    public void mergeSort(int[] arr){
        if(arr.length > 1){
            int n = arr.length;
            int mid = n / 2;
        
            // Create 2 sub-arrays with arr
            int[] sub1 = new int[mid];
            for(int i = 0;i < mid; i++){
                sub1[i] = arr[i];
            }

            int[] sub2 = new int[n - mid];
            for(int i = mid;i < n; i++){
                sub2[i - mid] = arr[i];
            }

            mergeSort(sub1);
            mergeSort(sub2);
            merge(sub1, sub2, arr);
        }

    }

    public void merge(int[] sub1, int[] sub2, int[] dest){
        int p1 = 0, p2 = 0, pDest = 0;
        while(p1 < sub1.length && p2 < sub2.length){
            if(sub1[p1] <= sub2[p2]){
                dest[pDest]= sub1[p1] ;
                p1++;
            } else {
                dest[pDest]= sub2[p2] ;
                p2++;
            }
            pDest++;
        }

        while(p1 < sub1.length){
            dest[pDest++] = sub1[p1++];
        }

        while(p2 < sub2.length){
            dest[pDest++] = sub2[p2++];
        }
    }
}