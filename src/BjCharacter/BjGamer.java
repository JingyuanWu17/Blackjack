package BjCharacter;

import java.util.List;
import java.util.ArrayList;

import Cards.Card;

// Blackjack gamer
public abstract class BjGamer {

    public String name;

    protected final List<Card> handCards = new ArrayList<>();

    //table[0]:points without ace value
    //table[1]:numbers of ace
    protected final int[] table = new int[2];

    //Decide next move, take one more card or not
    public abstract boolean takeNext();

    public abstract void printFirstTwoCards();

    public void printAllCards() {
        System.out.print(name + " has: ");
        for (Card card : handCards) {
            System.out.print(card.getRank() + " ");
        }
        System.out.println();
    }

    public void addCard(Card card) {
        handCards.add(card);
        updateTable(card);
    }

    public boolean isBurst() {
        return getPoints() > 21;
    }

    //Calculate the sum of card points
    public int getPoints() {
        int val = table[0];
        int n = table[1];
        while (n > 0) {
            if (val + 11 + n - 1 <= 21) {
                val += 11;
            } else {
                val += 1;
            }
            n--;
        }
        return val;
    }

    protected void updateTable(Card card) {
        String rank = card.getRank();
        switch (rank) {
            case "J":
            case "Q":
            case "K":
                table[0] += 10;
                break;
            case "A":
                table[1]++;
                break;
            default:
                table[0] += Integer.parseInt(rank);
        }
    }

}
