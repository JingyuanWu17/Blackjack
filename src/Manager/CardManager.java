package Manager;

import Cards.Card;

// Manage card behavior
public interface CardManager {
    void initCardPool();
    void shuffle();
    Card deal();
}
