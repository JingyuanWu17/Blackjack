package BjCharacter;

import java.util.List;
import java.util.ArrayList;

import Cards.Card;

// Blackjack gamer
public abstract class BjGamer {

    protected String name;
    protected boolean bust;
    protected boolean blackjack;
    protected double money;
    protected boolean hasAce;
    protected int currPoints;
    protected final List<Card> handCards;


    public BjGamer() {
        handCards = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return currPoints;
    }

    public boolean isBust() {
        return bust;
    }

    public boolean isBlackjack() {
        return blackjack;
    }

    public double getMoney() {
        return money;
    }

    //Decide next move, take more cards or not
    public abstract boolean takeNext();

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        BjGamer gamer_obj = (BjGamer) obj;
        return this.getName().equals(gamer_obj.getName());
    }

    public void addCard(Card card) {
        handCards.add(card);
        updatePoints(card);
        updateStatus();
    }

    public void bet(double m) {
        money -= m;
    }

    public void winMoney(double m) {
        money += m;
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
            bust = true;
        } else if (currPoints == 21 && handCards.size() == 2) {
            blackjack = true;
        }
    }

    //Print first two cards after first round.
    public void printFirstTwoCards() {
        System.out.printf("%s got one %s and one %s.\r\n", name, handCards.get(0).getRank(), handCards.get(1).getRank());
    }

    public void printAllCards() {
        System.out.printf("%s got ", name);
        for (Card card : handCards) {
            System.out.printf("%s ", card.getRank());
        }
        System.out.println();
    }

    public void statusReset() {
        bust = false;
        blackjack = false;
        handCards.clear();
        hasAce = false;
        currPoints = 0;
    }

}
