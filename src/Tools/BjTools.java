package Tools;

import java.util.Scanner;

public class BjTools {

    //Get an integer in a specific range from console
    public static int getNumRange(int left, int right) {
        int n;
        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.printf("Enter a number between %d and %d: ", left, right);
            if (input.hasNextInt()) {
                n = input.nextInt();
                if (n >= left && n <= right) {
                    break;
                } else {
                    System.out.println("Input number is out of range, please re-enter");
                }
            } else {
                System.out.println("Please enter a number");
            }
        }
        System.out.println();
        return n;
    }

}
