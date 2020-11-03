package Strategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Cards.Card;

/**
 * Advance3 strategy:
 * Now the dealer will record cards to a certain degree.
 * According to the cards that have appeared，dealer roughly judge whether next card's point is big or not.
 * Then according to current points, decide whether to take more cards.
 */
public class BjStrategyA3 extends BjStrategy {

    //Small points: 2, 3, 4, 5, 6, 7
    //Big points: 8, 9, 10, J, Q, K, A
    private static final Set<String> smallPoints;
    private static final BjStrategy strategyL3;
    private int count;

    static {
        smallPoints = new HashSet<>();
        for (int i = 2; i <= 7; i++) {
            smallPoints.add(String.valueOf(i));
        }
        strategyL3 = StrategyFactory.strategyCreator(3);
    }

    @Override
    public boolean takeNext(int points) {
        boolean nextBig = count > 0;
        if (points <= 13 && nextBig) {
            return true;
        } else if (points >= 17 && nextBig) {
            return false;
        }
        return strategyL3.takeNext(points);
    }

    @Override
    public void addCard(Card card) {
        String rank = card.getRank();
        //Update count
        if (smallPoints.contains(rank)) {
            count--;
        } else {
            count++;
        }
    }
}