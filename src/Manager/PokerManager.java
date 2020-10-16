package Manager;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

import Cards.Card;
import Cards.PokerCard;

public class PokerManager implements CardManager {

    private final int deck;
    private final boolean withJoker;
    private final List<Card> cardPool;

    public PokerManager(int n, boolean bool) {
        deck = n;
        withJoker = bool;
        cardPool = new ArrayList<>();
    }

    //Initialize decks of playing cards.
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

    @Override
    public void shuffle() {
        Collections.shuffle(cardPool);
    }

    @Override
    public Card deal() {
        return cardPool.remove(cardPool.size() - 1);
    }

}
