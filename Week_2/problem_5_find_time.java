//You develop an application that can track users' movement (think of Google Maps). The application complexity is O(N^3) and it takes 100 msec to run data for 1,000 users (N is the number of users).
//How many days it will take your application to run for 1,000,000 users?

// Answer: T(n) = 100 (msec) * (1,000,000 / 1,000)^3 = 100 * 1,000,000 = 100,000,000 msec
package Week_2;
import java.lang.Math;
public class problem_5_find_time {
    public static void main(String[] args){
        // Given 100 msec for 1,000 users
        int timeFor1000Users = 100; // in msec
        int oldUserNum = Math.pow(10, 3);

        // Find the time for 1,000,000 users
        int newUserNum = Math.pow(10, 6);
        int timeFor10E6Users = timeFor1000Users * Math.pow(newUserNum / oldUserNum, 3);

        // Convert time for msec to days
        int timeInDays = (timeFor10E6Users * Math.pow(10, -3)) / (24 * 24 * 3600);

        System.out.println("Time for 1,000,000 users: " + timeFor10E6Users + " msec");
    }
}