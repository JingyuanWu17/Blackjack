package Cards;

public class PokerCard implements Card {
    public static final String[] RANKS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

    //H -> Heart, S -> Spade, C -> Club, D -> Diamond
    public static final String[] SUITS = {"H", "S", "C", "D"};

    //LJ -> Little Joker, BJ -> Big Joker
    public static final String[] JOKERS = {"LJ", "BJ"};

    private final String suit;
    private final String rank;

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
}
