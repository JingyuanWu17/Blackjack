package Strategy;

import java.util.Random;

//Level 1 strategy: Randomly decide whether to take one more card.(50%)
public class BjStrategyL1 implements BjStrategy {

    private static final int BOUND = 17;
    private final Random random;

    public BjStrategyL1() {
        random = new Random();
    }

    @Override
    public boolean takeNext(int points) {
        if (points < BOUND) {
            return true;
        }
        return random.nextBoolean();
    }
}
