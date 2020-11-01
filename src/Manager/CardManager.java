package Manager;

import java.util.Collections;
import java.util.List;
import Cards.Card;

// Manage card behavior
public abstract class CardManager {

    protected List<Card> cardPool;

    //Initialize decks of cards.
    public abstract void initCardPool();

    public void shuffle() {
        Collections.shuffle(cardPool);
    }

    public Card deal() {
        return cardPool.remove(cardPool.size() - 1);
    }

}
