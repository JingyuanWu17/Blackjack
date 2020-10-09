package Manager;

import Cards.Card;

public interface CardManager {
    void initCardPool();
    void shuffle();
    Card deal();
    void setDecks(int n);
    void setJokers(boolean bool);
}
