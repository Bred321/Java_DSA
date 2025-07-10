import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        int x = 6;
        int y = 7;
        int z = 10;
        double a = 4.5;
        // > < == >= <= !=
        boolean or_compare = x > y || y < z;
        boolean and_compare = !(x > y && y < z);

        // Compare string
        String str1 = "Hello World";
        String str2 = "Goodbye";
        boolean str_compare = str1.equals(str2);

        System.out.println(or_compare);
        System.out.println(and_compare);

        // Conditions
        if (x > y){
            System.out.println("x is larger than y");
        } else if (x == y){
            System.out.println("x is equal to y");
        } else {
            System.out.println("x is less than y");
        }

        System.out.println("Input your age: ");
        // Prompt age input from the user
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int age = Integer.parseInt(s);
        if (age >= 18) {
            System.out.println("Input your favorite food: ");
            String food = sc.nextLine();
            
            if (food.equals("piza")){
                System.out.println("I love pizza too!");
            } else if (food.equals("burger")) {
                System.out.println("I love burgers too!");
            } else {
                System.out.println("I don't like " + food);
            }
            System.out.println("You can drive");
        } else if (age > 30)
            System.out.println("You are a teenager");
        else {
            System.out.println("You are not a teenager");
        }
    }
}