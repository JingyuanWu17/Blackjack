package Strategy;

import java.util.Random;

import Tools.BjTools;

/**
 * Level 2 strategy:
 * In level 1 strategy, when the dealer's points are less than 17,the deal
 * must take a card. Now we can set this number.
 */
public class BjStrategyL2 implements BjStrategy {

    private static int bound;
    private final Random random;

    public BjStrategyL2() {
        random = new Random();
        System.out.println("Set an upper bound for dealer");
        bound = BjTools.getNumRange(1, 21);
    }

    @Override
    public boolean takeNext(int points) {
        if (points < bound) {
            return true;
        }
        return random.nextBoolean();
    }
}

