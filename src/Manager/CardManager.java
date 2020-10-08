package Manager;

import Cards.Card;

public abstract class CardManager {

    public abstract void initCardPool();
    public abstract void shuffle();
    public abstract Card deal();

}
