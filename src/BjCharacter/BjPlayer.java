package BjCharacter;

import java.util.Scanner;

public class BjPlayer extends BjGamer {

    public BjPlayer(String name, int money) {
        this.money = money;
        this.name = name;
    }

    @Override
    public boolean takeNext() {
        String str;
        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.printf("%s Hit or Stand?[h/s]: ", name);
            if (input.hasNext()) {
                str = input.next();
                if (str.equals("h") || str.equals("s")) {
                    break;
                } else {
                    System.out.println("Please enter h or s.");
                }
            }
        }
        return str.equals("h");
    }

}
