package Strategy;

import java.util.Random;

import Tools.BjTools;

/**
 * Level 2 strategy:
 * Player now can set the upper bound for deal which forces
 * dealer to take one more card.
 */
public class BjStrategyL2 implements BjStrategy {

    private static int bound;
    private static final Random random = new Random();

    public BjStrategyL2() {
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

