package Strategy;

public class StrategyFactory {
    public static BjStrategy strategyCreator(int i) {
        if (i == 1) {
            return new BjStrategyL1();
        } else if (i == 2) {
            return new BjStrategyL2();
        } else if (i == 3) {
            return new BjStrategyL3();
        } else if (i == 4) {
            return new BjStrategyL4();
        }
        return null;
    }
}
