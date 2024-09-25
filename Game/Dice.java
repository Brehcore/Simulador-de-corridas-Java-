package Game;

public class Dice {

    public int rollDice() {
        return (int) Math.floor(Math.random() * 6) + 1;
    }
}
