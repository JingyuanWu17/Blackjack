package Strategy;

import BjCharacter.BjGamer;
import Cards.Card;

public abstract class BjStrategy {
    public abstract void setGamer(BjGamer gamer);
    public void recordCard(Card card){}
    public abstract boolean takeNext();
}
