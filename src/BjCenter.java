import BjCharacter.BjDealer;
import BjCharacter.BjGamer;
import BjCharacter.BjPlayer;
import Cards.Card;
import Manager.CardManager;
import Manager.PokerManager;
import Strategy.BjStrategy;
import Strategy.StrategyFactory;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

//Game center, maintain the whole game
public class BjCenter {
    private CardManager manager;
    private final List<BjGamer> gamers = new ArrayList<>();

    public void iniGame() {
        Scanner in = new Scanner(System.in);

        System.out.println("1, 2, 3, choose the level of games you want.");
        int level = in.nextInt();

        System.out.println("Enter the number of players:");
        int playerNum = in.nextInt();

        System.out.println("How many decks of playing cards you want?");
        int deck = in.nextInt();

        BjStrategy strategy = StrategyFactory.strategyCreator(level);

        gamers.add(new BjDealer(strategy));

        for (int i = 0; i < playerNum; i++) {
            gamers.add(new BjPlayer("Player" + i + " "));
        }

        manager = PokerManager.getInstance();
        manager.setDecks(deck);
        manager.initCardPool();
        manager.shuffle();

    }

    public void startGame() {
        firstRound();

    }

    //Deal two cards to each gamer(dealer and players) and print it out.
    private void firstRound() {
        for (BjGamer gamer : gamers) {
            for (int i = 0; i < 2; i++) {
                Card card = manager.deal();
                gamer.addCard(card);
            }
            gamer.printTwoCards();
        }
    }



}
