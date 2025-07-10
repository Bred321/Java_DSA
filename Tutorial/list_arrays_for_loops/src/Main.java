import java.util.Scanner;


public class Main {
    public static void main(String[] args){
        int[] newArray = new int[5];
        String[] strArray = new String[5];
        strArray[0]= "Hello";
        strArray[1] = "hi";
        strArray[2] = "tim";
        strArray[3] = "bill";

        int[] nums =  {1, 5, 343, 343, 565};
        double[] nums2 = {2.0, 3.0};

        String x = strArray[0];
        System.out.println(x);

        for (int i=0; i < 5; ++i){
            System.out.print("The current value is: ");
            System.out.println(i);
        }

        for (int i = 0; i  < nums.length; i++){
            if(nums[i] == 5){
                System.out.println("Found a 5 at index " + i);
            }
        }

        for (String element: strArray) {
            System.out.println("The process element is :  " + element);
            if (element.equals("tim")){
                break;
            }
        }

        for (int num: nums){
            System.out.println("The current number is : " + num);
        }

        // While loop
        Scanner sc = new Scanner(System.in);
        int count = 0;
        int val = 0;
        do {
            System.out.println("Type 10: ");
            val = sc.nextInt();
            ++count;
        } while(val != 10);

        System.out.println("You have tried " + count + " times");
    }
}