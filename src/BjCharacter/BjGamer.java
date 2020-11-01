package BjCharacter;

import java.util.List;
import java.util.ArrayList;

import Cards.Card;

// Blackjack gamer
public abstract class BjGamer {

    protected String name;
    protected boolean hasAce;
    protected int currPoints;
    protected final List<Card> handCards;

    public BjGamer() {
        handCards = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    //Decide next move, take one more card or not
    public abstract boolean takeNext();

    public void addCard(Card card) {
        handCards.add(card);
        updatePoints(card);
    }

    public boolean isBurst() {
        return currPoints > 21;
    }

    public int getPoints() {
        return currPoints;
    }

    protected void updatePoints(Card card) {
        String rank = card.getRank();

        if (rank.equals("J") || rank.equals("Q") || rank.equals("K")) {
            currPoints += 10;
        } else if (rank.equals("A")) {
            currPoints += 11;
            if (currPoints > 21) {
                currPoints -= 10;
            } else {
                hasAce = true;
            }
        } else {
            currPoints += Integer.parseInt(rank);
        }

        if (hasAce && currPoints > 21) {
            currPoints -= 10;
            hasAce = false;
        }

    }

    //Print first two cards after first round.
    public void printFirstTwoCards() {
        System.out.printf("%s has one %s and one %s.\r\n", name, handCards.get(0).getRank(), handCards.get(1).getRank());
    }

    public void printAllCards() {
        System.out.printf("%s has: ", name);
        for (Card card : handCards) {
            System.out.printf("%s ", card.getRank());
        }
        System.out.println();
    }

}
