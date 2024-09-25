package Game;

import java.util.Scanner;

// Lógica do jogo
public class RaceGame {

    private final PlayerSelector playerSelector;
    private final Dice dice;

    //Intanciação das classes
    public RaceGame() {
        playerSelector = new PlayerSelector();
        dice = new Dice();
    }

    public void play() {
        Scanner sc = new Scanner(System.in);

        //Seleciona os jogadores
        Players player1 = playerSelector.choosePlayer(1, null, sc);
        Players player2 = playerSelector.choosePlayer(2, player1, sc);
        System.out.println("🏁🚩 A corrida entre " + player1.getName() + " e " + player2.getName() + " vai começar...");

        //Executa a corrida
        playRaceEngine(player1, player2);

        //Declara o vencedor
        declareWinner(player1, player2);
    }

    //Sortear bloco
    public String getRandomBlock() {
        double random = Math.random();

        if (random < 0.33) {
            return "RETA";
        } else if (random < 0.66) {
            return "CURVA";
        } else {
            return "CONFRONTO";
        }
    }

    public void playRaceEngine(Players player1, Players player2) {
        for (int round = 1; round <= 5; round++) {
            System.out.println("\n 🏁 Rodada " + round);

            //Sorteando bloco
            String block = getRandomBlock();
            System.out.println("Bloco " + block);

            //Rolar dados
            int diceResult1 = dice.rollDice();
            int diceResult2 = dice.rollDice();

            //Testando skills
            int totalSkill1 = calculateSkills(player1, diceResult1, block);
            int totalSkill2 = calculateSkills(player2, diceResult2, block);

            //Verifica se há confronto no bloco de confronto
            if (block.equals("CONFRONTO")) {
                confront(player1, player2, diceResult1, diceResult2);
            } else {
                //Apenas atualiza os pontos se o bloco não for confronto
                updatePoints(player1, player2, totalSkill1, totalSkill2);
            }
        }
    }

    public void declareWinner(Players player1, Players player2) {
        System.out.println("\nResultado final: ");
        System.out.println(player1.getName() + " " + player1.getPontos() + " ponto(s).");
        System.out.println(player2.getName() + " " + player2.getPontos() + " ponto(s).");

        if (player1.getPontos() > player2.getPontos()) {
            System.out.println(player1.getName() + " é o vencedor da corrida! 🏆");
        } else if (player2.getPontos() > player1.getPontos()) {
            System.out.println(player2.getName() + " é o vencedor da corrida! 🏆");
        } else {
            System.out.println("A corrida terminou em empate!");
        }
    }

    public int calculateSkills(Players player, int diceResult, String block) {
        int skillPoints;

        switch (block) {
            case "RETA":
                skillPoints = diceResult + player.getVelocidade();
                System.out.println(" 🎲 " + player.getName() + " rolou um dado de velocidade " + diceResult + " e adquiriu " + skillPoints + " ponto(s).");
                break;
            case "CURVA":
                skillPoints = diceResult + player.getManobrabilidade();
                System.out.println(" 🎲 " + player.getName() + " rolou um dado de manobrabilidade " + diceResult + " e adquiriu " + skillPoints + " ponto(s).");
                break;
            default:
                skillPoints = diceResult;
                break;
        }
        return skillPoints;
    }

    // Confronto
    private void confront(Players player1, Players player2, int diceResult1, int diceResult2) {
        //O uso da Math.max garante que não haja resultados negativos
        int powerResult1 = Math.max(0, diceResult1 + player1.getPoder());
        int powerResult2 = Math.max(0, diceResult2 + player2.getPoder());

        System.out.println(" 🥊 " + player1.getName() + " confrontou com " + player2.getName());

        //debugging
        System.out.println("Resultados: " + player1.getName() + " = " + powerResult1 + ", " + player2.getName() + " = " + powerResult2);

        if (powerResult1 > powerResult2) {
            System.out.println(player1.getName() + " venceu o confronto " + player2.getName() + " perdeu um ponto 🐢");
            player2.decPontos();
        } else if (powerResult2 > powerResult1) {
            System.out.println(player2.getName() + " venceu o confronto " + player1.getName() + " perdeu um ponto 🐢");
            player1.decPontos();
        } else {
            System.out.println("Confronto empatado. Nenhum ponto foi perdido!");
        }
    }

    //Atualizar os pontos dos jogadores
    public void updatePoints(Players player1, Players player2, int totalSkill1, int totalSkill2) {
        if (totalSkill1 > totalSkill2) {
            System.out.println(player1.getName() + " marcou um ponto");
            player1.incPontos();
        } else if (totalSkill2 > totalSkill1) {
            System.out.println(player2.getName() + " marcou um ponto");
            player2.incPontos();
        } else {
            System.out.println("Houve um empate. Nenhum jogador marcou ponto.");
        }
    }
}
