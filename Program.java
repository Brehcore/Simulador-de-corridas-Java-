public class Program {
    public static void main(String[] args) {

        RaceGame game = new RaceGame();

        Players player1 = game.choosePlayers(1);
        Players player2 = game.choosePlayers(2);

        System.out.println("Players escolhinhos: Player 1: " + player1.getName() + " Player 2: " + player2.getName());

    }
}
