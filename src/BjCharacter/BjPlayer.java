package BjCharacter;

public class BjPlayer extends BjGamer {

    public BjPlayer(String name) {
        this.name = name;
    }

    @Override
    public boolean takeNext() {
        //Depends on the real players
        return false;
    }

    @Override
    public void printTwoCards() {
        System.out.println(name + "has one " + handCards.get(0).getRank() + " and one " + handCards.get(1).getRank());

    }
}
