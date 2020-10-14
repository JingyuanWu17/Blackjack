package Manager;

import Cards.Card;

import java.util.List;

// Manage cards behavior
public interface CardManager {
    void initCardPool();
    void shuffle();
    Card deal();
    void setDecks(int n);
    void setJokers(boolean bool);
    List<Card> getCardLog();
}
