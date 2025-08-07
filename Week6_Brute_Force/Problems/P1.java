package Week6_Brute_Force.Problems;

public class P1 {
    public static void main(String[] args){
        int[] numArr = {5, 1, 9, 6, 2};
        int[] bubbleArr = bubbleSort(numArr);
        int[] selectionArr = selectionSort(numArr);

        System.out.println("--BUBBLE SORT RESULT--");
        for(int val: bubbleArr){
            System.out.println(val);
        }

        System.out.println("--SELECTION SORT RESULT--");
        for(int val: selectionArr){
            System.out.println(val);
        }
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

    static int[] selectionSort(int[] arr){
        int size = arr.length;

        for(int i = 0; i <= size - 2; i++){
            int min = i;
            for(int j = i + 1; j <= size - 1; j++){
                if(arr[j] < arr[min]){
                    min = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }

        return arr;
    }
}
