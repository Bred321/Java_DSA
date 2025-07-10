import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        // Get a string input
        System.out.println("Enter a string: ");
        Scanner sc = new Scanner(System.in);
        String scanned = sc.next();
        int x = Integer.parseInt(scanned);
        System.out.println("You have typed: ");
        System.out.println(scanned);

        // Get a numerical input
        System.out.println("Enter a number: ");
        Scanner sc2 = new Scanner(System.in);
        int scanned_2 = sc2.nextInt();
        boolean scanned_3 = sc2.nextBoolean();
        double scanned_4 = sc2.nextDouble();
        System.out.println("The number you have entered is: ");
        System.out.println(scanned_2);

    }
}