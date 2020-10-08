package People;

import java.util.ArrayList;
import java.util.List;
import Cards.Card;

public abstract class Gamer {

    // Maintain a list to record gamer' cards
    private final List<Card> handCards = new ArrayList<>();

    public void addCard(Card card) {
        handCards.add(card);
    }

    public List<Card> showCards() {
        return handCards;
    }

}
