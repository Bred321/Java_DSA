package Week6_Brute_Force;

public class P1 {
    public static void main(String[] args){
        int[] numArr = {5, 1, 9, 6, 2};
        int[] bubbleArr = bubbleSort(numArr);

        System.out.println("--BUBBLE SORT RESULT--");
        for(int val: bubbleArr){
            System.out.println(val);
        }
    }

    static int[] selectionSort(int[] arr){
        int[] resultArr = arr;
        return resultArr;
    }

    
    static int[] bubbleSort(int[] arr){
        int size = arr.length;

        for(int i = 0; i <= size - 2; i++){
            for(int j = 0; j <= size - 2 - i; j++){
                if(arr[j + 1] < arr[j]){
                    // Swap to values
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        return arr;
    }
}
