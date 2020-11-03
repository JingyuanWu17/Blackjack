import java.util.*;

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

    private int playerNum;

    //Manager: manage card behavior
    private CardManager manager;

    private BjStrategy strategy;

    //Gamers: several real players and one dealer
    private final List<BjGamer> gamers = new ArrayList<>();

    private Map<BjGamer, Integer> betMap;

    private boolean isGameover;

    public void iniGame() {

        System.out.println(
                "Rule: Everyone has 500 bet chips at beginning.\r\n" +
                        "Minimum bet per game is 100.\r\n" +
                        "Those who run out of chips are out.");

        //Set the difficulty of game
        System.out.println("Choose the level of games");
        int level = BjTools.getNumRange(1, 4);

        //According to the level of game, choose a corresponding strategy
        strategy = StrategyFactory.strategyCreator(level);

        System.out.println("Choose the number of players");
        playerNum = BjTools.getNumRange(1, 6);

        System.out.println("How many decks of cards do you want to use?");
        int deck = BjTools.getNumRange(1, 6);

        manager = new PokerManager(deck, false);
        manager.initCardPool();

        betMap = new HashMap<>();

        //Load players and dealer
        for (int i = 0; i < playerNum; i++) {
            gamers.add(new BjPlayer("Player" + i, 500));
        }
        gamers.add(new BjDealer(strategy));

    }

    public void startGame() {

        while (playerNum > 0) {

            playerBet();

            //First round: Deal two cards to each gamer(dealer and players)
            firstRound();

            //Second round: each gamer can decide whether to take more cards
            if (!isGameover) {
                secondRound();
            }
            
//
//            //Print final scores of gamers who did not "burst"
//            printResults();
//
//
//            //Compare the final points of each gamer, get the winners.
//            getWinners();
//
            
            isGameover = false;

        }

        System.out.println("End!");

    }

    private void playerBet() {
        for (int i = 0; i < gamers.size() - 1; i++) {
            BjGamer player = gamers.get(i);
            int currMoney = player.getMoney();
            System.out.printf("%s please place a bet (you have %d).\r\n", player.getName(), currMoney);
            int betMoney = BjTools.getNumRange(0, currMoney);
            player.bet(betMoney);
            betMap.put(player, betMoney);
        }
    }

    private void firstRound() {
        System.out.println("First Round");
        for (BjGamer gamer : gamers) {
            for (int i = 0; i < 2; i++) {
                Card card = manager.deal();
                strategy.addCard(card);
                gamer.addCard(card);
            }
            gamer.printFirstTwoCards();
            if (gamer.getStatus() == 1) {
                System.out.printf("%s Blackjack!\r\n", gamer.getName());
            }

        }
        BjGamer dealer = gamers.get(gamers.size() - 1);
        if (dealer.getStatus() == 1) {
            isGameover = true;
            System.out.println("Dealer won! Game Over");
            liquidate();
        }

    }

    private void secondRound() {
        System.out.println("Second Round");
//        for (BjGamer gamer : gamers) {
//            while (gamer.takeNext()) {
//                Card card = manager.deal();
//                strategy.addCard(card);
//                gamer.addCard(card);
//                System.out.printf("%s got a %s.\r\n", gamer.getName(), card.getRank());
//                if (gamer.isBurst()) {
//                    System.out.printf("%s bust!\r\n", gamer.getName());
//                    break;
//                }
//            }
//        }
    }

    private void liquidate() {
    }

//    private void printResults() {
//        System.out.println("Final Results:\r\n");
//        for (BjGamer gamer : gamers) {
//            if (!gamer.isBurst()) {
//                gamer.printAllCards();
//            } else {
//                System.out.printf("%s burst!\r\n", gamer.getName());
//            }
//        }
//    }
//
//    private void getWinners() {
//        int max = 0;
//        List<BjGamer> winners = new ArrayList<>();
//        for (BjGamer gamer : gamers) {
//            if (!gamer.isBurst()) {
//                int Points = gamer.getPoints();
//                if (Points > max) {
//                    winners.clear();
//                    winners.add(gamer);
//                    max = Points;
//                } else if (Points == max) {
//                    winners.add(gamer);
//                }
//            }
//        }
//        if (winners.size() == 0) {
//            System.out.println("No winners.");
//            return;
//        }
//        for (BjGamer winner : winners) {
//            System.out.printf("%s wins! Final Points are %d.\r\n", winner.getName(), winner.getPoints());
//        }
//    }

//    private void mySplit() {
//        System.out.println("\r\n*************************************\r\n");
//    }

}
