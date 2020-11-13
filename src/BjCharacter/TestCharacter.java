package BjCharacter;

import org.junit.Test;
import static org.junit.Assert.*;

import Cards.PokerCard;


public class TestCharacter {

    @Test
    public void test_updatePoints() {
        BjGamer gamer = new BjPlayer("player", 100);
        gamer.addCard(new PokerCard("S", "A"));
        gamer.addCard(new PokerCard("S", "K"));
        gamer.addCard(new PokerCard("S", "8"));
        int points = gamer.getPoints();
        assertEquals(19, points);
    }

}
