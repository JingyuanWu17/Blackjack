package Tools;

import java.util.Scanner;

public class BjTools {

    //Get an integer within a specific range from console
    public static int getInt(int left, int right) {
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

    //Get a double within a specific range from console
    public static double getDouble(double left, double right) {
        double n;
        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.printf("Enter a number between %.2f and %.2f: ", left, right);
            if (input.hasNextDouble()) {
                n = input.nextDouble();
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
