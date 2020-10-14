package Strategy;

import java.util.Random;

/**
 * Level 1 strategy:
 * When the dealer's points are less than 17,the deal
 * must take next card. Besides, the dealer randomly
 * decides(50%) whether to take one more card.
 */
public class BjStrategyL1 implements BjStrategy {

    private static final int BOUND = 17;
    private static final Random random = new Random();

    @Override
    public boolean takeNext(int points) {
        if (points < BOUND) {
            return true;
        }
        return random.nextBoolean();
    }
}
