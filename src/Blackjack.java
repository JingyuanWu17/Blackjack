import People.Gamer;

//public class Blackjack {
    // Maintain game

//    boolean gameover;
//    boolean playerturn;
//
//    Card card;
//    Gamer player;
//    Gamer dealer;
//
//
//    public Blackjack() {
//        card = new Card();
//        player = new Player();
//        dealer = new Dealer();
//    }
//
//    public void startGame() {
//        gameover = false;
//        playerturn = true;
//
//        firstRound();
//        dealer.showCards();
//        player.showCards();
//
//        while (playerturn) {
//            // Each round, player can choose take card or not.
//            // isSurvive()?
//            //
//            playerturn = false;
//        }
//
//        while (dealer.count() <= 17) {
//            dealer.addCard(card.pop());
//        }
//
//        getResult();
//
//    }
//
//    private void firstRound() {
//        player.addCard(card.pop());
//        player.addCard(card.pop());
//        dealer.addCard(card.pop());
//        dealer.addCard(card.pop());
//    }
//
//    private void getResult() {
//        if (dealer.count() > 21) {
//            System.out.println("You win!");
//        } else if (dealer.count() > player.count()){
//            System.out.println("You lost!");
//        } else {
//            System.out.println("You win!");
//        }
//    }
//
//}
