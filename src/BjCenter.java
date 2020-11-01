import java.util.List;
import java.util.ArrayList;

import Cards.Card;
import Tools.BjTools;
import BjCharacter.BjDealer;
import BjCharacter.BjGamer;
import BjCharacter.BjPlayer;
import Manager.CardManager;
import Manager.PokerManager;
import Strategy.BjStrategy;
import Strategy.StrategyFactory;


//Game center: maintain the whole logic of game
public class BjCenter {

    //Manager: manage card behavior
    private CardManager manager;

    private BjStrategy strategy;

    //Gamers: several real players and one dealer
    private final List<BjGamer> gamers = new ArrayList<>();

    public void iniGame() {

        //Set the difficulty of game
        System.out.println("Choose the level of games");
        int level = BjTools.getNumRange(1, 4);

        //According to the level of game, choose a corresponding strategy
        strategy = StrategyFactory.strategyCreator(level);

        System.out.println("Choose the number of players");
        int playerNum = BjTools.getNumRange(1, 6);

        System.out.println("How many decks of cards do you want to use?");
        int deck = BjTools.getNumRange(1, 4);

        manager = new PokerManager(deck, false);
        manager.initCardPool();

        //Load players and dealer
        for (int i = 0; i < playerNum; i++) {
            gamers.add(new BjPlayer("Player" + i));
        }
        gamers.add(new BjDealer(strategy));

    }

    public void startGame() {

        mySplit();

        //Deal two cards to each gamer(dealer and players) and print their cards.
        firstRound();

        mySplit();

        //In second round, each gamer can decide whether to take more cards
        secondRound();

        mySplit();

        //Print final scores of gamers who did not "burst"
        printResults();

        mySplit();

        //Compare the final points of each gamer, get the winners.
        getWinners();

        mySplit();

        System.out.println("The End!");

    }

    private void firstRound() {
        System.out.println("First Round Begin!\r\n");
        for (BjGamer gamer : gamers) {
            for (int i = 0; i < 2; i++) {
                Card card = manager.deal();
                strategy.addCard(card);
                gamer.addCard(card);
            }
            gamer.printFirstTwoCards();
        }
    }

    private void secondRound() {
        System.out.println("Second Round Begin!");
        for (BjGamer gamer : gamers) {
            System.out.println();
            while (gamer.takeNext()) {
                Card card = manager.deal();
                strategy.addCard(card);
                gamer.addCard(card);
                System.out.printf("%s got a %s.\r\n", gamer.getName(), card.getRank());
                if (gamer.isBurst()) {
                    System.out.printf("%s bust!\r\n", gamer.getName());
                    break;
                }
            }
        }
    }

    private void printResults() {
        System.out.println("Final Results:\r\n");
        for (BjGamer gamer : gamers) {
            if (!gamer.isBurst()) {
                gamer.printAllCards();
            } else {
                System.out.printf("%s burst!\r\n", gamer.getName());
            }
        }
    }

    private void getWinners() {
        int max = 0;
        List<BjGamer> winners = new ArrayList<>();
        for (BjGamer gamer : gamers) {
            if (!gamer.isBurst()) {
                int Points = gamer.getPoints();
                if (Points > max) {
                    winners.clear();
                    winners.add(gamer);
                    max = Points;
                } else if (Points == max) {
                    winners.add(gamer);
                }
            }
        }
        if (winners.size() == 0) {
            System.out.println("No winners.");
            return;
        }
        for (BjGamer winner : winners) {
            System.out.printf("%s wins! Final Points are %d.\r\n", winner.getName(), winner.getPoints());
        }
    }

    private void mySplit() {
        System.out.println("\r\n*************************************\r\n");
    }

}
