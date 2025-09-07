package Week7_Divide_and_Conquer;

public class P3 {
    public static void main(String[] args){
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println("The number of inversion is " + InversionBruteForce.count(arr1));
        System.out.println("The number of inversion is " + InversionDivideConquer.count(arr1));

        int[] arr2 = {8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println("The number of inversion is " + InversionBruteForce.count(arr2));
        System.out.println("The number of inversion is " + InversionDivideConquer.count(arr2));
    }

}

class InversionBruteForce{
    public static int count(int[] arr){
        int n = arr.length;
        int count = 0;

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(arr[i] > arr[j]){
                    count++;
                }
            }
        }
        return count;
    }
}

class InversionDivideConquer{
    public static int count(int[] arr){
        int res = 0;
        int n = arr.length;
        if(n == 1) return res;

        int mid = n / 2;
        int[] sub1 = new int[mid];
        for(int i = 0; i < mid; i++){
            sub1[i] = arr[i];
        }

        int[] sub2 = new int[n - mid];
        for(int i = mid; i < n; i++){
            sub2[i - mid] = arr[i];
        }

        res = count(sub1) + count(sub2);
        res += merge(sub1, sub2, arr);
        return res;
    }

    public static int merge(int[] sub1, int[] sub2, int[] dest){
        int p1 = 0, p2 = 0, pDest = 0, res = 0;
        while(p1 < sub1.length && p2 < sub2.length){
            if(sub1[p1] <= sub2[p2]){
                dest[pDest]= sub1[p1] ;
                p1++;
            } else {
                dest[pDest]= sub2[p2] ;
                p2++;
                res += sub1.length - p1;
            }
            pDest++;
        }

        while(p1 < sub1.length){
            dest[pDest++] = sub1[p1++];
        }

        while(p2 < sub2.length){
            dest[pDest++] = sub2[p2++];
        }

        return res;
    }
}