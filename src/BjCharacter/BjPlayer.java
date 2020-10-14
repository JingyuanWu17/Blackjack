package BjCharacter;

import java.util.Scanner;

public class BjPlayer extends BjGamer {

    public BjPlayer(String name) {
        this.name = name;
    }

    @Override
    //Depends on real players
    public boolean takeNext() {
        String str;
        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.printf("%s takes one more card?[y/n]: ", name);
            if (input.hasNext()) {
                str = input.next();
                if (str.equals("y") || str.equals("n")) {
                    break;
                } else {
                    System.out.println("Please enter y or n");
                }
            }
        }
        return str.equals("y");
    }

    @Override
    public void printFirstTwoCards() {
        System.out.printf("%s has one %s and one %s.\r\n", name, handCards.get(0).getRank(), handCards.get(1).getRank());
    }
}
