package Strategy;

public class StrategyFactory {
    public static BjStrategy strategyCreator(int i) {
        if (i == 1) {
            return new BjStrategy();
        } else if (i == 2) {
            return new BjStrategyA1();
        } else if (i == 3) {
            return new BjStrategyA2();
        } else if (i == 4) {
            return new BjStrategyA3();
        }
        return null;
    }
}
