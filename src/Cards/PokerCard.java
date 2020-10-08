package Cards;

import java.util.HashMap;
import java.util.Map;

public class PokerCard extends Card{

    private final String suit;
    private final String rank;
    private static final Map<String, String> suitMap = new HashMap<>();

    static {
        suitMap.put("H", "Heart");
        suitMap.put("S", "Spade");
        suitMap.put("C", "Club");
        suitMap.put("D", "Diamond");
        suitMap.put("LJ", "Little Joker");
        suitMap.put("BJ", "Big Joker");
    }

    public PokerCard(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String getSuit() {
        return suit;
    }

    @Override
    public String getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return "a " + rank + " of " + suitMap.get(suit);
    }

}
