package Game;

import java.util.Scanner;

//Lógica de seleção de jogadores
public class PlayerSelector {

    public Players choosePlayer(int playerNumber, Players alreadyChosen, Scanner sc) {

        int playerIndex;
        Players chosenPlayer = null;

        do {
            System.out.println("Escolha o jogador " + playerNumber + " (Digite o número correspondente): ");
            for (int i = 0; i < Players.values().length; i++) {
                System.out.println((i + 1) + ". " + Players.values()[i].getName());
            }

            String input = sc.nextLine();
            try {
                playerIndex = Integer.parseInt(input) - 1; //Ajusta o índice para começar de 0
                if (playerIndex >= 0 && playerIndex < Players.values().length) {
                    chosenPlayer = Players.values()[playerIndex];

                    if (chosenPlayer.equals(alreadyChosen)) {
                        System.out.println("Este jogador já foi escolhido, escolha outro!");
                        chosenPlayer = null; // Reinicia a escolha
                    }

                } else {
                    System.out.println(" 🚫 Opção inválida, tente novamente.");
                }

            } catch (NumberFormatException e) {
                System.out.println(" 🚫 Entrada inválida, digite um número.");
            }
        } while (chosenPlayer == null); //O loop é executado até que um jogador válido seja escolhido
        return chosenPlayer;
    }
}