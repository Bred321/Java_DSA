package objects;
import java.util.Scanner;

public class object {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String in_str = sc.next();
        printHello(in_str);

        System.out.println(add_2(8));
    }

    public static void printHello(String s){
        System.out.println("Mirroring input: " + s);
    }

    public static int add_2(int x){
        return x + 2;
    }
}
