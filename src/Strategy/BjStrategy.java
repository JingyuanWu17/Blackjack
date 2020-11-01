package Strategy;

import java.util.Random;
import Cards.Card;
/**
 * Default strategy:
 * When dealer's points are less than 17, dealer must take next card.
 * Or dealer can randomly decides(50%) whether to take more cards.
 */
public class BjStrategy {

    protected static int bound = 17;
    protected static Random random = new Random();

    public boolean takeNext(int points) {
        if (points < bound) {
            return true;
        }
        return random.nextBoolean();
    }

    public void addCard(Card card){}

}
