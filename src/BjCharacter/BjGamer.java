package BjCharacter;

import java.util.List;
import java.util.ArrayList;

import Cards.Card;

// Blackjack gamer
public abstract class BjGamer {

    protected String name;
    //1: Blackjack, -1: Burst
    protected int status;
    protected int money;
    protected final List<Card> handCards;
    protected boolean hasAce;
    protected int currPoints;


    public BjGamer() {
        handCards = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    //Decide next move, take one more card or not
    public abstract boolean takeNext();

    public void addCard(Card card) {
        handCards.add(card);
        updatePoints(card);
        updateStatus();
    }

    public int getPoints() {
        return currPoints;
    }

    public int getStatus() {
        return status;
    }

    public boolean bet(int m) {
        if (m <= money) {
            money -= m;
            return true;
        }
        return false;
    }

    public void winMoney(int m) {
        money += m;
    }

    public int getMoney() {
        return money;
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

    protected void updateStatus() {
        if (currPoints > 21) {
            status = -1;
        } else if (currPoints == 21 && handCards.size() == 2) {
            status = 1;
        } else {
            status = 0;
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

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        BjGamer gamer_obj = (BjGamer)obj;
        return this.getName().equals(gamer_obj.getName());
    }
}
