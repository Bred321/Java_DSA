package Week10_Transform_and_Conquer;

public class P1 {
    public static void  main(String[] args){
        
    }
}

class Task{
    int start;
    int end;

    public Task(int s, int e){
        start = s;
        end = e;
    }
}

class MergeSort {
    public void mergeSort(int arr[]) {
        if (arr.length > 1) {
        int n = arr.length;
        int middle = n / 2;

        // create 2 sub-arrays from arr
        int[] sub1 = new int[middle];
        for (int i = 0; i < middle; i++) {
            sub1[i] = arr[i];
        }

        int[] sub2 = new int[n - middle];
        for (int i = middle; i < n; i++) {
            sub2[i - middle] = arr[i];
        }
        // sort first and second halves
        mergeSort(sub1);
        mergeSort(sub2);
        // merge sub1 and sub2 into the original array
        merge(sub1, sub2, arr);
        }
    }
    // merge two sub-arrays sub1 and sub2 into the array dest
    public void merge(int[] sub1, int[] sub2, int[] dest) {
        int p1 = 0, p2 = 0, pDest = 0; // pointers to 3 arrays

        while (p1 < sub1.length && p2 < sub2.length) {
        if (sub1[p1] <= sub2[p2]) {
            dest[pDest] = sub1[p1];
            p1++;
        } else {
            dest[pDest] = sub2[p2];
            p2++;
        }
        pDest++;
        }

        // copy remaining elements, if any
        while (p1 < sub1.length) {
            dest[pDest++] = sub1[p1++];
        }

        while (p2 < sub2.length) {
            dest[pDest++] = sub2[p2++];
        }
    }
}