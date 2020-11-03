package Strategy;

import java.util.Random;

/**
 * Advance2 strategy:
 * Decide whether to take more cards according to the points of current cards.
 * The higher the current points are, the lower the probability of taking cards.
 */
public class BjStrategyA2 extends BjStrategy {

    private static final Random random = new Random();

    @Override
    public boolean takeNext(int points) {
        if (points <= 10) {
            return true;
        } else if (points <= 12) {
            return random.nextDouble() < 0.8;
        } else if (points <= 14) {
            return random.nextDouble() < 0.6;
        } else if (points <= 16) {
            return random.nextDouble() < 0.4;
        } else if (points <= 18) {
            return random.nextDouble() < 0.2;
        }
        return false;
    }
}
