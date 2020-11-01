package Strategy;

/**
 * Advance2 strategy:
 * Decide whether to take more cards according to the points of current cards.
 * The higher the current points are, the lower the probability of taking cards.
 */
public class BjStrategyA2 extends BjStrategy {

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
