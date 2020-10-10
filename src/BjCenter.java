import java.util.ArrayList;
import java.util.List;

import BjCharacter.BjDealer;
import BjCharacter.BjGamer;
import BjCharacter.BjPlayer;
import Cards.Card;
import Manager.CardManager;
import Manager.PokerManager;
import Strategy.BjStrategy;
import Strategy.StrategyFactory;
import Tools.BjTools;

//Game center, maintain the whole game logic
public class BjCenter {

    //Manager: for dealing card
    private CardManager manager;

    //Gamers: including one dealer and several real players
    private final List<BjGamer> gamers = new ArrayList<>();

    public void iniGame() {

        //Set the difficulty of game
        System.out.println("Choose the level of games");
        int level = BjTools.getNumRange(1, 2);

        //According to the level of game, set a strategy for dealer
        BjStrategy strategy = StrategyFactory.strategyCreator(level);

        System.out.println("Choose the number of players");
        int playerNum = BjTools.getNumRange(1, 6);

        System.out.println("How many decks of playing cards you want?");
        int deck = BjTools.getNumRange(1,4);

        //Load players
        for (int i = 0; i < playerNum; i++) {
            gamers.add(new BjPlayer("Player" + i));
        }

        //Add dealer
        gamers.add(new BjDealer(strategy));

        //Set up playing cards
        manager = PokerManager.getInstance();
        manager.setDecks(deck);
        manager.initCardPool();
        manager.shuffle();

    }

    public void startGame() {

        //Deal two cards to each gamer(dealer and players) and print their cards.
        firstRound();

        //In second round, each gamer can decide whether to take more cards
        secondRound();

        //Compare the final scores of each gamer, get the winner.
        List<BjGamer> winners = getResult();

        //Print final results
        for (BjGamer winner : winners) {
            System.out.printf("%s wins! Final score is %d \n", winner.name, winner.getScore());
        }

        System.out.println();
        System.out.println("The end!");
    }

    private void firstRound() {
        System.out.println("First Round Begin! \r\n");
        for (BjGamer gamer : gamers) {
            for (int i = 0; i < 2; i++) {
                Card card = manager.deal();
                gamer.addCard(card);
            }
            gamer.printTwoCards();
        }
        System.out.println();
    }

    private void secondRound() {
        System.out.println("Second Round Begin! \r\n");
        for (BjGamer gamer : gamers) {
            System.out.printf("%s's turn: \n", gamer.name);
            while (gamer.takeNext()) {
                Card card = manager.deal();
                gamer.addCard(card);
                System.out.printf("%s got a %s \n", gamer.name, card.getRank());
                if (gamer.isBurst()) {
                    System.out.printf("%s bust! \n", gamer.name);
                    break;
                }
            }
            System.out.println();
        }
    }

    private List<BjGamer> getResult() {
        int max = 0;
        List<BjGamer> winners = new ArrayList<>();
        for (BjGamer gamer : gamers) {
            if (!gamer.isBurst()) {
                int score = gamer.getScore();
                if (score > max) {
                    winners.clear();
                    winners.add(gamer);
                    max = score;
                } else if (score == max) {
                    winners.add(gamer);
                }
            }
        }
        return winners;
    }


}
