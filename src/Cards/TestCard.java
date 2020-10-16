package Cards;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestCard {
    @Test
    public void test() {
        Card card = new PokerCard("D", "A");
        String suit = card.getSuit();
        String rank = card.getRank();
        assertEquals("D", suit);
        assertEquals("A", rank);
    }
}
