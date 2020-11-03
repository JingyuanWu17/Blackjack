package Strategy;

import Cards.Card;
/**
 * Default strategy:
 * If dealer's points are less than 17, dealer must take next card.
 */
public class BjStrategy {

    protected static int bound = 17;

    public boolean takeNext(int points) {
        return points < bound;
    }

    public void addCard(Card card){}
}
