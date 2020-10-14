package Manager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Cards.Card;
import Cards.PokerCard;

public class PokerManager implements CardManager {

    //Singleton Pattern
    private PokerManager() {
    }

    private static final PokerManager pm = new PokerManager();

    private static int deck = 1;
    private static boolean withJoker = false;
    private static final List<Card> cardPool = new ArrayList<>();
    //Record cards that have been dealt
    private static final List<Card> cardLog = new ArrayList<>();

    public static PokerManager getInstance() {
        return pm;
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
        Card card = cardPool.remove(cardPool.size() - 1);
        cardLog.add(card);
        return card;
    }

    @Override
    public void setDecks(int n) {
        deck = n;
    }

    @Override
    public void setJokers(boolean bool) {
        withJoker = bool;
    }

    @Override
    public List<Card> getCardLog() {
        return cardLog;
    }

}
