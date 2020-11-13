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

    //Manager: manage card behavior
    private CardManager manager;

    private BjStrategy strategy;

    //Gamers: several real players and one dealer
    private final List<BjGamer> gamers = new ArrayList<>();

    private Map<BjGamer, Double> betMap;

    private List<Integer> outPlayer;

    private boolean allPlayersOut;

    private boolean dealerBlackjack;


    public void iniGame() {

        System.out.println(
                "RULES:\r\n" +
                        "Every player has 500 bets at beginning.\r\n" +
                        "Minimum bet per game is 100.\r\n" +
                        "Those who run out of chips are out.\r\n");

        //Set the difficulty of game
        System.out.println("Choose the level of games");
        int level = BjTools.getInt(1, 4);

        //According to the level of game, choose a corresponding strategy
        strategy = StrategyFactory.strategyCreator(level);

        System.out.println("Choose the number of players");
        int playerNum = BjTools.getInt(1, 6);

        System.out.println("How many decks of cards do you want to use?");
        int deck = BjTools.getInt(1, 6);

        manager = new PokerManager(deck, false);
        manager.initCardPool();

        betMap = new HashMap<>();

        outPlayer = new ArrayList<>();

        //Load players and dealer
        for (int i = 0; i < playerNum; i++) {
            gamers.add(new BjPlayer("Player" + i, 500));
        }
        gamers.add(new BjDealer(strategy));

    }

    public void startGame() {

        while (!allPlayersOut) {

            playerBet();

            //First round: Deal two cards to each gamer(dealer and players)
            firstRound();

            if (!dealerBlackjack) {
                //Second round: each gamer can decide whether to take more cards
                secondRound();
            }

            printResults();

            betLiquidate();

            Reset();

        }

        mySplit();

        System.out.println("Game Over!");

    }

    private void playerBet() {
        mySplit();
        System.out.println("Players Bet");
        for (int i = 0; i < gamers.size() - 1; i++) {
            BjGamer player = gamers.get(i);
            System.out.printf("%s please place a bet (you now have %.2f).\r\n", player.getName(), player.getMoney());
            double betMoney = BjTools.getDouble(100, player.getMoney());
            player.bet(betMoney);
            betMap.put(player, betMoney);
        }
    }

    private void firstRound() {
        mySplit();
        System.out.println("First Round!\r\n");
        for (BjGamer gamer : gamers) {
            for (int i = 0; i < 2; i++) {
                Card card = manager.deal();
                strategy.addCard(card);
                gamer.addCard(card);
            }
            gamer.printFirstTwoCards();
            if (gamer.isBlackjack()) {
                System.out.printf("%s Blackjack!\r\n", gamer.getName());
            }
        }
        BjGamer dealer = gamers.get(gamers.size() - 1);
        if (dealer.isBlackjack()) {
            dealerBlackjack = true;
        }
    }

    private void secondRound() {
        mySplit();
        System.out.println("Second Round!\r\n");
        for (BjGamer gamer : gamers) {
            if (gamer.isBlackjack()) {
                continue;
            }
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
        mySplit();
        System.out.println("Results:\r\n");

        for (BjGamer gamer : gamers) {
            if (!gamer.isBurst()) {
                gamer.printAllCards();
            } else {
                System.out.printf("%s burst!\r\n", gamer.getName());
            }
        }
    }

    private void betLiquidate() {
        mySplit();
        System.out.println("Liquidate:\r\n");

        BjGamer dealer = gamers.get(gamers.size() - 1);
        int dealerPoints = dealer.getPoints();

        for (int i = 0; i < gamers.size() - 1; i++) {
            BjGamer player = gamers.get((i));
            String name = player.getName();
            double betMoney = betMap.get(player);
            if (player.isBurst() || player.getPoints() < dealerPoints) {
                System.out.printf("%s lost %.2f.\r\n", name, betMoney);
                if (player.getMoney() == 0) {
                    System.out.printf("%s lost all his money, %s is out.\r\n", name, name);
                    outPlayer.add(i);
                }
            } else if (player.getPoints() == dealerPoints) {
                System.out.printf("%s tied.\r\n", name);
                player.winMoney(betMoney);
            } else {
                if (player.isBlackjack()) {
                    System.out.printf("%s won %.2f.\r\n", name, betMoney * 1.5);
                    player.winMoney(betMoney * 2.5);
                } else {
                    System.out.printf("%s won %.2f.\r\n", name, betMoney);
                    player.winMoney(betMoney * 2);
                }
            }

        }
    }

    private void Reset() {
        for (int i : outPlayer) {
            gamers.remove(i);
        }
        for (BjGamer gamer : gamers) {
            gamer.statusReset();
        }

        dealerBlackjack = false;
        betMap.clear();
        outPlayer.clear();

        if (gamers.size() == 1) {
            allPlayersOut = true;
        }

    }

    private void mySplit() {
        System.out.println("*************************************\r\n");
    }

}
