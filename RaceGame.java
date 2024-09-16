import java.util.Scanner;

public class RaceGame {

    public void showPlayers() {
        System.out.println("Escolha seus personagens: ");

        int index = 1;
        for (Players players : Players.values()) {
            System.out.println(index + ": " + players.getName());
            index++;
        }
    }

    public Players choosePlayers(int playerNumber) {
        Scanner sc = new Scanner(System.in);

        int playerIndex;
        Players chosenPlayer = null;

        while (chosenPlayer == null) {
            System.out.println("Escolha o personagem " + playerNumber + " (Digite o número correspondente): ");
            for (int i = 0; i < Players.values().length; i++) {
                System.out.println((i + 1) + ". " + Players.values()[i].getName());
            }

            String input = sc.nextLine();
            try {
                playerIndex = Integer.parseInt(input) - 1; // Ajusta o índice para começar de 0
                if (playerIndex >= 0 && playerIndex < Players.values().length) {
                    chosenPlayer = Players.values()[playerIndex];
                } else {
                    System.out.println("Opção inválida, tente novamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida, digite um número.");
            }
        }
        return chosenPlayer;
    }
}
