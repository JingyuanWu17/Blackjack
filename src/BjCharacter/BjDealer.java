package BjCharacter;

import Cards.Card;
import Strategy.BjStrategy;

public class BjDealer extends BjGamer {
    private BjStrategy strategy;

    public BjDealer(BjStrategy strategy) {
        name = "Dealer";
        this.strategy = strategy;
        strategy.setGamer(this);
    }

    @Override
    public boolean takeNext() {
        return strategy.takeNext();
    }

    @Override
    public void printTwoCards() {
        System.out.println("Dealer has one hidden card and one " + handCards.get(1).getRank());
    }

    @Override
    public void addCard(Card card) {
        super.addCard(card);
        strategy.recordCard(card);
    }
}
