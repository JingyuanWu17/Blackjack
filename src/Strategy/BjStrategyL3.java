package Strategy;

import BjCharacter.BjGamer;

import java.util.Random;

/**
 * Level 3 strategy:
 * Decide whether to take a card according to the points of current cards.
 * The higher the current points are, the lower the probability of taking one more card.
 */
public class BjStrategyL3 implements BjStrategy {

    private final Random random;

    public BjStrategyL3() {
        random = new Random();
    }

    @Override
    public boolean takeNext(int points) {
        if (points <= 11) {
            return true;
        } else if (points <= 13) {
            return random.nextDouble() < 0.8;
        } else if (points <= 15) {
            return random.nextDouble() < 0.6;
        } else if (points <= 17) {
            return random.nextDouble() < 0.4;
        } else if (points <= 19) {
            return random.nextDouble() < 0.2;
        }
        return false;
    }
}
