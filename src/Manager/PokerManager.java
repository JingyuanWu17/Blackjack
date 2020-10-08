package Manager;


import Cards.Card;
import Cards.PokerCards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Manage card behavior
public class PokerManager extends CardManager {

    //Singleton Pattern
    private PokerManager() {
    }

    private static int deck = 1;
    private static boolean withJoker = false;
    private static final List<Card> cardPool = new ArrayList<>();
    private static final PokerManager pm = new PokerManager();

    public static PokerManager getInstance() {
        return pm;
    }

    //Initialize the number of decks of playing card.
    @Override
    public void initCardPool() {
        cardPool.clear();
        for (int i = 0; i < deck; i++) {
            cardPool.addAll(PokerCards.initPokerCards(withJoker));
        }

    }

    @Override
    public void shuffle() {
        Collections.shuffle(cardPool);
    }

    @Override
    public Card deal() {
        return cardPool.remove(cardPool.size() - 1);
    }

    public void setDecks(int d) {
        deck = d;
    }

    public void setJoker(boolean bool) {
        withJoker = bool;
    }
}
