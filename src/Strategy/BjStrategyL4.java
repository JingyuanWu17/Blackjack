package Strategy;

import BjCharacter.BjGamer;
import Cards.Card;
import Manager.CardManager;
import Manager.PokerManager;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * Level 4 strategy:
 * According to the cards that have appeared，roughly judge whether the next card's point is big not not,
 * and then according to the current points, decide whether to take one more card.
 */
public class BjStrategyL4 implements BjStrategy {

    private final Random random;
    private static final Set<String> smallPoints = new HashSet<>();
    private static final BjStrategy strategyL3 = StrategyFactory.strategyCreator(3);

    static {
        for (int i = 2; i <= 7; i++) {
            smallPoints.add(String.valueOf(i));
        }
    }

    public BjStrategyL4() {
        random = new Random();
    }

    @Override
    public boolean takeNext(int points) {
        boolean big = nextCardBig();
        if (points <= 13 && big) {
            return true;
        } else if (points >= 17 && big) {
            return false;
        }
        return strategyL3.takeNext(points);
    }

    private boolean nextCardBig() {
        PokerManager pm = PokerManager.getInstance();
        List<Card> cardLog = pm.getCardLog();
        int val = 0;
        for (Card card : cardLog) {
            if (smallPoints.contains(card.getRank())) {
                val--;
            } else {
                val++;
            }
        }
        return val < 0;

    }
}
