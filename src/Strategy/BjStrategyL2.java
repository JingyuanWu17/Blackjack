package Strategy;

import java.util.Random;

import BjCharacter.BjGamer;
import Tools.BjTools;

/**
 * Level 2 strategy:
 * In level 1 strategy, when the dealer's points are less than 17,the deal
 * must take a card. Now we can set a number larger than 17 which increases
 * the difficulty of game.
 */
public class BjStrategyL2 extends BjStrategy {

    private static int bound;
    private final Random random;
    private BjGamer gamer;

    public BjStrategyL2() {
        random = new Random();
        System.out.println("Set an upper bound for dealer");
        bound = BjTools.getNumRange(17, 21);
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

