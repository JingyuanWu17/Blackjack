package Strategy;

import BjCharacter.BjGamer;

import java.util.Random;

//Level 1 strategy: Randomly decide whether to take one more card.
public class BjStrategyL1 extends BjStrategy {

    private static final int bound = 17;
    private final Random random;
    private BjGamer gamer;

    public BjStrategyL1() {
        random = new Random();
    }

    @Override
    public void setGamer(BjGamer gamer) {
        this.gamer = gamer;
    }

    @Override
    public boolean takeNext() {
        if (gamer.getScore() < bound) {
            return true;
        }
        return random.nextBoolean();
    }
}
