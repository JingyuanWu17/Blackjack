package Strategy;

public class StrategyFactory {
    public static BjStrategy strategyCreator(int i) {
        if (i == 1) {
            return new BjStrategyL1();
        } else if (i == 2) {
            return new BjStrategyL2();
        }
        return null;
    }
}
