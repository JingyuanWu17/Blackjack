package Strategy;

import Tools.BjTools;

/**
 * Advance1 strategy:
 * Now Player can set the upper bound for dealer at the beginning of game.
 */
public class BjStrategyA1 extends BjStrategy {

    public BjStrategyA1() {
        System.out.println("Set an upper bound for dealer");
        bound = BjTools.getInt(1, 21);
    }
}

