package BjCharacter;

import Strategy.BjStrategy;

public class BjDealer extends BjGamer {

    private BjStrategy strategy;

    public BjDealer(BjStrategy strategy) {
        name = "Dealer";
        this.strategy = strategy;
    }

    @Override
    public boolean takeNext() {
        return strategy.takeNext(getPoints());
    }

    @Override
    public void printFirstTwoCards() {
        System.out.printf("Dealer has one hidden card and one %s.\r\n", handCards.get(1).getRank());
    }
}
