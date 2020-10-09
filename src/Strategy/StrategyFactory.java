package Strategy;

public class StrategyFactory {
    public static BjStrategy strategyCreator(int i) {
        if (i == 1) {
            return new BjStrategyL1();
        }
        return null;
    }
}
