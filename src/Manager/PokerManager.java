package Manager;

import java.util.ArrayList;
import Cards.PokerCard;

public class PokerManager extends CardManager  {

    private final int deck;
    private final boolean withJoker;

    public PokerManager(int deck, boolean withJoker) {
        this.deck = deck;
        this.withJoker = withJoker;
        cardPool = new ArrayList<>();
    }

    @Override
    public void initCardPool() {
        cardPool.clear();
        for (int i = 0; i < deck; i++) {
            for (String suit : PokerCard.SUITS) {
                for (String rank : PokerCard.RANKS) {
                    cardPool.add(new PokerCard(suit, rank));
                }
            }
            if (withJoker) {
                for (String joker : PokerCard.JOKERS) {
                    cardPool.add(new PokerCard(joker, ""));
                }
            }
        }
        shuffle();
    }
}
