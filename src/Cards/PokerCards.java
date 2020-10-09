package Cards;

import java.util.ArrayList;
import java.util.List;

//One deck of poker cards
public class PokerCards {
    private static final String[] RANKS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

    //H -> Heart, S -> Spade, C -> Club, D -> Diamond
    private static final String[] SUITS = {"H", "S", "C", "D"};

    //LJ -> Little Joker, BJ -> Big Joker
    private static final String[] JOKERS = {"LJ", "BJ"};

    //Return one deck of playing cards with or without two jokers
    public static List<PokerCard> initPokerCards(Boolean withJoker) {
        List<PokerCard> res = new ArrayList<>();
        for (String suit : SUITS) {
            for (String rank : RANKS) {
                res.add(new PokerCard(suit, rank));
            }
        }
        if (!withJoker) {
            return res;
        }
        res.add(new PokerCard(JOKERS[0], "0"));
        res.add(new PokerCard(JOKERS[1], "0"));
        return res;
    }

}
